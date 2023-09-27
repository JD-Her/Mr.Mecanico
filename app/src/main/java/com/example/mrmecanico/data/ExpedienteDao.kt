package com.example.mrmecanico.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ExpedienteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertExp(expedienteEntity: ExpedienteEntity)

    @Query("SELECT * FROM ExpedienteEntity")
    fun getExp(): List<ExpedienteEntity>
}