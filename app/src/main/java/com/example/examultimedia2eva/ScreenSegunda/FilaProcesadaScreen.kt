package com.example.examultimedia2eva.ScreenSegunda

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.examultimedia2eva.ScreenPrincipal.AñadirPViewModel


@Composable
fun FilasProcesadas(
    viewModel: AñadirPViewModel,
    navigateToAñadirScreens: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        val selectedPerson = viewModel.selectedPerson

        Text("Fila Procesada: ")

        selectedPerson?.let { Person ->
            Card(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Nombre: ${Person.name}")
                    Text("Edad: ${Person.age}")
                    Text("Código: ${Person.code}")
                }
            }
        } ?: Text("No hay ninguna fila seleccionada.")

        Button(onClick = {navigateToAñadirScreens()}) {
            Text("Volver al Listado")
        }
    }
}