package com.example.mrmecanico.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ExpedienteEntity::class], version = 1)
 abstract class ExpedienteDatabase : RoomDatabase() {
     abstract val expedienteDao: ExpedienteDao
}