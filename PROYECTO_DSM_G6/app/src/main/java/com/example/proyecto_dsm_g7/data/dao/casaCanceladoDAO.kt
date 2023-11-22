package com.example.proyecto_dsm_g7.data.dao

import com.example.proyecto_dsm_g7.data.model.CasaCancelado
import com.example.proyecto_dsm_g7.data.tables.CasaCancelado_Table
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

class casaCanceladoDAO {

    fun getCasaCancelado(id: Int) : List<CasaCancelado> {
        val result = mutableListOf<CasaCancelado>()

        transaction {

            val query = CasaCancelado_Table.select(CasaCancelado_Table.idPredio eq id)

            query.forEach{
                val idPredio = it[CasaCancelado_Table.idPredio]
                val idCasa = it[CasaCancelado_Table.idCasa]
                val idReciboEstado = it[CasaCancelado_Table.idReciboEstado]
                val fechaEmision = it[CasaCancelado_Table.fechaEmision]
                val fechaVencimiento = it[CasaCancelado_Table.fechaVencimiento]
                val subtotal = it[CasaCancelado_Table.subtotal]

                result.add(
                    CasaCancelado(
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