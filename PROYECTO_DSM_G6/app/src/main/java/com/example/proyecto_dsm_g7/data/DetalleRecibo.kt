package com.example.proyecto_dsm_g7.data

import androidx.annotation.StringRes
import com.example.proyecto_dsm_g7.R

data class DetalleRecibo(
    @StringRes val descripcion: Int,
    @StringRes val importe_casa: Int
)

val detallesrecibos = listOf(

    DetalleRecibo(
        R.string.descripcion_1, R.string.importe_casa_1),
    DetalleRecibo(
        R.string.descripcion_2, R.string.importe_casa_2),
    DetalleRecibo(
        R.string.descripcion_3, R.string.importe_casa_3),
    DetalleRecibo(
        R.string.descripcion_4, R.string.importe_casa_4),
    DetalleRecibo(
        R.string.descripcion_5, R.string.importe_casa_5),
    DetalleRecibo(
        R.string.descripcion_6, R.string.importe_casa_6),
    DetalleRecibo(
        R.string.descripcion_7, R.string.importe_casa_7),
    DetalleRecibo(
        R.string.descripcion_8, R.string.importe_casa_8),
    DetalleRecibo(
        R.string.descripcion_9, R.string.importe_casa_9),
    DetalleRecibo(
        R.string.descripcion_10, R.string.importe_casa_10),

)