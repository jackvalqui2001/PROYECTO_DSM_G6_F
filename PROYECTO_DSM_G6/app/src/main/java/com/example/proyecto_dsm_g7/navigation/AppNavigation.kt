package com.example.proyecto_dsm_g7.navigation

import androidx.compose.runtime.Composable
import com.example.proyecto_dsm_g7.Screens.ScreenViewModel

@Composable
fun AppNavigation(viewModel: ScreenViewModel){
    /*val navController = rememberNavController()

    NavHost(navController= navController, startDestination = AppScreens.CondominioScreen.ruta){

        // CONDOMINIO
        composable(route= AppScreens.CondominioScreen.ruta){
            CondominioScreen(navController, viewModel)
        }

        // CASA
        composable(route= AppScreens.CasaScreen.ruta +
                "/{text}", arguments = listOf(navArgument(name = "idCondominio"){ type = NavType.IntType})
        ){
            /*CasaScreen(navController, it.arguments?.getInt("idCondominio"),viewModel)*/
        }

        // RECIBO
        composable(route= AppScreens.ReciboScreen.ruta) {
            ReciboScreen(navController)
        }

        // DETALLE
        composable(route= AppScreens.DetalleScreen.ruta + "/{text}",
            arguments = listOf(navArgument(name = "text"){
                type = NavType.StringType
            })
        ){
            DetalleReciboScreen()
            //navController, it.arguments?.getString("text")
        }

        //Maps
        composable(route = AppScreens.MapsScreen.ruta){
            MapsScreen()
        }
    }*/
}