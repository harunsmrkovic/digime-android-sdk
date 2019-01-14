/*
 * Copyright (c) 2009-2018 digi.me Limited. All rights reserved.
 */

package me.digi.sdk.models.medical.mob2.secondary

import me.digi.sdk.models.ModelTest
import me.digi.sdk.models.objects.medical.mob2.secondary.TDispenseRequest

class DispenseRequestSpec : ModelTest<DispenseRequest>(DispenseRequest::class.java) {
    override val emptyTest: DispenseRequest? = DispenseRequest(
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<DispenseRequest?, String>> =
            listOf(
                    Pair(
                            TDispenseRequest.obj,
                            TDispenseRequest.json
                    )
            )
}