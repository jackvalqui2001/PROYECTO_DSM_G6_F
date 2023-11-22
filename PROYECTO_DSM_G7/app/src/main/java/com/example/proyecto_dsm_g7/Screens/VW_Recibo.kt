package com.example.proyecto_dsm_g7.Screens

import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.example.proyecto_dsm_g7.Data.Recibo
import com.example.proyecto_dsm_g7.Data.recibos
import com.example.proyecto_dsm_g7.R
import com.example.proyecto_dsm_g7.navigation.AppScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReciboScreen(navController: NavController){
    Scaffold(
        topBar = {
            ReciboTopAppBar()
        },
        bottomBar = {
            ButtonRowRecibo(navController)
        }
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(recibos) {
                ReciboItem(
                    navController,
                    recibo = it,
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                )
            }
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun ReciboTopAppBar(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(
        title = {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    modifier = Modifier
                        .size(dimensionResource(R.dimen.image_size))
                        .padding(dimensionResource(R.dimen.padding_small)),
                    painter = painterResource(R.drawable.recib_top),

                    contentDescription = null
                )
                Text(
                    text = stringResource(R.string.name_recibo),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        },
        modifier = modifier
    )
}

// ------------------------- GENERAL ITEM -------------------------
@Composable
fun ReciboItem(
    navController: NavController,
    recibo: Recibo,
    modifier: Modifier = Modifier
){
    var expanded by remember { mutableStateOf(false) }

    var nRecibo: String = stringResource(recibo.n_recibo)

    Card(
        modifier = modifier
            .clickable { navController.navigate(route = AppScreens.DetalleScreen.ruta + "/$nRecibo") }
    ){
        Column(
            //NECESARIO PRA LA ANIMACIÓN
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small))
            ){
                ReciboImagen(R.drawable.recib_icon)
                ReciboInformation(recibo)
                Spacer(modifier = Modifier.weight(1f))
                ReciboItemButton(
                    expanded = expanded,
                    onClick = { expanded = !expanded}
                )
            }
            if (expanded){
                DetalleRecibo(
                    recibo,
                    modifier = Modifier
                        .padding(
                            start = dimensionResource(R.dimen.padding_medium),
                            top = dimensionResource(R.dimen.padding_small),
                            end = dimensionResource(R.dimen.padding_medium),
                            bottom = dimensionResource(R.dimen.padding_medium)
                        )
                )
            }
        }
    }
}


// ------------------------- LADO IZQUIERO -------------------------
@Composable
fun ReciboImagen(
    @DrawableRes reciboIcon: Int,
    modifier: Modifier = Modifier
){
    Image(
        modifier = modifier
            .size(dimensionResource(R.dimen.image_size))
            .padding(top = dimensionResource(R.dimen.padding_small)),
        contentScale = ContentScale.Crop,
        painter = painterResource(reciboIcon),

        contentDescription = null
    )
}

@Composable
fun ReciboInformation(
    recibo: Recibo,
    modifier: Modifier = Modifier,
){
    Column (modifier = modifier) {
        //NOMBRE DEL RECIBO
        Text(
            text = stringResource(recibo.n_recibo),
            style = MaterialTheme.typography.displayMedium,
            //Le da un poco de altura al padding
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
        )
        //PERIODO
        Text(
            text = "Periodo: "+stringResource(recibo.periodo),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

// ------------------------- LADO DERECHO -----------------------------
@Composable
private fun ReciboItemButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = stringResource(R.string.expand_button_content_description),
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
fun DetalleRecibo(
    recibo: Recibo,
    modifier: Modifier = Modifier
){
    val ajuste = recibo.ajuste.toString()

    Column(modifier = modifier) {
        Row {
            Text(
                text =  "F_Emision:     ",
                style = MaterialTheme.typography.labelSmall
            )
            Text(
                text = stringResource(recibo.fecha_emision),
                modifier = Modifier.padding(start = 49.dp)
            )
        }
        Row {
            Text(
                text =  "F_Vencimiento:     ",
                style = MaterialTheme.typography.labelSmall
            )
            Text(
                text = stringResource(recibo.fecha_vencimiento),
                modifier = Modifier.padding(start = 16.dp)
            )
        }
        Row {
            Text(
                text =  "Ajuste:     ",
                style = MaterialTheme.typography.labelSmall
            )
            Text(
                text = ajuste,
                modifier = Modifier.padding(start = 77.dp)
            )
        }
        Row {
            Text(
                text =  "Id_Recibo_Estado:     ",
                style = MaterialTheme.typography.labelSmall
            )
            Text(
                text = stringResource(recibo.id_recibo_estado)
            )
        }
        Row {
            Text(
                text =  "Observación:     ",
                style = MaterialTheme.typography.labelSmall
            )
            Text(
                text = stringResource(recibo.observacion),
                modifier = Modifier.padding(start = 34.dp)
            )
        }

    }
}

// ------------------------- INFERIOR -----------------------------
@Composable
fun ButtonRowRecibo(navController: NavController){
    val context = LocalContext.current

    BottomAppBar {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ButtonWithImageRecibo(
                buttonText = "Condominios",
                imageRes = R.drawable.condominio,
                textColor = Color.Black,
                onClick = { navController.navigate(route = AppScreens.CondominioScreen.ruta) }
            )
            ButtonWithImageRecibo(
                buttonText = "Casas",
                imageRes = R.drawable.casas,
                textColor = Color.Black,
                onClick = { navController.navigate(route = AppScreens.CasaScreen.ruta + "/Este es un parámetro") }
            )
            ButtonWithImageRecibo(
                buttonText = "Recibo",
                imageRes = R.drawable.recibo,
                textColor = Color.Red,
                onClick = { Toast.makeText(context, "Se encuentra aquí", Toast.LENGTH_SHORT).show() }
            )
            ButtonWithImageRecibo(
                buttonText = "Detalle",
                imageRes = R.drawable.detalle,
                textColor = Color.Gray,
                onClick = { Toast.makeText(context, "No disponible, escoja un recibo", Toast.LENGTH_SHORT).show() }
            )
        }
    }
}

@Composable
fun ButtonWithImageRecibo(buttonText: String, imageRes: Int, textColor: Color, onClick: () -> Unit){
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




