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
import com.example.examultimedia2eva.data.Person


@Composable
fun FilasProcesadas(
    person: Person?,
    navigateToAñadirScreens: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Fila Procesada:", fontWeight = FontWeight.Bold)

        person?.let {
            Card(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Nombre: ${it.name}")
                    Text("Edad: ${it.age}")
                    Text("Código: ${it.code}")
                }
            }
        } ?: Text("No hay ninguna fila seleccionada.")

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navigateToAñadirScreens() }) {
            Text("Volver al Listado")
        }
    }
}
