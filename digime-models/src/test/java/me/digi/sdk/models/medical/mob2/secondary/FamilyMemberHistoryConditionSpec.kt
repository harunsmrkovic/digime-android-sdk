package me.digi.sdk.models.medical.mob2.secondary

import me.digi.sdk.models.ModelTest
import me.digi.sdk.models.objects.medical.mob2.secondary.TAnnotation
import me.digi.sdk.models.objects.medical.mob2.secondary.TCodeableConcept

class FamilyMemberHistoryConditionSpec : ModelTest<FamilyMemberHistoryCondition>(FamilyMemberHistoryCondition::class.java) {
    override val emptyTest: FamilyMemberHistoryCondition? = FamilyMemberHistoryCondition(
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<FamilyMemberHistoryCondition?, String>> =
            listOf(
                    Pair(
                            FamilyMemberHistoryCondition(
                                    TCodeableConcept.obj,
                                    TCodeableConcept.obj,
                                    listOf(
                                            TAnnotation.obj
                                    )
                            ),
                            """
                                {
                                    "code":${TCodeableConcept.json},
                                    "outcome":${TCodeableConcept.json},
                                    "note":[
                                        ${TAnnotation.json}
                                    ]
                                }
                            """.trimIndent()
                    )
            )
}