package com.sementa.modulo.models.domain

import com.sementa.modulo.models.entity.FinancialGoalEntity
import kotlin.time.Instant
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

data class FinancialGoalDomain @OptIn(ExperimentalUuidApi::class) constructor(
    val id: String = Uuid.random().toString(),
    val name: String,
    val emoji: String,
    val goalAmount: Double,
    val currentAmount: Double,
    val startDate: Instant,
    val endDate: Instant?
) {

    fun toEntity(): FinancialGoalEntity {
        return FinancialGoalEntity(
            id = id,
            name = name,
            emoji = emoji,
            goalAmount = goalAmount.toLong(),
            startDate = startDate.toEpochMilliseconds(),
            endDate = endDate?.toEpochMilliseconds()
        )
    }

}