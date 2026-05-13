package com.sementa.modulo.models.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sementa.modulo.models.domain.FinancialGoalDomain
import kotlin.time.Instant
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@Entity(tableName = "financial_goal")
data class FinancialGoalEntity @OptIn(ExperimentalUuidApi::class) constructor(
    @PrimaryKey val id: String = Uuid.random().toString(),
    val name: String,
    val emoji: String,
    val goalAmount: Long,
    val startDate: Long,
    val endDate: Long?
) {

    fun toDomain(): FinancialGoalDomain {
        return FinancialGoalDomain(
            id = id,
            name = name,
            emoji = emoji,
            goalAmount = goalAmount.toDouble(),
            currentAmount = 0.0, // TODO: Replace by value from contributions
            startDate = Instant.fromEpochMilliseconds(startDate),
            endDate = endDate?.let { Instant.fromEpochMilliseconds(it) }
        )
    }

}