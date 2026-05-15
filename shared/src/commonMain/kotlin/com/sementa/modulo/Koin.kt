package com.sementa.modulo

import com.sementa.modulo.database.getContributionDao
import com.sementa.modulo.database.getFinancialGoalDao
import com.sementa.modulo.database.getRoomDatabase
import com.sementa.modulo.database.repository.financial_goal.DefaultFinancialGoalRepository
import com.sementa.modulo.database.repository.financial_goal.FinancialGoalRepository
import com.sementa.modulo.datasource.financial_goal.DefaultFinancialGoalDataSource
import com.sementa.modulo.datasource.financial_goal.FinancialGoalDataSource
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.bind
import org.koin.dsl.module

expect fun platformModule(): Module

fun initKoin(config: KoinAppDeclaration? = null) =
    startKoin {
        config?.invoke(this)
        modules(
            platformModule(),
            provideDataSourceModule,
            provideRepositoryModule,
            provideDatabaseModule
        )
    }

val provideDataSourceModule = module {
    singleOf(::DefaultFinancialGoalDataSource).bind(FinancialGoalDataSource::class)
}

val provideRepositoryModule = module {
    singleOf(::DefaultFinancialGoalRepository).bind(FinancialGoalRepository::class)
}

val provideDatabaseModule = module {
    single { getRoomDatabase(get()) }
    single { getFinancialGoalDao(get()) }
    single { getContributionDao(get()) }
}