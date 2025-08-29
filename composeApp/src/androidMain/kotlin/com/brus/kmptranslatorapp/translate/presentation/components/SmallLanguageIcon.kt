package com.brus.kmptranslatorapp.translate.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.brus.kmptranslatorapp.core.presentation.UILanguage

@Composable
fun SmallLanguageIcon(
    language: UILanguage,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(language.drawableRes),
        contentDescription = language.language.langName,
        modifier = modifier.size(25.dp)
    )
}