package com.sementa.modulo.models.entity.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.sementa.modulo.models.domain.ContributionDomain
import com.sementa.modulo.models.entity.ContributionEntity
import com.sementa.modulo.models.entity.FinancialGoalEntity
import com.sementa.modulo.models.enums.ContributionType
import kotlin.time.Instant

data class ContributionWithGoalRelation(
    @Embedded val contribution: ContributionEntity,
    @Relation(parentColumn = "financialGoalId", entityColumn = "id")
    val financialGoal: FinancialGoalEntity
) {

    fun toDomain(): ContributionDomain {
        return ContributionDomain(
            id = contribution.id,
            name = contribution.name,
            amount = contribution.amount.toDouble(),
            type = ContributionType.valueOf(contribution.type),
            date = Instant.fromEpochMilliseconds(contribution.date),
            financialGoal = financialGoal.toDomain()
        )
    }

}
