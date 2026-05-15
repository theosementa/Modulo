package com.sementa.modulo

import androidx.room.RoomDatabase
import com.sementa.modulo.database.AppDatabase
import com.sementa.modulo.database.getDatabaseBuilder
import com.sementa.modulo.database.repository.financial_goal.FinancialGoalRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.dsl.module

actual fun platformModule() = module {
    single<RoomDatabase.Builder<AppDatabase>> {
        getDatabaseBuilder()
    }
}

class FinancialGoalRepositoryHelper: KoinComponent {

    private val financialGoalRepository: FinancialGoalRepository by inject()
    fun getFinancialGoalRepository(): FinancialGoalRepository = financialGoalRepository

}