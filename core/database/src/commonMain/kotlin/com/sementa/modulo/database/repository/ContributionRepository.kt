package com.sementa.modulo.database.repository

import androidx.paging.Pager
import androidx.paging.PagingData
import app.cash.paging.PagingConfig
import com.sementa.modulo.database.dao.ContributionDao
import com.sementa.modulo.models.entity.ContributionEntity
import kotlinx.coroutines.flow.Flow

class ContributionRepository(private val contributionDao: ContributionDao) {

    fun getContributionPaged(goalId: String): Flow<PagingData<ContributionEntity>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = { contributionDao.getContributionsPaged(goalId) }
        ).flow
    }
    
}