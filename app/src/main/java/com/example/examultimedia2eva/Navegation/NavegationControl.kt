package com.example.examultimedia2eva.Navegation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.examultimedia2eva.ScreenPrincipal.ListadosApp
import com.example.examultimedia2eva.ScreenSegunda.FilasProcesadas
import androidx.navigation.compose.composable


@Composable
fun NavegationControl(){
    val navHostController  = rememberNavController()

    NavHost(navHostController, startDestination = AñadirScreens){
        composable<AñadirScreens>{
            ListadosApp(
                navigateToFilaProcesadaScreen = {navHostController.navigate(FilaProcesadaScreen)}
            )
        }

        composable<FilaProcesadaScreen>{
            FilasProcesadas(
                navigateToAñadirScreens = {navHostController.navigate(AñadirScreens)}
            )
        }
    }
}