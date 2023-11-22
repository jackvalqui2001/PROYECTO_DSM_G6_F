package com.example.proyecto_dsm_g7.data

import androidx.annotation.StringRes
import com.example.proyecto_dsm_g7.R

data class Recibo(
    @StringRes val n_recibo: Int,
    @StringRes val periodo: Int,
    val importe: Float,
    @StringRes val fecha_emision: Int,
    @StringRes val fecha_vencimiento: Int,
    val ajuste: Int,
    @StringRes val id_recibo_estado: Int,
    @StringRes val observacion: Int,
)

val recibos = listOf(

    Recibo(R.string.n_recibo_1, R.string.periodo_1, 229.52f, R.string.fecha_emision_1,
            R.string.fecha_vencimiento_1, 0, R.string.id_recibo_estado_1, R.string.observacion_1),
    Recibo(R.string.n_recibo_2, R.string.periodo_2, 315.15f, R.string.fecha_emision_2,
        R.string.fecha_vencimiento_2, 0, R.string.id_recibo_estado_2, R.string.observacion_2),
    Recibo(R.string.n_recibo_3, R.string.periodo_3, 242.17f, R.string.fecha_emision_3,
        R.string.fecha_vencimiento_3, 0, R.string.id_recibo_estado_3, R.string.observacion_3),
    Recibo(R.string.n_recibo_4, R.string.periodo_4, 268.57f, R.string.fecha_emision_4,
        R.string.fecha_vencimiento_4, 0, R.string.id_recibo_estado_4, R.string.observacion_4),
    Recibo(R.string.n_recibo_5, R.string.periodo_5, 357.11f, R.string.fecha_emision_5,
        R.string.fecha_vencimiento_5, 0, R.string.id_recibo_estado_5, R.string.observacion_5),
    Recibo(R.string.n_recibo_6, R.string.periodo_6, 187.04f, R.string.fecha_emision_6,
        R.string.fecha_vencimiento_6, 0, R.string.id_recibo_estado_6, R.string.observacion_6)
)