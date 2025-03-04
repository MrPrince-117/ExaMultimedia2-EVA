package com.example.examultimedia2eva.ScreenSegunda

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.examultimedia2eva.ScreenPrincipal.AñadirPViewModel


@Composable
fun FilasProcesadas(
    viewModel: AñadirPViewModel,
    navigateToAñadirScreens: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val selectedPerson = viewModel.selectedPerson

        Text("Fila Procesada:", fontWeight = FontWeight.Bold)

        selectedPerson?.let { person ->
            Card(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Nombre: ${person.name}")
                    Text("Edad: ${person.age}")
                    Text("Código: ${person.code}")
                }
            }
        } ?: Text("No hay ninguna fila seleccionada.")

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navigateToAñadirScreens() }) {
            Text("Volver al Listado")
        }
    }
}
