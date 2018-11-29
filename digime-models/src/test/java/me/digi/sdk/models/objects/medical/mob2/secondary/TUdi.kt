/*
 * Copyright (c) 2009-2018 digi.me Limited. All rights reserved.
 */

package me.digi.sdk.models.objects.medical.mob2.secondary

import me.digi.sdk.models.medical.mob2.secondary.Udi
import me.digi.sdk.models.objects.ModelTestObject

object TUdi : ModelTestObject<Udi>(
        Udi(
                "dummyDeviceIdentifier",
                "dummyName"
        ),
        """
        {
            "deviceidentifier":"dummyDeviceIdentifier",
            "name":"dummyName"
        }
        """.trimIndent()
)