package com.example.proyecto_dsm_g7.data.tables

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.date

object CasaPorPagar_Table: Table("casa_porpagar") {
    val idPredio = integer("id_predio")
    val idCasa = integer("id_casa")
    val idReciboEstado = integer("id_recibo_estado")
    val fechaEmision = date("fecha_emision_inicial")
    val fechaVencimiento = date("fecha_vencimiento_final")
    val subtotal = integer("subtotal")
}