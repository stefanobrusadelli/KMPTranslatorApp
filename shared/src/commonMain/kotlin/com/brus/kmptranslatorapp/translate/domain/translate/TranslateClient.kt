package com.brus.kmptranslatorapp.translate.domain.translate

import com.brus.kmptranslatorapp.core.domain.language.Language

interface TranslateClient {
    suspend fun translate(
        fromLanguage: Language,
        fromText: String,
        toLanguage: Language
    ): String
}