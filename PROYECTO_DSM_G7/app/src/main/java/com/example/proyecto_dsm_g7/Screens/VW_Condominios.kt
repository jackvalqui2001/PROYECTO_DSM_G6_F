package com.example.proyecto_dsm_g7.Screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.example.proyecto_dsm_g7.data.model.condominio
import com.example.proyecto_dsm_g7.navigation.AppScreens

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "NewApi")
@Composable
fun CondominioScreen(
    navController: NavController,
    screenViewModel: ScreenViewModel
){

    val listaCondominio : List<condominio> by screenViewModel.listaCondominio.observeAsState(initial = emptyList())

    Scaffold(
        topBar = {
            CondominoTopBar()
        },
        bottomBar = {
            ButtonRowCondominio(navController)
        }

    ) { it ->
        LazyColumn(
            contentPadding = it
        ) {
            items(
                items = listaCondominio,
                itemContent = {
                    CondominioItem(
                        navController,
                        condominio = it,
                        modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                    )
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CondominoTopBar(modifier: Modifier = Modifier){
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
                        text = "Bienvenido Administrador",
                        style = MaterialTheme
                            .typography
                            .displayLarge
                            .copy(fontSize = 15.sp),

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

@Composable
fun CondominioItem(
    navController: NavController,
    condominio: condominio,
    modifier: Modifier = Modifier
) {

    Card(
        modifier = modifier
            .clickable { navController.navigate(route = AppScreens.CasaScreen.ruta + "/${condominio.idPredio}") }
    ) {
        Column {

            //1.1. NOMBRE DEL CONDOMINIO
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    modifier = Modifier
                        .size(dimensionResource(R.dimen.image_size))
                        .padding(dimensionResource(R.dimen.padding_small))
                        .clickable { navController.navigate(route = AppScreens.MapsScreen.ruta) },
                    painter = painterResource(R.drawable.ubicacion),

                    contentDescription = null
                )
                Text(
                    text = "${condominio.descripcion}",
                    style = MaterialTheme.typography.displayLarge
                )
            }

            //1.2. CARD PARA LA IMAGEN
            Card(
                modifier = modifier
            ){
                CondominioImagen(R.drawable.olivos)
            }

            //1.3. CARD PARA LA DESCRIPCIÓN
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small))
            ){
                Row {
                    Column (modifier =  Modifier.padding(start = 40.dp)) {
                        //RESPONSABLE
                        Text(
                            text = "Responsable: ",
                            style = MaterialTheme.typography.labelSmall,
                            //Le da un poco de altura al padding
                            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
                        )
                        //DIRECCION
                        Text(
                            text = "Dirección: ",
                            style = MaterialTheme.typography.labelSmall,
                            //Le da un poco de altura al padding
                            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
                        )
                        //TELEFONO
                        Text(
                            text = "Teléfono: ",
                            style = MaterialTheme.typography.labelSmall,
                            //Le da un poco de altura al padding
                            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
                        )
                        //RUC
                        Text(
                            text = "RUC: ",
                            style = MaterialTheme.typography.labelSmall,
                            //Le da un poco de altura al padding
                            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
                        )
                        //UBIGEO
                        Text(
                            text = "UBIGEO: ",
                            style = MaterialTheme.typography.labelSmall,
                            //Le da un poco de altura al padding
                            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
                        )

                    }
                    Column (modifier = Modifier.padding(start = 77.dp)) {
                        //RESPONSABLE
                        Text(
                            text = "${condominio.nombreCompleto}",
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
                        )
                        //DIRECCION
                        Text(
                            text = "${condominio.direccion}",
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
                        )
                        //TELEFONO
                        Text(
                            text = "${condominio.telefono}",
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
                        )
                        //RUC
                        Text(
                            text = "${condominio.ruc}",
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
                        )
                        //UBIGEO
                        Text(
                            text = "${condominio.idUbigeo}",
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
                        )
                    }

                }
            }
        }

    }
}

// ------------------------- CARD LOCAL -------------------------
@Composable
fun CondominioImagen(
    @DrawableRes CondominioIcon: Int,
    modifier: Modifier = Modifier
){
    Image(painter = painterResource(CondominioIcon), contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .height(194.dp),
        contentScale = ContentScale.Crop)
}


@Composable
fun CondominioInformation(
    condominio: condominio,
){
    Row {
        Column (modifier =  Modifier.padding(start = 40.dp)) {
            //RESPONSABLE
            Text(
                text = "Responsable: ",
                style = MaterialTheme.typography.labelSmall,
                //Le da un poco de altura al padding
                modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
            )
            //DIRECCION
            Text(
                text = "Dirección: ",
                style = MaterialTheme.typography.labelSmall,
                //Le da un poco de altura al padding
                modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
            )
            //TELEFONO
            Text(
                text = "Teléfono: ",
                style = MaterialTheme.typography.labelSmall,
                //Le da un poco de altura al padding
                modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
            )
            //RUC
            Text(
                text = "RUC: ",
                style = MaterialTheme.typography.labelSmall,
                //Le da un poco de altura al padding
                modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
            )
            //UBIGEO
            Text(
                text = "UBIGEO: ",
                style = MaterialTheme.typography.labelSmall,
                //Le da un poco de altura al padding
                modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
            )

        }
        Column (modifier = Modifier.padding(start = 77.dp)) {
            //RESPONSABLE
            Text(
                text = "${condominio.nombreCompleto}",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
            )
            //DIRECCION
            Text(
                text = "${condominio.direccion}",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
            )
            //TELEFONO
            Text(
                text = "${condominio.telefono}",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
            )
            //RUC
            Text(
                text = "${condominio.ruc}",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
            )
            //UBIGEO
            Text(
                text = "${condominio.idUbigeo}",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
            )
        }

    }

}

// ------------------------- INFERIOR -----------------------------
@Composable
fun ButtonRowCondominio(navController: NavController){
    val context = LocalContext.current

    BottomAppBar {

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ButtonWithImageCondominio(
                buttonText = "Condominios",
                imageRes = R.drawable.condominio,
                textColor = Color.Black,
                imageSize = DpSize(30.dp, 30.dp),
                onClick = { Toast.makeText(context, "Se encuentra aquí", Toast.LENGTH_SHORT).show() }
            )
            ButtonWithImageCondominio(
                buttonText = " ",
                imageRes = R.drawable.casa,
                textColor = Color.Gray,
                imageSize = DpSize(20.dp, 20.dp),
                onClick = { Toast.makeText(context, "Escoja un condominio", Toast.LENGTH_SHORT).show()  }
            )
            ButtonWithImageCondominio(
                buttonText = " ",
                imageRes = R.drawable.recibo,
                textColor = Color.Gray,
                imageSize = DpSize(20.dp, 20.dp),
                onClick = { Toast.makeText(context, "No disponible", Toast.LENGTH_SHORT).show() }
            )
            ButtonWithImageCondominio(
                buttonText = " ",
                imageRes = R.drawable.detalle,
                textColor = Color.Gray,
                imageSize = DpSize(20.dp, 20.dp),
                onClick = { Toast.makeText(context, "No disponible", Toast.LENGTH_SHORT).show() }
            )
        }
    }
}

@Composable
fun ButtonWithImageCondominio(
    buttonText: String,
    imageRes: Int,
    textColor: Color,
    imageSize: DpSize,
    onClick: () -> Unit
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier
                .size(width = imageSize.width, height = imageSize.height)
        )
        Text(
            text = buttonText,
            fontSize = 12.sp,
            color = textColor,
            modifier = Modifier.clickable { onClick() }
        )
    }
}















