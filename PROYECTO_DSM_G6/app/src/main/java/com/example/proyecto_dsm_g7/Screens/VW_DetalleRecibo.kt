package com.example.proyecto_dsm_g7.Screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.proyecto_dsm_g7.R
import com.example.proyecto_dsm_g7.data.model.detalle
import com.example.proyecto_dsm_g7.navigation.AppScreens

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "NewApi")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetalleReciboScreen(
    navController: NavController,
    screenViewModel: ScreenViewModel,
    subtotal: Int,
) {

    val listaDetalle : List<detalle> by screenViewModel.listadetalle.observeAsState(initial = emptyList())
    Scaffold(
        topBar = {
            DetalleTopBar(subtotal)
        },
        bottomBar = {
            ButtonRowDetalle(navController)
        }
    ) { it ->
        LazyColumn(
            contentPadding = it
        ) {
            items(
                items = listaDetalle,
                itemContent = {
                    DetalleReciboItem(
                        detalle = it,
                        modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                    )
                }
            )
        }
    }
}
// ------------------------- SUPERIOR -----------------------------
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetalleTopBar(
    subtotal: Int,
    modifier: Modifier = Modifier
){
    CenterAlignedTopAppBar(
        title = {
            Column {
                Row (
                    modifier = Modifier.fillMaxWidth()
                ){
                    Text(
                        text = "CONDOSA",
                        style = MaterialTheme
                            .typography
                            .displayLarge
                            .copy(fontSize = 20.sp), // Cambiar el tamaño de fuente aquí

                        //MODIFICANDO LA VISUALIZACIÓN DEL TEXTO
                        modifier = Modifier
                            .padding(start = 20.dp,
                                top = dimensionResource(R.dimen.padding_little_small),
                                bottom = dimensionResource(R.dimen.padding_little_small))
                    )
                }
                Card (
                    modifier = Modifier.fillMaxWidth(),
                    MaterialTheme.shapes.small,
                ){
                    Text(
                        text = "Total: S/.$subtotal",
                        style = MaterialTheme
                            .typography
                            .displayLarge
                            .copy(fontSize = 20.sp),

                        //MODIFICANDO LA VISUALIZACIÓN DEL TEXTO
                        modifier = Modifier
                            .padding(start = 20.dp,
                                top = dimensionResource(R.dimen.padding_little_small),
                                bottom = dimensionResource(R.dimen.padding_little_small))

                    )
                }
            }
        },
        modifier = modifier.background(color = Color.Blue)
    )
}
// ------------------------- COTENIDO -----------------------------
@Composable
fun DetalleReciboItem(
    detalle: detalle,
    modifier: Modifier = Modifier,
    ){
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(dimensionResource(R.dimen.padding_small))
    ){
        DetalleReciboInformacion(
            detalle
        )
    }
}

@Composable
fun DetalleReciboInformacion(
    detalle: detalle,
    modifier: Modifier = Modifier,
){
    Row {
        Image(
            modifier = Modifier
                .size(dimensionResource(R.dimen.image_size)),
            contentScale = ContentScale.Crop,
            painter = painterResource(R.drawable.info),

            contentDescription = null
        )

        Column (modifier = modifier.padding(top = 8.dp)) {
            //DESCRIPCIÓN
            Text(
                text = "DESCRIPCIÓN ",
                style = MaterialTheme.typography.bodyLarge
                    .copy(fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)

            )
            Text(
                text = "${detalle.descripcion}",
                style = MaterialTheme.typography.bodyLarge,
                modifier = modifier.padding(start = 40.dp)
            )
        }
    }

    Row {
        Image(
            modifier = Modifier
                .size(dimensionResource(R.dimen.image_size)),
            contentScale = ContentScale.Crop,
            painter = painterResource(R.drawable.por_cancelar),

            contentDescription = null
        )

        Column (
            modifier = modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            //IMPORTE POR CASA
            Text(
                text = "IMPORTE ",
                style = MaterialTheme.typography.bodyLarge
                    .copy(fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)
            )
            Text(
                text = "${detalle.importeCasa}",
                style = MaterialTheme.typography.bodyLarge,
                modifier = modifier.padding(start = 40.dp)
            )
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
                buttonText = " ",
                imageRes = R.drawable.condominio,
                textColor = Color.Black,
                imageSize = DpSize(20.dp, 20.dp),
                onClick = { navController.navigate(route = AppScreens.CondominioScreen.ruta) }
            )
            ButtonWithImageDetalle(
                buttonText = " ",
                imageRes = R.drawable.casa,
                textColor = Color.Black,
                imageSize = DpSize(20.dp, 20.dp),
                onClick = { navController.navigate(route = AppScreens.CasaScreen.ruta + "/"+1) }
            )
            ButtonWithImageDetalle(
                buttonText = " ",
                imageRes = R.drawable.recibo,
                textColor = Color.Black,
                imageSize = DpSize(20.dp, 20.dp),
                onClick = { navController.navigate(route = AppScreens.ReciboScreen.ruta + "/"+2+"/2000-01-01"+"/2024-12-31") }
            )
            ButtonWithImageDetalle(
                buttonText = "Detalle",
                imageRes = R.drawable.detalle,
                textColor = Color.Black,
                imageSize = DpSize(30.dp, 30.dp),
                onClick = { Toast.makeText(context, "Se encuentra aquí", Toast.LENGTH_SHORT).show() }
            )
        }
    }
}

@Composable
fun ButtonWithImageDetalle(buttonText: String, imageRes: Int, textColor: Color, imageSize: DpSize, onClick: () -> Unit){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier.size(width = imageSize.width, height = imageSize.height)
        )
        Text(
            text = buttonText,
            fontSize = 12.sp,
            color = textColor,
            modifier = Modifier.clickable { onClick() }
        )
    }
}