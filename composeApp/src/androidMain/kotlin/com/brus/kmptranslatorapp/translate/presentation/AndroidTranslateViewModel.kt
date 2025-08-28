package com.brus.kmptranslatorapp.translate.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brus.kmptranslatorapp.translate.domain.history.HistoryDataSource
import com.brus.kmptranslatorapp.translate.domain.translate.Translate
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AndroidTranslateViewModel @Inject constructor(
    private val translate: Translate,
    private val historyDataSource: HistoryDataSource
): ViewModel() {

    private val viewModel by lazy {
        TranslateViewModel(
            translate = translate,
            historyDataSource = historyDataSource,
            coroutineScope = viewModelScope
        )
    }

    val state = viewModel.state

    fun onEvent(event: TranslateEvent) {
        viewModel.onEvent(event)
    }
}