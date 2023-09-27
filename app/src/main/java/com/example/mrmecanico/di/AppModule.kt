package com.example.mrmecanico.di

import android.content.Context
import androidx.room.Room
import com.example.mrmecanico.data.ExpedienteDao
import com.example.mrmecanico.data.ExpedienteDatabase
import com.example.mrmecanico.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun providesExpRoomDatabase(@ApplicationContext app: Context): ExpedienteDatabase {
        val db = Room.databaseBuilder(
            app,
            ExpedienteDatabase::class.java,
            Constants.expediente_database
        ).build()
        return db
    }

    @Provides
    @Singleton
    fun providesNotesDao(expedienteDatabase: ExpedienteDatabase)
            : ExpedienteDao = expedienteDatabase.expedienteDao

}
