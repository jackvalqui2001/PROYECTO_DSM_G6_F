package com.example.proyecto_dsm_g7.Screens

import android.annotation.SuppressLint
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
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
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.LeadingIconTab
import androidx.compose.material.Scaffold
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
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
import com.example.proyecto_dsm_g7.navigation.AppScreens
import com.example.tabs_prueba.Tabs.CANCELADO
import com.example.tabs_prueba.Tabs.POR_PAGAR
import com.example.tabs_prueba.Tabs.Tab_Item
import com.example.tabs_prueba.Tabs.Tab_Item.*
import com.example.tabs_prueba.Tabs.modifier
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import com.maxkeppeker.sheets.core.models.base.rememberSheetState
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarConfig
import com.maxkeppeler.sheets.calendar.models.CalendarSelection
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CasaScreen(
    navController: NavController,
    screenViewModel: ScreenViewModel
){
    var fechaI by remember { mutableStateOf("2000-01-01")}
    var fechaF by remember { mutableStateOf("2024-12-31")}

    Scaffold (
        topBar = {
            Column {
                Row {
                    CasaTopBar()
                }
                Row {
                    var resultado = PeriodoApp()
                    fechaI = resultado.valor1
                    fechaF = resultado.valor2
                    println(fechaF + " "+ fechaI)
                }

            }

        },
        bottomBar = {
            ButtonRowCasa(navController)
        }
    ) {
        Card {
            TabApp(navController, screenViewModel, fechaI, fechaF)
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CasaTopBar(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(
        title = {
            Column {
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)

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
                                bottom = dimensionResource(R.dimen.padding_little_small)
                            )
                    )
                }
                Card (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = dimensionResource(R.dimen.padding_little_small)),
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
                                bottom = dimensionResource(R.dimen.padding_little_small)
                            )

                    )
                }
            }
        },
        modifier = modifier
            .padding(bottom = dimensionResource(R.dimen.padding_little_small))
            .background(color = Color.Blue)
    )
}

data class Resultado(val valor1: String, val valor2: String)

//PARTE SUPERIOR PARA IDENTIFICAR PERIODOS
@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun PeriodoApp() : Resultado{

    val periodoInicio = rememberSheetState()
    val periodoFin = rememberSheetState()

    var dia_inicio by remember { mutableStateOf("Seleccione Periodo Inicial")}
    var dia_fin by remember { mutableStateOf("Seleccione Periodo Final")}
    var showDateIni by remember { mutableStateOf(false) }
    var showDateFin by remember { mutableStateOf(false) }

    var resultado1 by remember { mutableStateOf("0") }


    CalendarDialog(
        state = periodoInicio,
        config = CalendarConfig(
            monthSelection = true,
            yearSelection = true
        ),
        selection = CalendarSelection.Date{ date ->
            Log.d("SelectedDate", "$date")
            dia_inicio = date.toString()
            showDateIni = !showDateIni
            Log.d("visual Inicio", "$showDateIni")
        }
    )
    CalendarDialog(
        state = periodoFin,
        config = CalendarConfig(
            monthSelection = true,
            yearSelection = true
        ),
        selection = CalendarSelection.Date{ date_fin ->
            Log.d("SelectedDate Fin", "$date_fin")
            dia_fin = date_fin.toString()
            showDateFin = !showDateFin
            Log.d("visual Final", "$showDateFin")
        }
    )

    Column (modifier = Modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Row (modifier = Modifier.padding(8.dp)){
            Card (onClick = {
                periodoInicio.show()
            }){
                Row (modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small))
                ){


                    Image(
                        modifier = Modifier
                            .size(dimensionResource(R.dimen.image_size)),
                        contentScale = ContentScale.Crop,
                        painter = painterResource(R.drawable.calendario),

                        contentDescription = null
                    )

                    if(!showDateIni){
                        VisorTexto(dia_inicio)
                    }
                    else{
                        VisorTexto(dia_inicio)
                    }
                }

            }

        }
        Row (modifier = Modifier.padding(8.dp)){
            Card (onClick = {periodoFin.show()}){
                Row (modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small))
                ){

                    if(!showDateFin){
                        VisorTexto(dia_fin)
                    }
                    else{
                        VisorTexto(dia_fin)
                    }

                    Image(
                        modifier = Modifier
                            .size(dimensionResource(R.dimen.image_size)),
                        contentScale = ContentScale.Crop,
                        painter = painterResource(R.drawable.calendario),

                        contentDescription = null
                    )

                }

            }

        }

        Button(onClick = { resultado1 = "1" }) {
            Text(text = "Fijar Fecha", color = Color.White)
        }
    }
    if (resultado1 == "0"){
        return Resultado("2000-01-01","2024-12-31")
    }
    return Resultado(dia_inicio,dia_fin)
}

