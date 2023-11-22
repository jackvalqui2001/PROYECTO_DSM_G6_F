package com.example.proyecto_dsm_g7.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.proyecto_dsm_g7.Screens.*

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController= navController, startDestination = AppScreens.CondominioScreen.ruta){

        // CONDOMINIO
        composable(route= AppScreens.CondominioScreen.ruta){
            //CondominioScreen(navController)
        }

        // CASA
        composable(route= AppScreens.CasaScreen.ruta +
                "/{text}", arguments = listOf(navArgument(name = "text"){ type = NavType.StringType })
        ){
            //CasaScreen(navController, it.arguments?.getString("text"))
        }

        // RECIBO
        composable(route= AppScreens.ReciboScreen.ruta) {
            //ReciboScreen(navController)
        }

        // DETALLE
        composable(route= AppScreens.DetalleScreen.ruta + "/{text}",
            arguments = listOf(navArgument(name = "text"){
                type = NavType.StringType
            })
        ){
            //DetalleReciboScreen(navController, it.arguments?.getString("text"))
        }
    }
}