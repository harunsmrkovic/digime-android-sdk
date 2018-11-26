package me.digi.sdk.models.government

import me.digi.sdk.models.ModelParam
import me.digi.sdk.models.ModelTest

class VehicleRegistrationSpec : ModelTest<VehicleRegistration>(VehicleRegistration::class.java, object : ModelParam<VehicleRegistration> {
    override val emptyTest: VehicleRegistration? = VehicleRegistration(
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<VehicleRegistration?, String>> =
            listOf(
                    Pair(
                            VehicleRegistration(
                                    "dummyAccountEntityId",
                                    "dummyColour",
                                    1,
                                    2,
                                    "dummyEntityId",
                                    "dummyFuelType",
                                    3,
                                    "dummyId",
                                    4,
                                    "dummyMake",
                                    "dummyModel",
                                    5,
                                    "dummyTransmission"
                            ),
                            """
                                {
                                   "accountentityid":"dummyAccountEntityId",
                                   "colour":"dummyColour",
                                   "createddate":1,
                                   "enginecapacity":2,
                                   "entityid":"dummyEntityId",
                                   "fueltype":"dummyFuelType",
                                   "gearcount":3,
                                   "id":"dummyId",
                                   "manufacturedate":4,
                                   "make":"dummyMake",
                                   "model":"dummyModel",
                                   "registrationdate":5,
                                   "transmission":"dummyTransmission"
                                }
                            """.trimIndent()
                    )
            )

    override val jsonTests: List<Pair<VehicleRegistration?, String>> =
            listOf(
                    Pair(
                            emptyTest,
                            """{"dummyType": "dummy"}"""
                    )
            )
})