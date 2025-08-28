package com.brus.kmptranslatorapp.translate.presentation

import com.brus.kmptranslatorapp.core.presentation.UILanguage
import com.brus.kmptranslatorapp.translate.domain.translate.TranslateError

data class TranslateState(
    val fromText: String = "",
    val toText: String? = null,
    val isTranslating: Boolean = false,
    val fromLanguage: UILanguage = UILanguage.byCode("en"),
    val toLanguage: UILanguage = UILanguage.byCode("de"),
    val isChoosingFromLanguage: Boolean = false,
    val isChoosingToLanguage: Boolean = false,
    val error: TranslateError? = null,
    val history: List<UIHistoryItem> = emptyList()
)
