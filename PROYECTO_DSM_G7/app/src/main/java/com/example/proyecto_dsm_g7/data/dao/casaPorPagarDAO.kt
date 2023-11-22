package com.example.proyecto_dsm_g7.data.dao

import com.example.proyecto_dsm_g7.data.model.CasaPorpagar
import com.example.proyecto_dsm_g7.data.tables.CasaPorPagar_Table
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

class casaPorPagarDAO {

    fun getCasaPorPagar(id: Int) : List<CasaPorpagar> {
        val result = mutableListOf<CasaPorpagar>()

        transaction {

            val query = CasaPorPagar_Table.select(CasaPorPagar_Table.idPredio eq id)

            query.forEach{
                val idPredio = it[CasaPorPagar_Table.idPredio]
                val idCasa = it[CasaPorPagar_Table.idCasa]
                val idReciboEstado = it[CasaPorPagar_Table.idReciboEstado]
                val fechaEmision = it[CasaPorPagar_Table.fechaEmision]
                val fechaVencimiento = it[CasaPorPagar_Table.fechaVencimiento]
                val subtotal = it[CasaPorPagar_Table.subtotal]

                result.add(
                    CasaPorpagar(
                        idPredio,
                        idCasa,
                        idReciboEstado,
                        fechaEmision,
                        fechaVencimiento,
                        subtotal
                    )
                )
            }
        }
        return result
    }
}