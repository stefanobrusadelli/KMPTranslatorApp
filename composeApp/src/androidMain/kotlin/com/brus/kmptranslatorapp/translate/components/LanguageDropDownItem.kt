package com.brus.kmptranslatorapp.translate.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.brus.kmptranslatorapp.core.presentation.UILanguage

@Composable
fun LanguageDropDownItem(
    language: UILanguage,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    DropdownMenuItem(
        text = {
            Text(language.language.langName)
        },
        leadingIcon = {
            Image(
                painter = painterResource(language.drawableRes),
                contentDescription = language.language.langName,
                modifier = Modifier.size(40.dp)
            )
        },
        onClick = onClick,
        modifier = modifier
    )
}