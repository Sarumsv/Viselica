package com.example.viselica.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ViselicaAlphabetViewModel: ViewModel() {
    // изменяемый наблюдаемый поток держателя данных генерирующий текущие и новые состояния
    private val _uiAlphabet = MutableStateFlow(ViselicaUiAlphabet())
    // свойство для чтения потока (только чтение
    val uiAlphabet: StateFlow<ViselicaUiAlphabet> = _uiAlphabet.asStateFlow()


}