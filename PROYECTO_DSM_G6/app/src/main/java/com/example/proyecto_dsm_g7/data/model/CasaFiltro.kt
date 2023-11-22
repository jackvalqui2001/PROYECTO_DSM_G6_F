package com.example.proyecto_dsm_g7.data.model

import java.time.LocalDate

data class CasaFiltro(
    val idPredio: Int?,
    val idCasa: Int?,
    val fechaEmision: LocalDate?,
    val idReciboEstado: Int?,
    val subtotal: Int?,
)
