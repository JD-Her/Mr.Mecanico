package com.example.mrmecanico.main.interaction

import com.example.mrmecanico.domain.Expediente

sealed class ExpedienteEvent {
    data class AddExpediente(val expediente: Expediente): ExpedienteEvent()
    data class UpdateNote(val expediente: Expediente): ExpedienteEvent()
    data class DeleteNote(val expediente: Expediente): ExpedienteEvent()
}
