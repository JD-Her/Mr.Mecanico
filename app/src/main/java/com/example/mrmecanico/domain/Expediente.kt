package com.example.mrmecanico.domain

import com.example.mrmecanico.data.ExpedienteEntity

data class Expediente(
    val id: Int,
    val name: String,
    val placa: String,
    val fecha: String,

    val mecanico: String,
    val motivo: String,
    val adicional: String,
    val cedula: String,
    val direccion: String,
    val telefono: String,
)

fun ExpedienteEntity.toNote(): Expediente =
    Expediente(
        id = id,
        name = name,
        placa = placa,
        fecha = fecha,
        mecanico = mecanico,
        motivo = motivo,
        adicional = adicional,
        cedula = cedula,
        direccion = direccion,
        telefono = telefono
    )

fun Expediente.toExpedienteEntity(): ExpedienteEntity =
    ExpedienteEntity(
        id = id,
        name = name,
        placa = placa,
        fecha = fecha,
        mecanico = mecanico,
        motivo = motivo,
        adicional = adicional,
        cedula = cedula,
        direccion = direccion,
        telefono = telefono
    )