package com.sementa.modulo.models.domain

import com.sementa.modulo.models.entity.ContributionEntity
import com.sementa.modulo.models.enums.ContributionType
import kotlin.time.Instant

data class ContributionDomain(
    val id: String,
    val name: String?,
    val amount: Double,
    val type: ContributionType,
    val date: Instant,
    val financialGoal: FinancialGoalDomain
) {

    fun toEntity(): ContributionEntity {
        return ContributionEntity(
            name = name,
            amount = amount.toLong(),
            type = type.name,
            date = date.toEpochMilliseconds(),
            financialGoal = financialGoal.toEntity()
        )
    }

}
