package com.example.proyecto_dsm_g7.Screens

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.proyecto_dsm_g7.Data.Condominio
import com.example.proyecto_dsm_g7.Data.condominios
import com.example.proyecto_dsm_g7.R
import com.example.proyecto_dsm_g7.navigation.AppScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CondominioScreen(navController: NavController){

    Scaffold(
        topBar = {
            CondominoTopBar()
        },
        bottomBar = {
            ButtonRowCondominio(navController)
        }

    ) { it ->
        LazyColumn(contentPadding = it){
            items(condominios){
                CondominioItem(
                    condominio = it,
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                )
            }
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
    condominio: Condominio,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
    ) {
        Column {

            //1.1. NOMBRE DEL CONDOMINIO
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    modifier = Modifier
                        .size(dimensionResource(R.dimen.image_size))
                        .padding(dimensionResource(R.dimen.padding_small)),
                    painter = painterResource(R.drawable.ubicacion),

                    // Content Description is not needed here - image is decorative, and setting a
                    // null content description allows accessibility services to skip this element
                    // during navigation.

                    contentDescription = null
                )
                Text(
                    text = stringResource(condominio.nom_condominio),
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
                CondominioInformation(condominio)
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
    condominio: Condominio,
    modifier: Modifier = Modifier,
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
                text =stringResource(condominio.id_persona),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
            )
            //DIRECCION
            Text(
                text =stringResource(condominio.direccion),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
            )
            //TELEFONO
            Text(
                text =stringResource(condominio.telefono),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
            )
            //RUC
            Text(
                text =stringResource(condominio.ruc),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
            )
            //UBIGEO
            Text(
                text =stringResource(condominio.id_ubigeo),
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
                textColor = Color.Red,
                onClick = { Toast.makeText(context, "Se encuentra aquí", Toast.LENGTH_SHORT).show() }
            )
            ButtonWithImageCondominio(
                buttonText = "Casas",
                imageRes = R.drawable.casas,
                textColor = Color.Gray,
                onClick = { navController.navigate(route = AppScreens.CasaScreen.ruta + "/Este es un parámetro")}
            )
            ButtonWithImageCondominio(
                buttonText = "Recibo",
                imageRes = R.drawable.recibo,
                textColor = Color.Gray,
                onClick = { Toast.makeText(context, "No disponible", Toast.LENGTH_SHORT).show() }
            )
            ButtonWithImageCondominio(
                buttonText = "Detalle",
                imageRes = R.drawable.detalle,
                textColor = Color.Gray,
                onClick = { Toast.makeText(context, "No disponible", Toast.LENGTH_SHORT).show() }
            )
        }
    }
}

@Composable
fun ButtonWithImageCondominio(buttonText: String, imageRes: Int, textColor: Color, onClick: () -> Unit){
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
















