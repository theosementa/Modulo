package com.sementa.modulo.models.domain

import com.sementa.modulo.models.entity.ContributionEntity
import com.sementa.modulo.models.enums.ContributionType
import kotlin.time.Instant
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

data class ContributionDomain @OptIn(ExperimentalUuidApi::class) constructor(
    val id: String = Uuid.random().toString(),
    val name: String?,
    val amount: Double,
    val type: ContributionType,
    val date: Instant,
    val financialGoal: FinancialGoalDomain
) {

    fun toEntity(): ContributionEntity {
        return ContributionEntity(
            id = id,
            name = name,
            amount = amount.toLong(),
            type = type.name,
            date = date.toEpochMilliseconds(),
            financialGoalId = financialGoal.id
        )
    }

}
