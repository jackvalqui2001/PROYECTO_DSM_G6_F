package com.example.tabs_prueba.Tabs

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.proyecto_dsm_g7.Data.Cancelado
import com.example.proyecto_dsm_g7.Data.cancelados
import com.example.proyecto_dsm_g7.R


@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun Preview(){
    CANCELADO (Modifier.width(330.dp))
}

@Composable
fun CANCELADO (
    modifier: Modifier
){

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
        Row (modifier = modifier.fillMaxWidth()) {
            LazyColumn {
                items(cancelados) { it ->
                    CasaInformation(
                        cancelado = it,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }

    }



}

@Composable
fun CanceladoItem(
    cancelado: Cancelado,
){

    Card{
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small))
            ){
                CasaInformation(cancelado)
            }
        }
    }
}

@Composable
fun CasaInformation(
    cancelado: Cancelado,
    modifier: Modifier = Modifier,
){
    Card () {
        Row(modifier = modifier.fillMaxWidth()) {
            //NOMBRE DE LA CASA
            Text(
                modifier = modifier.padding(start = 10.dp),
                text = stringResource(cancelado.num_casa),
                style = MaterialTheme.typography.displayMedium.copy(
                    fontSize = 28.sp // Ajusta el tamaño del texto según tus necesidades
                )
            )
            //COSTO MANTENIMIENTO
            Text(
                modifier = modifier.padding(start = 65.dp),
                text = stringResource(cancelado.mantenimiento),
                style = MaterialTheme.typography.displayMedium.copy(
                    fontSize = 28.sp // Ajusta el tamaño del texto según tus necesidades
                )
            )
        }


    }
}

@Composable
fun MantenimientoInformation(
    cancelado: Cancelado,
    modifier: Modifier = Modifier,
){
    Card (modifier = modifier) {
        //COSTO MANTENIMIENTO
        Text(
            text = stringResource(cancelado.mantenimiento),
            style = MaterialTheme.typography.displayMedium.copy(
                fontSize = 28.sp // Ajusta el tamaño del texto según tus necesidades
            )
        )
    }
}






@Composable
fun POR_PAGAR (){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize()
    ) {
        Text(
            "PANTALLA POR PAGAR",
            style = MaterialTheme.typography.headlineMedium
        )
    }
}