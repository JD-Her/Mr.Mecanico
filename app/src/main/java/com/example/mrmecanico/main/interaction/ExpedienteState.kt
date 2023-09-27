package com.example.mrmecanico.main.interaction

import com.example.mrmecanico.domain.Expediente

data class ExpedienteState(
    var expediente: List<Expediente> = emptyList()
)
