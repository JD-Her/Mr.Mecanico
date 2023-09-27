package com.example.mrmecanico.local

import androidx.room.Dao
import com.example.mrmecanico.data.ExpedienteDao
import com.example.mrmecanico.data.ExpedienteEntity
import javax.inject.Inject

class ExpedienteRepository @Inject constructor(
    private val expeDao: ExpedienteDao
) {
    fun getAllExp(): List<ExpedienteEntity> {
        return expeDao.getExp()
    }

    fun insertExp(expedienteEntity: ExpedienteEntity){
        expeDao.insertExp(expedienteEntity = expedienteEntity)
    }
}