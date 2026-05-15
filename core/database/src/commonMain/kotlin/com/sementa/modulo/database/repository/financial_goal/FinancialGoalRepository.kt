package com.sementa.modulo.database.repository.financial_goal

import com.sementa.modulo.models.entity.FinancialGoalEntity

interface FinancialGoalRepository {
    suspend fun getGoals(): List<FinancialGoalEntity>
    suspend fun getCurrentAmount(goalId: String): Long
    suspend fun saveGoal(goalEntity: FinancialGoalEntity): FinancialGoalEntity
    suspend fun deleteGoal(goalId: String)
}