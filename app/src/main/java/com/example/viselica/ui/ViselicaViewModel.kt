package com.example.viselica.ui

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.viselica.R
import com.example.viselica.data.wordGame
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ViselicaViewModel: ViewModel() {
    // наблюдаемый поток держателя данных, который генерирует текущие и новые обновления состояния
    // мутабл - изменяемый, чтобы при перерисовке сохранялось значение
    private val _uiState = MutableStateFlow(ViselicaUiState())
    private val _uiAlphabet1 = MutableStateFlow(ViselicaUiAlphabet())
    private val _uiAlphabet2 = MutableStateFlow(ViselicaUiAlphabet())
    private val _uiAlphabet3 = MutableStateFlow(ViselicaUiAlphabet())
    private val _uiAlphabet4 = MutableStateFlow(ViselicaUiAlphabet())
    private val _uiAlphabet5 = MutableStateFlow(ViselicaUiAlphabet())
    private val _uiAlphabet6 = MutableStateFlow(ViselicaUiAlphabet())
    private val _uiAlphabet7 = MutableStateFlow(ViselicaUiAlphabet())
    private val _uiAlphabet8 = MutableStateFlow(ViselicaUiAlphabet())
    private val _uiAlphabet9 = MutableStateFlow(ViselicaUiAlphabet())
    // свойство для чтения потока
    // Это asStateFlow()делает этот изменяемый поток состояний потоком состояний, доступным только для чтения
    // asStateFlow() обирает состояния для передачи в отображение
    val uiState: StateFlow<ViselicaUiState> = _uiState.asStateFlow()
    val uiAlphabet1: StateFlow<ViselicaUiAlphabet> = _uiAlphabet1.asStateFlow()
    val uiAlphabet2: StateFlow<ViselicaUiAlphabet> = _uiAlphabet2.asStateFlow()
    val uiAlphabet3: StateFlow<ViselicaUiAlphabet> = _uiAlphabet3.asStateFlow()
    val uiAlphabet4: StateFlow<ViselicaUiAlphabet> = _uiAlphabet4.asStateFlow()
    val uiAlphabet5: StateFlow<ViselicaUiAlphabet> = _uiAlphabet5.asStateFlow()
    val uiAlphabet6: StateFlow<ViselicaUiAlphabet> = _uiAlphabet6.asStateFlow()
    val uiAlphabet7: StateFlow<ViselicaUiAlphabet> = _uiAlphabet7.asStateFlow()
    val uiAlphabet8: StateFlow<ViselicaUiAlphabet> = _uiAlphabet8.asStateFlow()
    val uiAlphabet9: StateFlow<ViselicaUiAlphabet> = _uiAlphabet9.asStateFlow()
    // свойство хранения выбранного слова
    private lateinit var selectedWord: String
    // свойство хранения шифра выбранного слова
    //private lateinit var encryptSelectedWord: String
    // набор для хранения использованных слов
    private var usedWord: MutableSet<String> = mutableSetOf()
    // создаем свойство хранения стейджа игры и свойство id картинки
    private var stageGame: Int = 0
    private var picGame: Int = 0


    // Функция конструктор
    /*
    * вызывает метод иницииализации новых значений для игры
    * */
    init { resetGame()}

    // Функция выбора слова для игры, возвращает стринг(слово)
    /*
    * Выбирается слово из списка
    * Проверяется было ли такое слово уже в игре
    * если было, запускается рекурсив
    * если не было выбранное слово добавляется в список слов игры и возвращается функцией
    * */
    private fun pickRandomWord(): String{
        selectedWord = wordGame.random()
        if (usedWord.contains(selectedWord)) {
            return pickRandomWord()
        } else {
            usedWord.add(selectedWord)
            encryptRandomWord()
            return selectedWord
        }
    }

    // Функция шифровки выбранного слова для игры, возвращает стринг(шифр)
    /*
    * строка заполняется звездочкой (*) n раз равной количеству символов selectedWord
    * */
    private fun encryptRandomWord(): String{ return "*".repeat(selectedWord.length) }
    //encryptSelectedWord = "*".repeat(selectedWord.length)
    //return encryptSelectedWord

    // Функция сброса игры
    /*
    * обнуляем использованные слова, инициируем VisekicaUiState новыми значениями
    * так же функция нужна для новой игры
    * */
    private fun changePic(): Int{
        return when (stageGame) {
            0 -> R.drawable.pic0
            1 -> R.drawable.pic1
            2 -> R.drawable.pic2
            3 -> R.drawable.pic3
            4 -> R.drawable.pic4
            5 -> R.drawable.pic5
            6 -> R.drawable.pic6
            else -> R.drawable.pic7
        }
    }

    // Функция сброса игры
    /*
    * обнуляем использованные слова, инициируем VisekicaUiState новыми значениями
    * так же функция нужна для новой игры
    * */
    private fun resetGame(){
        usedWord.clear()
        _uiState.value = ViselicaUiState(pickRandomWord(),encryptRandomWord(), 0, changePic())
        _uiAlphabet1.value = ViselicaUiAlphabet("А", true, Color.Black)
        _uiAlphabet2.value = ViselicaUiAlphabet("Б", true, Color.Black)
        _uiAlphabet3.value = ViselicaUiAlphabet("В", true, Color.Black)
        _uiAlphabet4.value = ViselicaUiAlphabet("Г", true, Color.Black)
        _uiAlphabet5.value = ViselicaUiAlphabet("Д", true, Color.Black)
        _uiAlphabet6.value = ViselicaUiAlphabet("Е", true, Color.Black)
        _uiAlphabet7.value = ViselicaUiAlphabet("Ж", true, Color.Black)
        _uiAlphabet8.value = ViselicaUiAlphabet("З", true, Color.Black)
        _uiAlphabet9.value = ViselicaUiAlphabet("И", true, Color.Black)
    }

    // Функция проверки нажатой буквы
    /*
    * принимаем букву, проверяем есть ли она
    * пересобираем слово шифр
    * если слова нет, повышаем уровень игры
    * */
    fun checkPressChar1() {

    }
    // Функция проверки нажатой буквы
    /*
    * принимаем букву, проверяем есть ли она
    * пересобираем слово шифр
    * если слова нет, повышаем уровень игры
    * */
    fun checkPressChar2() {

    }
    // Функция проверки нажатой буквы
    /*
    * принимаем букву, проверяем есть ли она
    * пересобираем слово шифр
    * если слова нет, повышаем уровень игры
    * */
    fun checkPressChar3() {

    }
    // Функция проверки нажатой буквы
    /*
    * принимаем букву, проверяем есть ли она
    * пересобираем слово шифр
    * если слова нет, повышаем уровень игры
    * */
    fun checkPressChar4() {

    }
    // Функция проверки нажатой буквы
    /*
    * принимаем букву, проверяем есть ли она
    * пересобираем слово шифр
    * если слова нет, повышаем уровень игры
    * */
    fun checkPressChar5() {

    }
    // Функция проверки нажатой буквы
    /*
    * принимаем букву, проверяем есть ли она
    * пересобираем слово шифр
    * если слова нет, повышаем уровень игры
    * */
    fun checkPressChar6() {

    }
    // Функция проверки нажатой буквы
    /*
    * принимаем букву, проверяем есть ли она
    * пересобираем слово шифр
    * если слова нет, повышаем уровень игры
    * */
    fun checkPressChar7() {

    }
    // Функция проверки нажатой буквы
    /*
    * принимаем букву, проверяем есть ли она
    * пересобираем слово шифр
    * если слова нет, повышаем уровень игры
    * */
    fun checkPressChar8() {

    }
    // Функция проверки нажатой буквы
    /*
    * принимаем букву, проверяем есть ли она
    * пересобираем слово шифр
    * если слова нет, повышаем уровень игры
    * */
    fun checkPressChar9() {

    }

}