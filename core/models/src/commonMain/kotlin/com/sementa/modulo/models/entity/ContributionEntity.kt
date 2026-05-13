package com.sementa.modulo.models.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sementa.modulo.models.domain.ContributionDomain
import com.sementa.modulo.models.enums.ContributionType
import kotlin.time.Instant
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@Entity(tableName = "contribution")
data class ContributionEntity @OptIn(ExperimentalUuidApi::class) constructor(
    @PrimaryKey val id: String = Uuid.random().toString(),
    val name: String?,
    val amount: Long,
    val type: String,
    val date: Long,
    val financialGoal: FinancialGoalEntity
) {

    fun toDomain(): ContributionDomain {
        return ContributionDomain(
            id = id,
            name = name,
            amount = amount.toDouble(),
            type = ContributionType.valueOf(type),
            date = Instant.fromEpochMilliseconds(date),
            financialGoal = financialGoal.toDomain()
        )
    }

}
