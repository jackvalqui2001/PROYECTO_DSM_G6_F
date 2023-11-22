package com.example.proyecto_dsm_g7.Screens

import android.annotation.SuppressLint
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.TextField
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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyecto_dsm_g7.R
import com.example.tabs_prueba.Tabs.CANCELADO
import com.example.tabs_prueba.Tabs.Tab_Item
import com.example.tabs_prueba.Tabs.Tab_Item.*
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
@Preview
@Composable
fun Preview(){
    CasasApp ()
}

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CasasApp(modifier: Modifier = Modifier){

    Scaffold (
        topBar = {
            Column {
                Row {
                    CasaTopBar()
                }
                Row {
                    PeriodoApp()
                }

            }

        }
    ) {
        Card {
            TabApp()
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


//PARTE SUPERIOR PARA IDENTIFICAR PERIODOS
@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun PeriodoApp(){

    val periodoInicio = rememberSheetState()
    val periodoFin = rememberSheetState()

    var dia_inicio = "0"
    var dia_fin = "0"
    var showDateIni = false
    var showDateFin = false

    CalendarDialog(
        state = periodoInicio,
        config = CalendarConfig(
            monthSelection = true,
            yearSelection = true
        ),
        selection = CalendarSelection.Date{ date ->
            Log.d("SelectedDate", "$date")
            dia_inicio = date.toString()
        }
    )
    CalendarDialog(
        state = periodoFin,
        config = CalendarConfig(
            monthSelection = true,
            yearSelection = true
        ),
        selection = CalendarSelection.Date{ date_fin ->
            Log.d("SelectedDate", "$date_fin")
            dia_fin = date_fin.toString()

        }
    )

    Column (modifier = Modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Row (modifier = Modifier.padding(8.dp)){
            Card (onClick = {
                periodoInicio.show()
                showDateIni = true
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
                        VisorTexto()
                    }else{
                        VisorTexto(dia_inicio)
                    }

                }

            }

        }
        Row (modifier = Modifier.padding(8.dp)){
            Card (onClick = {periodoInicio.show()}){
                Row (modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small))
                ){

                    VisorTexto()
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
        Button(onClick = { /*TODO*/ }) {
            Text(text = "BUSCAR")
        }

    }



}

// TEXT FIELD

@Composable
fun VisorTexto(texto: String = "Seleccione una fecha"){

    TextField(
        value = texto,
        onValueChange = {},
        textStyle = MaterialTheme
            .typography
            .displayLarge
            .copy(fontSize = 10.sp),
        readOnly = true,
        modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_little_small))
    )


}


// INFORMACIÓN PARA EL TAB DE NAVEGACIÓN
@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabApp(){
    //LISTADO DE TABS PARA NAVEGAR
    val tabs = listOf(
        item_Cancelado,
        item_porCancelar
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


