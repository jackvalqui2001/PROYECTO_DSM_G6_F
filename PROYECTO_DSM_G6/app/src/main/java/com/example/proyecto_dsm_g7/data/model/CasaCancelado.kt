package com.example.proyecto_dsm_g7.data.model

import java.time.LocalDate

data class CasaCancelado(
    val idPredio: Int?,
    val idCasa: Int?,
    val idReciboEstado: Int?,
    val fechaEmision: LocalDate?,
    val fechaVencimiento: LocalDate?,
    val subtotal: Int?,
)
