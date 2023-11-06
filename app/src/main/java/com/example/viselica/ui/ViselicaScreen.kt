package com.example.viselica.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.viselica.R
import com.example.viselica.ui.theme.ViselicaTheme
// импорт для использования viewmodel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ViselicaScreen(
    viselicaAlphabetViewModel: ViselicaAlphabetViewModel = viewModel(),
    // передаем экземпляр ViewModel в пользовательский интерфейс
    viselicaViewModel: ViselicaViewModel = viewModel(),
    modifier: Modifier = Modifier
){
    // создаем переменную, которая собирает состояния что обеспечивает
    // перекомпозицию компонуемых обьектов при изменении стейт
    val viselicaUiState by viselicaViewModel.uiState.collectAsState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        //VicelicaImage(R.drawable.pic1)
        VicelicaTextQuestion(
            viselicaUiState.picGame,
            questionText = viselicaUiState.encryptQuestionWord
        )
        Spacer(modifier = Modifier.size(30.dp))
        ViselicaAlphabet(viselicaViewModel)
        Spacer(modifier = Modifier.size(30.dp))
        ViselicaButtonGame()
    }
}


@Composable
fun VicelicaTextQuestion(
    @DrawableRes pic: Int,
    questionText: String,
    modifier: Modifier = Modifier
){
    Image(
        painter = painterResource(id = pic), //R.drawable.pic7),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .padding(8.dp)
            .size(250.dp)
    )
    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        border = BorderStroke(1.dp, Color.Black),
        modifier = Modifier
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            questionText.toCharArray().forEach {
                Text(
                    text = it.toString(),
                    fontSize = 30.sp,
                    letterSpacing = 15.0.sp
                )
            }
        }
    }
}

