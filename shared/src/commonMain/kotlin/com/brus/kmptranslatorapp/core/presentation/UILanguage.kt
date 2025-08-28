package com.brus.kmptranslatorapp.core.presentation

import com.brus.kmptranslatorapp.core.domain.language.Language

expect class UILanguage {
    val language: Language
    companion object {
        fun byCode(langCode: String): UILanguage
        val allLanguages: List<UILanguage>
    }
}
