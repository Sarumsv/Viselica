package com.example.viselica.ui

data class ViselicaUiState (
    // текущее зашифрованное слово
    val questionWord: String = "",
    val encryptQuestionWord: String = "",
    val stageGame: Int = 0,
    val picGame: Int = 0
)