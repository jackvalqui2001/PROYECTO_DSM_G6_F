package com.example.proyecto_dsm_g7.data.dao

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.proyecto_dsm_g7.data.model.recibo
import com.example.proyecto_dsm_g7.data.tables.recibo_table
import org.jetbrains.exposed.sql.SqlExpressionBuilder.between
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import java.time.LocalDate

class reciboDAO {

    @RequiresApi(Build.VERSION_CODES.O)
    fun getRecibo(id: Int, fechaI: String, fechaF: String) : List<recibo> {
        val result = mutableListOf<recibo>()

        val fechaInicioStr = fechaI
        val fechaFinStr = fechaF

        val fechaInicio = LocalDate.parse(fechaInicioStr)
        val fechaFin = LocalDate.parse(fechaFinStr)
        transaction {

            //val query = recibo_table.select(recibo_table.idCasa eq id)

            val query = recibo_table.select((recibo_table.idCasa eq id) and (recibo_table.fechaEmision.between(fechaInicio,fechaFin)))

            query.forEach {
                val idMantenimientoRecibo = it[recibo_table.idMantenimientoRecibo]
                val idCasa = it[recibo_table.idCasa]
                val nRecibo = it[recibo_table.nRecibo]
                val periodo = it[recibo_table.periodo]
                val fechaEmision = it[recibo_table.fechaEmision]
                val fechaVencimiento = it[recibo_table.fechaVencimiento]
                val importe = it[recibo_table.importe]
                val ajuste = it[recibo_table.ajuste]
                val observacion = it[recibo_table.observacion]
                val idReciboEstado = it[recibo_table.idReciboEstado]

                result.add(
                    recibo(
                        idMantenimientoRecibo,
                        idCasa,
                        nRecibo,
                        periodo,
                        fechaEmision,
                        fechaVencimiento,
                        importe,
                        ajuste,
                        observacion,
                        idReciboEstado,
                    )
                )
            }
        }
        return result
    }
}