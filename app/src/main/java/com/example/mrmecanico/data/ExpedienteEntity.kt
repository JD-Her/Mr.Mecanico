package com.example.mrmecanico.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class ExpedienteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val placa: String,
    val fecha: String,
    val mecanico: String,
    val motivo: String,
    val adicional: String,
    val cedula: String,
    val direccion: String,
    val telefono: String



)
