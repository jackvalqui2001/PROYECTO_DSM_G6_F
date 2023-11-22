package com.example.proyecto_dsm_g7.data.tables

import org.jetbrains.exposed.sql.Table

object detalle_Table: Table("detalles") {
    val idMantRecibo = integer("id_mant_recibo")
    val importeCasa = float("importe_casa")
    val descripcion = varchar("descripcion",100)
}