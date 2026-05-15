package com.sementa.modulo.datasource.financial_goal

import com.sementa.modulo.database.repository.financial_goal.FinancialGoalRepository
import com.sementa.modulo.models.domain.FinancialGoalDomain
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DefaultFinancialGoalDataSource(
    private val repository: FinancialGoalRepository
): FinancialGoalDataSource {

    private val _financialGoals = MutableStateFlow<List<FinancialGoalDomain>>(emptyList())
    override val financialGoals: StateFlow<List<FinancialGoalDomain>> = _financialGoals.asStateFlow()

    override suspend fun fetchGoals(): Result<Unit> {
        try {
            val financialGoalsEntities = repository.getGoals()
            val financialGoalsDomains = financialGoalsEntities.map { it.toDomain() }
            this._financialGoals.value = financialGoalsDomains
            return Result.success(Unit)
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }

    override suspend fun saveGoal(goal: FinancialGoalDomain): Result<Unit> {
        try {
            val financialGoalEntity = goal.toEntity()
            val finalEntity = repository.saveGoal(financialGoalEntity)
            add(finalEntity.toDomain())
            return Result.success(Unit)
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }

    override suspend fun deleteGoal(id: String): Result<Unit> {
        try {
            repository.deleteGoal(id)
            remove(id)
            return Result.success(Unit)
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }

    fun add(goal: FinancialGoalDomain) {
        if (!financialGoals.value.contains(goal)) {
            _financialGoals.update { it + goal }
        }
    }

    fun update(goal: FinancialGoalDomain) {
        _financialGoals.update { list ->
            list.map { if (it.id == goal.id) goal else it }
        }
    }

    fun remove(goalId: String) {
        _financialGoals.update { list ->
            list.filter { it.id != goalId }
        }
    }

}
