package com.sementa.modulo.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.sementa.modulo.models.entity.FinancialGoalEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FinancialGoalDao {

    @Query("SELECT * FROM financial_goal")
    suspend fun getGoals(): List<FinancialGoalEntity>

    @Query(
        """
            SELECT COALESCE(SUM(CASE WHEN type = 'ADD' THEN +amount ELSE -amount END), 0)
            FROM contribution WHERE financialGoalId = :goalId
            """
    )
    suspend fun getCurrentAmount(goalId: String): Long

    @Upsert
    suspend fun saveGoal(entity: FinancialGoalEntity)

    @Query("DELETE FROM financial_goal WHERE id =:goalId")
    suspend fun deleteGoal(goalId: String)

}