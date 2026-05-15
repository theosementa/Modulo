package com.sementa.modulo

import androidx.room.RoomDatabase
import com.sementa.modulo.database.AppDatabase
import com.sementa.modulo.database.getDatabaseBuilder
import org.koin.dsl.module

actual fun platformModule() = module {
    single<RoomDatabase.Builder<AppDatabase>> {
        getDatabaseBuilder(get())
    }
}