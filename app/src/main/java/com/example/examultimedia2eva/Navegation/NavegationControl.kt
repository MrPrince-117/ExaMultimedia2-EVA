package com.example.examultimedia2eva.Navegation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.examultimedia2eva.ScreenPrincipal.ListadosApp
import com.example.examultimedia2eva.ScreenSegunda.FilasProcesadas
import androidx.navigation.compose.composable
import com.example.examultimedia2eva.data.Person


@Composable
fun NavegationControl() {
    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = "listado") {
        composable("listado") {
            ListadosApp(
                navigateToFilaProcesadaScreen = { person ->
                    navHostController.currentBackStackEntry?.savedStateHandle?.set("selectedPerson", person)
                    navHostController.navigate("filaProcesada")
                }
            )
        }

        composable("filaProcesada") {
            val person = navHostController.previousBackStackEntry
                ?.savedStateHandle
                ?.get<Person>("selectedPerson")

            FilasProcesadas(
                person = person,
                navigateToAñadirScreens = { navHostController.popBackStack() }
            )
        }
    }
}
