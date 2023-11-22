package com.example.proyecto_dsm_g7.Tabs

import androidx.annotation.StringRes
import com.example.proyecto_dsm_g7.R

data class Cancelado(
    @StringRes val num_casa: Int,
    @StringRes val mantenimiento: Int
)

val cancelados = listOf(
    Cancelado(R.string.num_casa_1, R.string.mantenimiento_1),
    Cancelado(R.string.num_casa_2, R.string.mantenimiento_2),
    Cancelado(R.string.num_casa_3, R.string.mantenimiento_3),
    Cancelado(R.string.num_casa_4, R.string.mantenimiento_4),
    Cancelado(R.string.num_casa_5, R.string.mantenimiento_5)

)