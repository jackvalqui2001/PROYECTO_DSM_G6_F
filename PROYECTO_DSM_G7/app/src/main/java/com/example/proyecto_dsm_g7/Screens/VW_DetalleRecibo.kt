package com.example.proyecto_dsm_g7.Screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.proyecto_dsm_g7.R
import com.example.proyecto_dsm_g7.navigation.AppScreens

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetalleReciboScreen(navController: NavController, text: String?) {

    Scaffold(
        bottomBar = {
            ButtonRowDetalle(navController)
        }
    ) {
        BodyContentDetalle(navController, text)
    }
}

@Composable
fun BodyContentDetalle(navController: NavController, text: String?){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Hola RECIBO")
        text?.let {
            Text(it)
        }
        Button(onClick = {
            navController.navigate(route = AppScreens.ReciboScreen.ruta)
        }){
            Text("Navega")
        }
    }
}

// ------------------------- INFERIOR -----------------------------
@Composable
fun ButtonRowDetalle(navController: NavController){
    val context = LocalContext.current

    BottomAppBar {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ButtonWithImageDetalle(
                buttonText = "Condominios",
                imageRes = R.drawable.condominio,
                textColor = Color.Black,
                onClick = { navController.navigate(route = AppScreens.CondominioScreen.ruta) }
            )
            ButtonWithImageDetalle(
                buttonText = "Casas",
                imageRes = R.drawable.casas,
                textColor = Color.Black,
                onClick = { navController.navigate(route = AppScreens.CasaScreen.ruta + "/Este es un parámetro") }
            )
            ButtonWithImageDetalle(
                buttonText = "Recibo",
                imageRes = R.drawable.recibo,
                textColor = Color.Black,
                onClick = { navController.navigate(route = AppScreens.ReciboScreen.ruta) }
            )
            ButtonWithImageDetalle(
                buttonText = "Detalle",
                imageRes = R.drawable.detalle,
                textColor = Color.Red,
                onClick = { Toast.makeText(context, "Se encuentra aquí", Toast.LENGTH_SHORT).show() }
            )
        }
    }
}

@Composable
fun ButtonWithImageDetalle(buttonText: String, imageRes: Int, textColor: Color, onClick: () -> Unit){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier.size(20.dp)
        )
        Text(
            text = buttonText,
            fontSize = 12.sp,
            color = textColor,
            modifier = Modifier.clickable { onClick() }
        )
    }
}