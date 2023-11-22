package com.example.tabs_prueba.Tabs

import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.proyecto_dsm_g7.R

typealias MiFuncion = @Composable () -> Unit
val modifier: Modifier = Modifier.width(330.dp)

sealed class Tab_Item(
    var icon: Int,
    var title: String,
    var screen: MiFuncion
){
    object item_Cancelado : Tab_Item(R.drawable.cancelado, "Cancelado", { CANCELADO (modifier) })
    object item_porCancelar : Tab_Item(R.drawable.por_cancelar, "Por Pagar", { POR_PAGAR ()})
}
