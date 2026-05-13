package com.sementa.modulo.database.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import com.sementa.modulo.models.entity.ContributionEntity

@Dao
interface ContributionDao {

    @Query("SELECT * FROM contribution WHERE financialGoalId = :goalId ORDER BY date DESC")
    fun getContributionsPaged(goalId: String): PagingSource<Int, ContributionEntity>

}