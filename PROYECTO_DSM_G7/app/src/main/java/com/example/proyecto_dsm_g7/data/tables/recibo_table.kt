package com.example.proyecto_dsm_g7.data.tables

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.date

object recibo_table: Table("mant_recibo") {
    val idMantenimientoRecibo = integer("id_mant_recibo")
    val idCasa = integer("id_casa")
    val nRecibo = varchar("n_recibo",100)
    val periodo = varchar("periodo",100)
    val fechaEmision = date("fecha_emision")
    val fechaVencimiento = date("fecha_vencimiento")
    val importe = integer("importe")
    val ajuste = integer("ajuste")
    val observacion = varchar("observacion",100)
    val idReciboEstado = integer("id_recibo_estado")
}