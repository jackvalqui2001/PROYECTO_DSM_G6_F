package com.example.proyecto_dsm_g7.data.dao

import com.example.proyecto_dsm_g7.data.model.CasaFiltro
import com.example.proyecto_dsm_g7.data.tables.CasaFiltro_Table
import org.jetbrains.exposed.sql.SqlExpressionBuilder.between
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import java.time.LocalDate

class casaFiltroDAO {

    fun getCasaFiltro(estado: Int, fechaI: LocalDate, fechaF: LocalDate) : List<CasaFiltro> {
        val result = mutableListOf<CasaFiltro>()

        transaction {
            val query = CasaFiltro_Table.select((CasaFiltro_Table.idReciboEstado eq estado) and (CasaFiltro_Table.fechaEmision.between(fechaI, fechaF)))

            query.forEach{
                val idPredio = it[CasaFiltro_Table.idPredio]
                val idCasa = it[CasaFiltro_Table.idCasa]
                val fechaEmision = it[CasaFiltro_Table.fechaEmision]
                val idReciboEstado = it[CasaFiltro_Table.idReciboEstado]
                val subtotal = it[CasaFiltro_Table.subtotal]

                result.add(
                    CasaFiltro(
                        idPredio,
                        idCasa,
                        fechaEmision,
                        idReciboEstado,
                        subtotal
                    )
                )
            }
        }
        return result
    }
}