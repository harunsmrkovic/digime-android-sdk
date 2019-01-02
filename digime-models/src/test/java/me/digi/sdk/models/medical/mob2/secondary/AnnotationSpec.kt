/*
 * Copyright (c) 2009-2018 digi.me Limited. All rights reserved.
 */

package me.digi.sdk.models.medical.mob2.secondary

import me.digi.sdk.models.ModelTest
import me.digi.sdk.models.objects.medical.mob2.secondary.TAnnotation

class AnnotationSpec : ModelTest<Annotation>(Annotation::class.java) {
    override val emptyTest: Annotation? = Annotation(
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<Annotation?, String>> =
            listOf(
                    Pair(
                            TAnnotation.obj,
                            TAnnotation.json
                    )
            )
}