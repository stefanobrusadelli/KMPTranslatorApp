package com.brus.kmptranslatorapp.translate.presentation

import com.brus.kmptranslatorapp.core.presentation.UILanguage

data class UIHistoryItem(
    val id: Long,
    val fromText: String,
    val toText: String,
    val fromLanguage: UILanguage,
    val toLanguage: UILanguage
)
