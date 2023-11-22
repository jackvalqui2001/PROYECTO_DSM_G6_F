package com.example.proyecto_dsm_g7.data.dao

import com.example.proyecto_dsm_g7.data.model.condominio
import com.example.proyecto_dsm_g7.data.tables.condominio_Table
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class condominioDAO {

    fun getCondominio() : List<condominio> {
        val result = mutableListOf<condominio>()

        transaction {

            val query = condominio_Table.selectAll()

            query.forEach{
                val idPredio = it[condominio_Table.idPredio]
                val descripcion = it[condominio_Table.descripcion]
                val nombreCompleto= it[condominio_Table.nombreCompleto]
                val direccion= it[condominio_Table.direccion]
                val telefono= it[condominio_Table.telefono]
                val ruc= it[condominio_Table.ruc]
                val idUbigeo= it[condominio_Table.idUbigeo]

                result.add(
                    condominio(
                        idPredio,
                        descripcion,
                        nombreCompleto,
                        direccion,
                        telefono,
                        ruc,
                        idUbigeo
                    )
                )
            }
        }
        return result
    }
}