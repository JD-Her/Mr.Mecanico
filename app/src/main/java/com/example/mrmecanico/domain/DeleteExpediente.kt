package com.example.mrmecanico.domain

import com.example.mrmecanico.local.ExpedienteRepository
import javax.inject.Inject

class DeleteExpediente @Inject constructor(private val expedienteRepository: ExpedienteRepository) {
    suspend operator fun invoke(expediente: Expediente){
        expedienteRepository.deleteExp(expedienteEntity = expediente.toExpedienteEntity())
    }
}