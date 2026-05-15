package com.sementa.modulo.database.repository.financial_goal

import com.sementa.modulo.database.dao.FinancialGoalDao
import com.sementa.modulo.models.entity.FinancialGoalEntity

class DefaultFinancialGoalRepository(
    private val financialGoalDao: FinancialGoalDao
): FinancialGoalRepository {

    override suspend fun getGoals(): List<FinancialGoalEntity> {
        return financialGoalDao.getGoals()
    }

    override suspend fun getCurrentAmount(goalId: String): Long {
        return financialGoalDao.getCurrentAmount(goalId)
    }

    override suspend fun saveGoal(goalEntity: FinancialGoalEntity) {
        return financialGoalDao.saveGoal(goalEntity)
    }

    override suspend fun deleteGoal(goalId: String) {
        return financialGoalDao.deleteGoal(goalId)
    }

}