// TEXT FIELD
@Composable
fun VisorTexto(tex: String = "Seleccione una fecha"){

    var texto: String = tex
    TextField(
        value = texto,
        onValueChange = {
            texto = it
        },
        textStyle = MaterialTheme
            .typography
            .displayLarge
            .copy(fontSize = 10.sp),
        readOnly = true,
        modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_little_small))
    )



}


// INFORMACIÓN PARA EL TAB DE NAVEGACIÓN
@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabApp(
    navController: NavController,
    screenViewModel: ScreenViewModel,
    fechaI: String,
    fechaF: String
){

    val canceladoItem = Tab_Item.item_Cancelado.apply {
        icon = R.drawable.cancelado
        title = "Cancelado"
        screen = { CANCELADO(modifier, navController, screenViewModel,fechaI,fechaF)}
    }

    val porpagarItem = Tab_Item.item_porCancelar.apply {
        icon = R.drawable.por_cancelar
        title = "Por Pagar"
        screen = { POR_PAGAR(modifier, navController, screenViewModel,fechaI,fechaF) }
    }

    val tabs = listOf(
        canceladoItem,
        porpagarItem
    )

    //
    val pagerState = rememberPagerState()

    Column {
        Tabs(tabs, pagerState)
        Tabs_Content(tabs, pagerState)
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Tabs(tabs: List<Tab_Item>, pagerState: PagerState) {
    val scope = rememberCoroutineScope()

    TabRow(
        selectedTabIndex = pagerState.currentPage,
        indicator = {
                tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
            )
        }
    ) {
        tabs.forEachIndexed { index, tabsItem ->
            LeadingIconTab(
                selected = pagerState.currentPage == index,
                onClick = { scope.launch { pagerState.animateScrollToPage(index) } },
                text = {
                    Icon(painter = painterResource(
                        id = tabsItem.icon),
                        contentDescription = "")
                },
                icon = { Text (tabsItem.title) }
            )
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Tabs_Content(tabs: List<Tab_Item>, pagerState: PagerState) {
    HorizontalPager(
        state = pagerState,
        count = tabs.size) {
            page ->
        tabs[page].screen()
    }
}

// ------------------------- INFERIOR -----------------------------
@Composable
fun ButtonRowCasa(navController: NavController){
    val context = LocalContext.current

    BottomAppBar {

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ButtonWithImageCasa(
                buttonText = "",
                imageRes = R.drawable.condominio,
                textColor = Color.Gray,
                imageSize = DpSize(30.dp, 30.dp),
                onClick = { navController.navigate(route = AppScreens.CondominioScreen.ruta) }
            )
            ButtonWithImageCasa(
                buttonText = "Casas",
                imageRes = R.drawable.casa,
                textColor = Color.Black,
                imageSize = DpSize(20.dp, 20.dp),
                onClick = { Toast.makeText(context, "Se encuentra aquí", Toast.LENGTH_SHORT).show()  }
            )
            ButtonWithImageCasa(
                buttonText = " ",
                imageRes = R.drawable.recibo,
                textColor = Color.Gray,
                imageSize = DpSize(20.dp, 20.dp),
                onClick = { Toast.makeText(context, "Escoja una casa", Toast.LENGTH_SHORT).show() }
            )
            ButtonWithImageCasa(
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
fun ButtonWithImageCasa(
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
        androidx.compose.material3.Text(
            text = buttonText,
            fontSize = 12.sp,
            color = textColor,
            modifier = Modifier.clickable { onClick() }
        )
    }
}