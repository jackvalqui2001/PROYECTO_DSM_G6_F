package com.example.proyecto_dsm_g7.Data

import org.jetbrains.exposed.sql.Database

object DatabaseConnect {
    fun init() {
        val driverClassName = "org.postgresql.Driver"
        val jdbcURL = "jdbc:postgresql://137.184.120.127:5432/sigcon"
        val user = "modulo4"
        val password = "modulo4"
        Database.connect(jdbcURL, driverClassName, user, password)
    }
}