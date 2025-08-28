package com.brus.kmptranslatorapp.translate.data

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.brus.kmptranslatorapp.core.domain.util.CommonFlow
import com.brus.kmptranslatorapp.core.domain.util.toCommonFlow
import com.brus.kmptranslatorapp.database.TranslateDatabase
import com.brus.kmptranslatorapp.translate.domain.history.HistoryDataSource
import com.brus.kmptranslatorapp.translate.domain.history.HistoryItem
import com.brus.kmptranslatorapp.translate.domain.history.toHistoryItem
import kotlinx.coroutines.flow.map
import kotlin.coroutines.CoroutineContext
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
class SqlDelightHistoryDataSource(
    db: TranslateDatabase,
    private val coroutineContext: CoroutineContext
): HistoryDataSource {

    private val queries = db.translateQueries

    override fun getHistory(): CommonFlow<List<HistoryItem>> {
        return queries
            .getHistory()
            .asFlow()
            .mapToList(coroutineContext)
            .map { history ->
                history.map { it.toHistoryItem() }
            }
            .toCommonFlow()
    }

    override suspend fun insertHistoryItem(item: HistoryItem) {
        queries.insertHistoryEntity(
            id = item.id,
            fromLanguageCode = item.fromLanguageCode,
            fromText = item.fromText,
            toLanguageCode = item.toLanguageCode,
            toText = item.toText,
            timestamp = Clock.System.now().toEpochMilliseconds()
        )
    }
}