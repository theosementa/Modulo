package com.sementa.modulo.datasource.financial_goal

import com.sementa.modulo.models.domain.FinancialGoalDomain
import kotlinx.coroutines.flow.StateFlow

interface FinancialGoalDataSource {
    val financialGoals: StateFlow<List<FinancialGoalDomain>>
    suspend fun fetchGoals(): Result<Unit>
    suspend fun saveGoal(goal: FinancialGoalDomain): Result<Unit>
    suspend fun deleteGoal(id: String): Result<Unit>
}