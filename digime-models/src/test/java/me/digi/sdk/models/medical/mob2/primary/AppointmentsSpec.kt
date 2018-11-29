/*
 * Copyright (c) 2009-2018 digi.me Limited. All rights reserved.
 */

package me.digi.sdk.models.medical.mob2.primary

import me.digi.sdk.models.ModelTest

class AppointmentsSpec : ModelTest<Appointments>(Appointments::class.java) {
    override val emptyTest: Appointments? = Appointments(
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<Appointments?, String>> =
            listOf(
                    Pair(
                            Appointments(
                                    "dummyEntityId",
                                    "dummyAccountEntityId",
                                    1,
                                    2
                            ),
                            """
                                {
                                    "entityid":"dummyEntityId",
                                    "accountentityid":"dummyAccountEntityId",
                                    "createddate":1,
                                    "updateddate":2
                                }
                            """.trimIndent()
                    )
            )
}