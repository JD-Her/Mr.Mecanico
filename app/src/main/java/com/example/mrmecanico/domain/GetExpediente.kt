package com.example.mrmecanico.domain

import com.example.mrmecanico.data.ExpedienteEntity
import com.example.mrmecanico.local.ExpedienteRepository
import javax.inject.Inject

class GetExpediente @Inject constructor(private val expedienteRepository: ExpedienteRepository) {
    suspend operator fun invoke(): List<Expediente> {
        return expedienteRepository.getAllExp().map { it.toNote() }
    }
}