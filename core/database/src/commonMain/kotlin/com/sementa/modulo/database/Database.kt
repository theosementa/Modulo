package com.sementa.modulo.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.sementa.modulo.database.dao.ContributionDao
import com.sementa.modulo.database.dao.FinancialGoalDao
import com.sementa.modulo.models.entity.ContributionEntity
import com.sementa.modulo.models.entity.FinancialGoalEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

@Database(
    entities = [FinancialGoalEntity::class, ContributionEntity::class],
    version = 1
)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getFinancialGoalDao(): FinancialGoalDao
    abstract fun getContributionDao(): ContributionDao
}

// The Room compiler generates the `actual` implementations.
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object AppDatabaseConstructor : RoomDatabaseConstructor<AppDatabase> {
    override fun initialize(): AppDatabase
}

fun getRoomDatabase(
    builder: RoomDatabase.Builder<AppDatabase>
): AppDatabase {
    return builder
        .addMigrations()
        .fallbackToDestructiveMigrationOnDowngrade(true)
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}

fun getFinancialGoalDao(appDatabase: AppDatabase) = appDatabase.getFinancialGoalDao()
fun getContributionDao(appDatabase: AppDatabase) = appDatabase.getContributionDao()