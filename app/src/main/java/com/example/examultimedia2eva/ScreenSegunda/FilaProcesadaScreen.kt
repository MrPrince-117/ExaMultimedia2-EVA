package com.example.examultimedia2eva.ScreenSegunda

import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview



@Composable
fun FilasProcesadas(navigateToAñadirScreens: () -> Unit) {

    Card (){

    }

    Button(onClick = {navigateToAñadirScreens}) {
        Text("Volver al Listado")
    }
}