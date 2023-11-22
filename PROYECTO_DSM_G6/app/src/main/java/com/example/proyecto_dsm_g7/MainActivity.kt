package com.example.proyecto_dsm_g7

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.proyecto_dsm_g7.Screens.*
import com.example.proyecto_dsm_g7.data.DatabaseConnect
import com.example.proyecto_dsm_g7.navigation.AppScreens
import com.example.proyecto_dsm_g7.ui.theme.PROYECTO_DSM_G7Theme

class MainActivity : ComponentActivity() {
    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DatabaseConnect.init()
        setContent {
            PROYECTO_DSM_G7Theme {

                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(navController= navController, startDestination = AppScreens.CondominioScreen.ruta){

                        // CONDOMINIO
                        composable(route= AppScreens.CondominioScreen.ruta){
                            CondominioScreen(navController, ScreenViewModel(1,"2000-01-01","2024-12-31",1))
                        }

                        // CASA
                        composable(route= AppScreens.CasaScreen.ruta +
                                "/{idCondominio}", arguments = listOf(navArgument(name = "idCondominio"){ type = NavType.IntType })
                        ){
                            val idCondominio = it.arguments?.getInt("idCondominio")
                            requireNotNull(idCondominio)
                            CasaScreen(navController, ScreenViewModel(idCondominio,"2000-01-01","2024-12-31",1))
                        }

                        // RECIBO
                        composable(route= AppScreens.ReciboScreen.ruta + "/{idcasa}/{fechaInicio}/{fechaFin}/{estado}",
                            arguments = listOf(
                                navArgument(name = "idcasa"){ type = NavType.IntType },
                                navArgument(name = "fechaInicio") { type = NavType.StringType },
                                navArgument(name = "fechaFin") { type = NavType.StringType },
                                navArgument(name = "estado"){ type = NavType.IntType }
                            )
                        ) {
                            val idcasa = it.arguments?.getInt("idcasa")
                            val fechaInicio = it.arguments?.getString("fechaInicio")
                            val fechaFin = it.arguments?.getString("fechaFin")
                            val estado = it.arguments?.getInt("estado")
                            requireNotNull(idcasa)
                            requireNotNull(fechaInicio)
                            requireNotNull(fechaFin)
                            requireNotNull(estado)
                            ReciboScreen(navController, ScreenViewModel(idcasa,fechaInicio,fechaFin,estado))
                            //"2023-01-01" "2023-06-30"
                        }

                        // DETALLE
                        composable(route= AppScreens.DetalleScreen.ruta +
                                "/{idmantenimiento}/{subtotal}",
                            arguments = listOf(
                                navArgument(name = "idmantenimiento"){ type = NavType.IntType },
                                navArgument(name = "subtotal"){ type = NavType.IntType }
                            )
                        ){
                            val idmantenimiento = it.arguments?.getInt("idmantenimiento")
                            val subtotal = it.arguments?.getInt("subtotal")
                            requireNotNull(idmantenimiento)
                            requireNotNull(subtotal)
                            DetalleReciboScreen(navController, ScreenViewModel(idmantenimiento,"2000-01-01","2024-12-31",1),subtotal)
                        }

                        composable(route = AppScreens.MapsScreen.ruta){
                            MapsScreen()
                        }
                    }
                }
            }
        }
    }
}



