package com.sementa.modulo.models.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.sementa.modulo.models.domain.ContributionDomain
import com.sementa.modulo.models.enums.ContributionType
import kotlin.time.Instant

@Entity(
    tableName = "contribution",
    foreignKeys = [
        ForeignKey(
            entity = FinancialGoalEntity::class,
            parentColumns = ["id"],
            childColumns = ["financialGoalId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("financialGoalId")]
)
data class ContributionEntity(
    @PrimaryKey val id: String,
    val name: String?,
    val amount: Long,
    val type: String,
    val date: Long,
    val financialGoalId: String
)
