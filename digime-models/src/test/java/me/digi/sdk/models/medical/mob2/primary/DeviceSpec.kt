/*
 * Copyright (c) 2009-2018 digi.me Limited. All rights reserved.
 */

package me.digi.sdk.models.medical.mob2.primary

import me.digi.sdk.models.ModelTest
import me.digi.sdk.models.objects.medical.mob2.primary.TDevice

class DeviceSpec : ModelTest<Device>(Device::class.java) {
    override val emptyTest: Device? = Device(
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

    override val jsonObjectTests: List<Pair<Device?, String>> =
            listOf(
                    Pair(
                            TDevice.obj,
                            TDevice.json
                    )
            )
}