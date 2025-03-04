package com.example.examultimedia2eva.ScreenPrincipal

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.examultimedia2eva.Navegation.FilaProcesadaScreen
import com.example.examultimedia2eva.Navegation.NavegationControl
import com.example.examultimedia2eva.data.Person

@Composable
fun ListadosApp(
    viewModel: AñadirPViewModel = viewModel(),
    navigateToFilaProcesadaScreen: (Person) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { viewModel.addPerson() }) {
            Text("Añadir Filas")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(viewModel.peopleList) { person ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable { navigateToFilaProcesadaScreen(person) } // Se eliminó la dependencia del ViewModel
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth().padding(8.dp)
                    ) {
                        Text(text = person.name)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = person.age.toString())
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = person.code.toString())
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPersonScreen() {
    NavegationControl()
}

