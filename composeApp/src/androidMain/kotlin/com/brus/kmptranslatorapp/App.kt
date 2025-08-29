package com.brus.kmptranslatorapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.brus.kmptranslatorapp.core.presentation.Routes
import com.brus.kmptranslatorapp.core.theme.TranslatorTheme
import com.brus.kmptranslatorapp.translate.presentation.AndroidTranslateViewModel
import com.brus.kmptranslatorapp.translate.presentation.TranslateScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    TranslatorTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            TranslateRoot()
        }
    }
}

@Composable
fun TranslateRoot() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Routes.TRANSLATE) {
        composable(Routes.TRANSLATE) {
            val viewModel = hiltViewModel<AndroidTranslateViewModel>()
            val state by viewModel.state.collectAsStateWithLifecycle()
            TranslateScreen(
                state = state,
                onEvent = viewModel::onEvent
            )
        }
    }
}