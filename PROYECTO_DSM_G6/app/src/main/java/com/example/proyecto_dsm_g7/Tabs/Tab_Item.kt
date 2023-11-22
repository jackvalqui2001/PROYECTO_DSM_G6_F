package com.example.tabs_prueba.Tabs

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.proyecto_dsm_g7.R
import com.example.proyecto_dsm_g7.Screens.ScreenViewModel


typealias MiFuncion = @Composable () -> Unit
val modifier: Modifier = Modifier.width(330.dp)

@RequiresApi(Build.VERSION_CODES.O)
val instancia = ScreenViewModel(1,"2000-01-01","2024-12-31",1)
@RequiresApi(Build.VERSION_CODES.O)
val instancia2 = ScreenViewModel(1,"2000-01-01","2024-12-31",1)

sealed class Tab_Item(
    var icon: Int,
    var title: String,
    var screen: MiFuncion
){
    @RequiresApi(Build.VERSION_CODES.O)
    object item_Cancelado : Tab_Item(R.drawable.cancelado, "Cancelado", {
        val navController = null
        navController?.let { CANCELADO(modifier, it, instancia,"2000-01-01","2024-12-31") }
    })
        @RequiresApi(Build.VERSION_CODES.O)
        object item_porCancelar : Tab_Item(R.drawable.por_cancelar, "Por Pagar", {
            val navController = null
            navController?.let { POR_PAGAR(modifier, it, instancia2,"2000-01-01","2024-12-31") }
    })
}
