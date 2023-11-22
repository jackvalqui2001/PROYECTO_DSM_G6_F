package com.example.proyecto_dsm_g7.data.tables

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.date

object CasaFiltro_Table: Table("casa_cancelado_fecha") {
    val idPredio = integer("id_predio")
    val idCasa = integer("id_casa")
    val fechaEmision = date("fecha_emision")
    val idReciboEstado = integer("id_recibo_estado")
    val subtotal = integer("subtotal")
}