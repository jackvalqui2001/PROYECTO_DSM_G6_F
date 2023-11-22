package com.example.proyecto_dsm_g7.Data

import androidx.annotation.StringRes
import com.example.proyecto_dsm_g7.R

data class Condominio(
    @StringRes val id_predio: Int,
    @StringRes val nom_condominio: Int,
    @StringRes val ruc: Int,
    @StringRes val telefono: Int,
    @StringRes val direccion: Int,
    @StringRes val id_ubigeo: Int,
    @StringRes val id_persona: Int,
)

val condominios = listOf(
    Condominio(R.string.id_predio_1,R.string.nom_condominio_1, R.string.ruc_1,R.string.telefono_1,
        R.string.direccion_1,R.string.id_ubigeo_1, R.string.id_persona_1),
    Condominio(R.string.id_predio_2,R.string.nom_condominio_2, R.string.ruc_2,R.string.telefono_2,
        R.string.direccion_2,R.string.id_ubigeo_2, R.string.id_persona_2),
    Condominio(R.string.id_predio_3,R.string.nom_condominio_3, R.string.ruc_3,R.string.telefono_3,
        R.string.direccion_3,R.string.id_ubigeo_3, R.string.id_persona_3),
    Condominio(R.string.id_predio_4,R.string.nom_condominio_4, R.string.ruc_4,R.string.telefono_4,
        R.string.direccion_4,R.string.id_ubigeo_4, R.string.id_persona_4),
    Condominio(R.string.id_predio_5,R.string.nom_condominio_5, R.string.ruc_5,R.string.telefono_5,
        R.string.direccion_5,R.string.id_ubigeo_5, R.string.id_persona_5),
    Condominio(R.string.id_predio_6,R.string.nom_condominio_6, R.string.ruc_6,R.string.telefono_6,
        R.string.direccion_6,R.string.id_ubigeo_6, R.string.id_persona_6),
    Condominio(R.string.id_predio_7,R.string.nom_condominio_7, R.string.ruc_7,R.string.telefono_7,
        R.string.direccion_7,R.string.id_ubigeo_7, R.string.id_persona_7),
    Condominio(R.string.id_predio_7,R.string.nom_condominio_7, R.string.ruc_7,R.string.telefono_7,
        R.string.direccion_7,R.string.id_ubigeo_7, R.string.id_persona_7),
    Condominio(R.string.id_predio_8,R.string.nom_condominio_8, R.string.ruc_8,R.string.telefono_8,
        R.string.direccion_8,R.string.id_ubigeo_8, R.string.id_persona_8),
    Condominio(R.string.id_predio_9,R.string.nom_condominio_9, R.string.ruc_9,R.string.telefono_9,
        R.string.direccion_9,R.string.id_ubigeo_9, R.string.id_persona_9),
    Condominio(R.string.id_predio_10,R.string.nom_condominio_10, R.string.ruc_10,R.string.telefono_10,
        R.string.direccion_10,R.string.id_ubigeo_10, R.string.id_persona_10),
    Condominio(R.string.id_predio_11,R.string.nom_condominio_11, R.string.ruc_11,R.string.telefono_11,
        R.string.direccion_11,R.string.id_ubigeo_11, R.string.id_persona_11),
    Condominio(R.string.id_predio_12,R.string.nom_condominio_12, R.string.ruc_12,R.string.telefono_12,
        R.string.direccion_12,R.string.id_ubigeo_12, R.string.id_persona_12),
    Condominio(R.string.id_predio_13,R.string.nom_condominio_13, R.string.ruc_13,R.string.telefono_13,
        R.string.direccion_13,R.string.id_ubigeo_13, R.string.id_persona_13),
    Condominio(R.string.id_predio_14,R.string.nom_condominio_14, R.string.ruc_14,R.string.telefono_14,
        R.string.direccion_14,R.string.id_ubigeo_14, R.string.id_persona_14),
)
