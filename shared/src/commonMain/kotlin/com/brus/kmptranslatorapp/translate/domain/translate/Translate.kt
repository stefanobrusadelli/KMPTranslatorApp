package com.brus.kmptranslatorapp.translate.domain.translate

import com.brus.kmptranslatorapp.core.domain.language.Language
import com.brus.kmptranslatorapp.core.domain.util.Resource
import com.brus.kmptranslatorapp.translate.domain.history.HistoryDataSource
import com.brus.kmptranslatorapp.translate.domain.history.HistoryItem

class Translate(
    private val client: TranslateClient,
    private val historyDataSource: HistoryDataSource
) {
    suspend fun execute(
        fromLanguage: Language,
        fromText: String,
        toLanguage: Language
    ): Resource<String> {
        return try {
            val translatedText = client.translate(
                fromLanguage, fromText, toLanguage
            )

            historyDataSource.insertHistoryItem(
                HistoryItem(
                    id = null,
                    fromLanguageCode = fromLanguage.langCode,
                    fromText = fromText,
                    toLanguageCode = toLanguage.langCode,
                    toText = translatedText
                )
            )

            Resource.Success(translatedText)
        } catch (e: TranslateException) {
            e.printStackTrace()
            Resource.Error(e)
        }
    }
}