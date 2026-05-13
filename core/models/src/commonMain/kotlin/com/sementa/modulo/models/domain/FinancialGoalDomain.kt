package com.sementa.modulo.models.domain

import com.sementa.modulo.models.entity.FinancialGoalEntity
import kotlin.time.Instant

data class FinancialGoalDomain(
    val id: String,
    val name: String,
    val emoji: String,
    val goalAmount: Double,
    val currentAmount: Double,
    val startDate: Instant,
    val endDate: Instant?
) {

    fun toEntity(): FinancialGoalEntity {
        return FinancialGoalEntity(
            name = name,
            emoji = emoji,
            goalAmount = goalAmount.toLong(),
            startDate = startDate.toEpochMilliseconds(),
            endDate = endDate?.toEpochMilliseconds()
        )
    }

}