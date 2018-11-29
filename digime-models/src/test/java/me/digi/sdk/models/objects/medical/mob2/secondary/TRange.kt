package me.digi.sdk.models.objects.medical.mob2.secondary

import me.digi.sdk.models.medical.mob2.secondary.Range
import me.digi.sdk.models.objects.ModelTestObject

object TRange : ModelTestObject<Range>(
        Range(
                TQuantity.obj,
                TQuantity.obj
        ),
        """
        {
            "low":${TQuantity.json},
            "high":${TQuantity.json}
        }
        """.trimIndent()
)