@Composable
fun ViselicaAlphabet(
    viselicaViewModel: ViselicaViewModel,
    modifier: Modifier = Modifier
){
    val viselicaUiAlphabet1 by viselicaViewModel.uiAlphabet1.collectAsState()
    val viselicaUiAlphabet2 by viselicaViewModel.uiAlphabet2.collectAsState()
    val viselicaUiAlphabet3 by viselicaViewModel.uiAlphabet3.collectAsState()
    val viselicaUiAlphabet4 by viselicaViewModel.uiAlphabet4.collectAsState()
    val viselicaUiAlphabet5 by viselicaViewModel.uiAlphabet5.collectAsState()
    val viselicaUiAlphabet6 by viselicaViewModel.uiAlphabet6.collectAsState()
    val viselicaUiAlphabet7 by viselicaViewModel.uiAlphabet7.collectAsState()
    val viselicaUiAlphabet8 by viselicaViewModel.uiAlphabet8.collectAsState()
    val viselicaUiAlphabet9 by viselicaViewModel.uiAlphabet9.collectAsState()
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
        ),
        modifier = modifier
            .padding(2.dp)
            .fillMaxWidth()
    ){
        Column (
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ){
                ViselicaOutlineButton({ viselicaViewModel.checkPressChar1() }, viselicaUiAlphabet1.enebledButton, viselicaUiAlphabet1.alphabetChar, viselicaUiAlphabet1.colorText)
                ViselicaOutlineButton({ viselicaViewModel.checkPressChar2() }, viselicaUiAlphabet2.enebledButton, viselicaUiAlphabet2.alphabetChar, viselicaUiAlphabet2.colorText)
                ViselicaOutlineButton({ viselicaViewModel.checkPressChar3() }, viselicaUiAlphabet3.enebledButton, viselicaUiAlphabet3.alphabetChar, viselicaUiAlphabet3.colorText)
                ViselicaOutlineButton({ viselicaViewModel.checkPressChar4() }, viselicaUiAlphabet4.enebledButton, viselicaUiAlphabet4.alphabetChar, viselicaUiAlphabet4.colorText)
                ViselicaOutlineButton({ viselicaViewModel.checkPressChar5() }, viselicaUiAlphabet5.enebledButton, viselicaUiAlphabet5.alphabetChar, viselicaUiAlphabet5.colorText)
                ViselicaOutlineButton({ viselicaViewModel.checkPressChar6() }, viselicaUiAlphabet6.enebledButton, viselicaUiAlphabet6.alphabetChar, viselicaUiAlphabet6.colorText)
                ViselicaOutlineButton({ viselicaViewModel.checkPressChar7() }, viselicaUiAlphabet7.enebledButton, viselicaUiAlphabet7.alphabetChar, viselicaUiAlphabet7.colorText)
                ViselicaOutlineButton({ viselicaViewModel.checkPressChar8() }, viselicaUiAlphabet8.enebledButton, viselicaUiAlphabet8.alphabetChar, viselicaUiAlphabet8.colorText)
                ViselicaOutlineButton({ viselicaViewModel.checkPressChar9() }, viselicaUiAlphabet9.enebledButton, viselicaUiAlphabet9.alphabetChar, viselicaUiAlphabet9.colorText)

            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ){
                OutlinedButton (onClick = { viselicaViewModel.checkPressChar1() },enabled = true, contentPadding = PaddingValues(0.dp), modifier = Modifier.size(32.dp),
                ){Text(text = "К")}
                OutlinedButton (onClick = { viselicaViewModel.checkPressChar1() },enabled = false, contentPadding = PaddingValues(0.dp), modifier = Modifier.size(32.dp),
                ){Text(text = "Л", color = Color.Green)}
                OutlinedButton (onClick = { viselicaViewModel.checkPressChar1() },enabled = true, contentPadding = PaddingValues(0.dp), modifier = Modifier.size(32.dp),
                ){Text(text = "М")}
                OutlinedButton (onClick = { viselicaViewModel.checkPressChar1() },enabled = true, contentPadding = PaddingValues(0.dp), modifier = Modifier.size(32.dp),
                ){Text(text = "Н")}
                OutlinedButton (onClick = { viselicaViewModel.checkPressChar1() },enabled = true, contentPadding = PaddingValues(0.dp), modifier = Modifier.size(32.dp),
                ){Text(text = "О")}
                OutlinedButton (onClick = { viselicaViewModel.checkPressChar1() },enabled = true, contentPadding = PaddingValues(0.dp), modifier = Modifier.size(32.dp),
                ){Text(text = "П")}
                OutlinedButton (onClick = { viselicaViewModel.checkPressChar1() },enabled = true, contentPadding = PaddingValues(0.dp), modifier = Modifier.size(32.dp),
                ){Text(text = "Р")}
                OutlinedButton (onClick = { viselicaViewModel.checkPressChar1() },enabled = false, contentPadding = PaddingValues(0.dp), modifier = Modifier.size(32.dp),
                ){Text(text = "С", color = Color.Green)}
                OutlinedButton (onClick = { viselicaViewModel.checkPressChar1() },enabled = true, contentPadding = PaddingValues(0.dp), modifier = Modifier.size(32.dp),
                ){Text(text = "Т")}
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ){
                OutlinedButton (onClick = { viselicaViewModel.checkPressChar1() },enabled = true, contentPadding = PaddingValues(0.dp), modifier = Modifier.size(32.dp),
                ){Text(text = "У")}
                OutlinedButton (onClick = { viselicaViewModel.checkPressChar1() },enabled = true, contentPadding = PaddingValues(0.dp), modifier = Modifier.size(32.dp),
                ){Text(text = "Ф")}
                OutlinedButton (onClick = { viselicaViewModel.checkPressChar1() },enabled = true, contentPadding = PaddingValues(0.dp), modifier = Modifier.size(32.dp),
                ){Text(text = "Х")}
                OutlinedButton (onClick = { viselicaViewModel.checkPressChar1() },enabled = true, contentPadding = PaddingValues(0.dp), modifier = Modifier.size(32.dp),
                ){Text(text = "Ш")}
                OutlinedButton (onClick = { viselicaViewModel.checkPressChar1() },enabled = true, contentPadding = PaddingValues(0.dp), modifier = Modifier.size(32.dp),
                ){Text(text = "Ь")}
                OutlinedButton (onClick = { viselicaViewModel.checkPressChar1() },enabled = true, contentPadding = PaddingValues(0.dp), modifier = Modifier.size(32.dp),
                ){Text(text = "Ы")}
                OutlinedButton (onClick = { viselicaViewModel.checkPressChar1() },enabled = true, contentPadding = PaddingValues(0.dp), modifier = Modifier.size(32.dp),
                ){Text(text = "Э")}
                OutlinedButton (onClick = { viselicaViewModel.checkPressChar1() },enabled = true, contentPadding = PaddingValues(0.dp), modifier = Modifier.size(32.dp),
                ){Text(text = "Ю")}
                OutlinedButton (onClick = { viselicaViewModel.checkPressChar1() },enabled = true, contentPadding = PaddingValues(0.dp), modifier = Modifier.size(32.dp),
                ){Text(text = "Я")}
            }
        }
    }
}

@Composable
fun ViselicaOutlineButton(
    onClick: () -> Unit,
    sost: Boolean,
    text: String,
    col: Color
){
    OutlinedButton (onClick = { onClick },enabled = sost, contentPadding = PaddingValues(0.dp), modifier = Modifier.size(32.dp),
    ){Text(text = text, color = col)}
}

@Composable
fun ViselicaButtonGame(modifier: Modifier = Modifier){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
    ){
        Button(onClick = { TODO() }){
            Text(text = stringResource(R.string.button_next))
        }
        Button(onClick = { TODO() }){
            Text(text = stringResource(R.string.button_repeat))
        }
    }
}

@Preview
@Composable
fun ElemPreview(){
    ViselicaTheme {
        ViselicaScreen()
    }
}

