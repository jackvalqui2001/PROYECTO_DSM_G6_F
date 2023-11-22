package com.example.proyecto_dsm_g7.data.model

import java.time.LocalDate

data class recibo(
    val idMantenimientoRecibo : Int?,
    val idCasa : Int?,
    val nRecibo: String?,
    val periodo: String?,
    val fechaEmision: LocalDate?,
    val fechaVencimiento: LocalDate?,
    val importe : Int?,
    val ajuste: Int?,
    val observacion: String?,
    val idReciboEstado: Int?,
)
