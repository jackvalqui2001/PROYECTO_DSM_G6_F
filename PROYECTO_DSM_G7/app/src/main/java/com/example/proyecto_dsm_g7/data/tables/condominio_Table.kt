package com.example.proyecto_dsm_g7.data.tables

import org.jetbrains.exposed.sql.Table

object condominio_Table : Table("vista_dominios") {

    val idPredio = integer("id_predio")
    val descripcion = varchar("descripcion",100)
    val nombreCompleto = varchar("nombrecompleto",100)
    val direccion = varchar("direccion",100)
    val telefono = varchar("telefono",100)
    val ruc  = varchar("ruc",100)
    val idUbigeo = varchar("idubigeo",100)

    override val primaryKey = PrimaryKey(idPredio)
}