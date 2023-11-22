package com.example.tabs_prueba.Tabs

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.proyecto_dsm_g7.R
import com.example.proyecto_dsm_g7.Screens.ScreenViewModel
import com.example.proyecto_dsm_g7.data.model.CasaCancelado
import com.example.proyecto_dsm_g7.data.model.CasaPorpagar
import com.example.proyecto_dsm_g7.navigation.AppScreens


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CANCELADO (
    modifier: Modifier,
    navController: NavController,
    screenViewModel: ScreenViewModel,
    fechaI: String,
    fechaF: String
){

    val listaCasa : List<CasaCancelado> by screenViewModel.listaCasaCancelado.observeAsState(initial = emptyList())

    Card(
        modifier = modifier
    ) {
        Row (modifier = modifier.fillMaxWidth()){
            Text(
                modifier = Modifier.padding(start = 15.dp),
                text = "N° Casa",
                style = MaterialTheme.typography.displayLarge.copy(
                    fontSize = 38.sp // Ajusta el tamaño del texto según tus necesidades
                )
            )
            Text(
                modifier = Modifier.padding(start = 50.dp),
                text = "Monto",
                style = MaterialTheme.typography.displayLarge.copy(
                    fontSize = 38.sp // Ajusta el tamaño del texto según tus necesidades
                )
            )
        }
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            LazyColumn(
                modifier = Modifier
                    .padding(dimensionResource(R.dimen.padding_small))
            ) {
                items(items = listaCasa) { casa ->
                    CanceladoItem(
                        navController,
                        casa = casa,
                        fechaI,
                        fechaF
                    )
                }
            }
        }

    }
}

@Composable
fun CanceladoItem(
    navController: NavController,
    casa: CasaCancelado,
    fechaI: String,
    fechaF: String
){

    Card{
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small))
            ){
                CasaInformation(navController, casa, fechaI, fechaF)
            }
        }
    }
}

@Composable
fun CasaInformation(
    navController: NavController,
    casa: CasaCancelado,
    fechaI : String,
    fechaF : String,
    modifier: Modifier = Modifier
){
    var estado = 2
    Card () {
        Row(
            modifier = modifier.fillMaxWidth()
                .clickable { navController.navigate(route = AppScreens.ReciboScreen.ruta + "/${casa.idCasa}/$fechaI/$fechaF/$estado") }
        ) {
            //NOMBRE DE LA CASA
            Text(
                modifier = modifier.padding(start = 10.dp),
                text = "${casa.idCasa}",
                style = MaterialTheme.typography.displayMedium.copy(
                    fontSize = 28.sp // Ajusta el tamaño del texto según tus necesidades
                )
            )
            //COSTO MANTENIMIENTO
            Text(
                modifier = modifier.padding(start = 65.dp),
                text = "S/.${casa.subtotal}",
                style = MaterialTheme.typography.displayMedium.copy(
                    fontSize = 28.sp // Ajusta el tamaño del texto según tus necesidades
                )
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun POR_PAGAR (
    modifier: Modifier,
    navController: NavController,
    screenViewModel: ScreenViewModel,
    fechaI: String,
    fechaF: String
){

    val listaCasa2 : List<CasaPorpagar> by screenViewModel.listaCasaPorPagar.observeAsState(initial = emptyList())

    Card(
        modifier = modifier
    ) {
        Row (modifier = modifier.fillMaxWidth()){
            Text(
                modifier = Modifier.padding(start = 15.dp),
                text = "N° Casa",
                style = MaterialTheme.typography.displayLarge.copy(
                    fontSize = 38.sp // Ajusta el tamaño del texto según tus necesidades
                )
            )
            Text(
                modifier = Modifier.padding(start = 50.dp),
                text = "Monto",
                style = MaterialTheme.typography.displayLarge.copy(
                    fontSize = 38.sp // Ajusta el tamaño del texto según tus necesidades
                )
            )
        }
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            LazyColumn(
                modifier = Modifier
                    .padding(dimensionResource(R.dimen.padding_small))
            ) {
                items(items = listaCasa2) { casa ->
                    PorPagarItem(
                        navController,
                        casa = casa,
                        fechaI,
                        fechaF
                    )
                }
            }
        }
    }
}

@Composable
fun PorPagarItem(
    navController: NavController,
    casa: CasaPorpagar,
    fechaI : String,
    fechaF : String
){

    Card{
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small))
            ){
                CasaPorPagarInformation(navController, casa, fechaI, fechaF)
            }
        }
    }
}

@Composable
fun CasaPorPagarInformation(
    navController: NavController,
    casa: CasaPorpagar,
    fechaI : String,
    fechaF : String,
    modifier: Modifier = Modifier
){
    var estado = 1
    Card () {
        Row(
            modifier = modifier.fillMaxWidth()
                .clickable { navController.navigate(route = AppScreens.ReciboScreen.ruta + "/${casa.idCasa}/$fechaI/$fechaF/$estado") }
        ) {
            //NOMBRE DE LA CASA
            Text(
                modifier = modifier.padding(start = 10.dp),
                text = "${casa.idCasa}",
                style = MaterialTheme.typography.displayMedium.copy(
                    fontSize = 28.sp // Ajusta el tamaño del texto según tus necesidades
                )
            )
            //COSTO MANTENIMIENTO
            Text(
                modifier = modifier.padding(start = 65.dp),
                text = "S/.${casa.subtotal}",
                style = MaterialTheme.typography.displayMedium.copy(
                    fontSize = 28.sp
                )
            )
        }
    }
}