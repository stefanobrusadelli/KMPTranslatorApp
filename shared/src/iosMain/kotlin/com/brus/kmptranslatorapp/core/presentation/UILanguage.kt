package com.brus.kmptranslatorapp.core.presentation

import com.brus.kmptranslatorapp.core.domain.language.Language

actual class UILanguage(
    actual val language: Language,
    val imageName: String
) {
    actual companion object {
        actual fun byCode(langCode: String): UILanguage {
            return allLanguages.find { it.language.langCode == langCode } ?: throw IllegalArgumentException("Invalid or unsupported language code.")
        }

        actual val allLanguages: List<UILanguage>
            get() = Language.entries.map { language ->
                UILanguage(
                    language = language,
                    imageName = language.langName.lowercase()
                )
            }
    }
}