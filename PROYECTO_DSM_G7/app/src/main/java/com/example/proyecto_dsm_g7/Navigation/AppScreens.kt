package com.example.proyecto_dsm_g7.navigation

sealed class AppScreens(val ruta: String){
    object FirstScreen: AppScreens("first_screen")
    object SecondScreen: AppScreens("second_screen")

    object  CondominioScreen: AppScreens("VW_Condominio")
    object  CasaScreen: AppScreens("VW_Casa")
    object  DetalleScreen: AppScreens("VW_Detalle")
    object  ReciboScreen: AppScreens("VW_Recibo")
}
