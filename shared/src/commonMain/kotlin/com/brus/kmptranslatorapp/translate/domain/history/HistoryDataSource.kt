package com.brus.kmptranslatorapp.translate.domain.history

import com.brus.kmptranslatorapp.core.domain.util.CommonFlow

interface HistoryDataSource {
    fun getHistory(): CommonFlow<List<HistoryItem>>
    suspend fun insertHistoryItem(item: HistoryItem)
}