package com.example.proyecto_dsm_g7.data.dao

import com.example.proyecto_dsm_g7.data.model.detalle
import com.example.proyecto_dsm_g7.data.tables.detalle_Table
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

class detalleDAO {

    fun getDetalle(id: Int) : List<detalle> {
        val result = mutableListOf<detalle>()

        transaction {

            val query = detalle_Table.select(detalle_Table.idMantRecibo eq id)

            query.forEach{
                val idMantRecibo = it[detalle_Table.idMantRecibo]
                val importeCasa = it[detalle_Table.importeCasa]
                val descripcion=it[detalle_Table.descripcion]

                result.add(
                    detalle(
                        idMantRecibo,
                        importeCasa,
                        descripcion,
                    )
                )
            }

        }
        return result
    }
}