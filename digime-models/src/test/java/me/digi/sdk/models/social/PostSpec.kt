/*
 * Copyright (c) 2009-2018 digi.me Limited. All rights reserved.
 */

package me.digi.sdk.models.social

import me.digi.sdk.models.ModelTest

data class PostTypeDummy(val type: Post.Companion.PostType?)

class PostTypeSpec : ModelTest<PostTypeDummy>(PostTypeDummy::class.java) {
    override val emptyTest: PostTypeDummy? = PostTypeDummy(null)

    override val jsonObjectTests: List<Pair<PostTypeDummy?, String>> =
            listOf(
                    Pair(
                            PostTypeDummy(Post.Companion.PostType.STANDARD),
                            """{"type":0}""".trimIndent()
                    ),
                    Pair(
                            PostTypeDummy(Post.Companion.PostType.FACEBOOK_STATUS_UPDATE),
                            """{"type":1}""".trimIndent()
                    ),
                    Pair(
                            PostTypeDummy(Post.Companion.PostType.FACEBOOK_WALL_POST),
                            """{"type":2}""".trimIndent()
                    ),
                    Pair(
                            PostTypeDummy(Post.Companion.PostType.FACEBOOK_NOTE),
                            """{"type":3}""".trimIndent()
                    ),
                    Pair(
                            PostTypeDummy(Post.Companion.PostType.TWITTER_TWEET),
                            """{"type":4}""".trimIndent()
                    ),
                    Pair(
                            PostTypeDummy(Post.Companion.PostType.TWITTER_MENTION),
                            """{"type":5}""".trimIndent()
                    ),
                    Pair(
                            PostTypeDummy(Post.Companion.PostType.TWITTER_FAVOURITE),
                            """{"type":6}""".trimIndent()
                    ),
                    Pair(
                            PostTypeDummy(Post.Companion.PostType.GOOGLE_PLUS_ACTIVITY_POST),
                            """{"type":7}""".trimIndent()
                    ),
                    Pair(
                            PostTypeDummy(Post.Companion.PostType.GOOGLE_PLUS_ACTIVITY_SHARE),
                            """{"type":8}""".trimIndent()
                    ),
                    Pair(
                            PostTypeDummy(Post.Companion.PostType.LINKEDIN_SHAR),
                            """{"type":9}""".trimIndent()
                    ),
                    Pair(
                            PostTypeDummy(Post.Companion.PostType.LINKEDIN_OTHER),
                            """{"type":10}""".trimIndent()
                    ),
                    Pair(
                            PostTypeDummy(Post.Companion.PostType.RSS_FEED_ITEM),
                            """{"type":11}""".trimIndent()
                    ),
                    Pair(
                            PostTypeDummy(Post.Companion.PostType.VIADEO_NEWS_ITEM),
                            """{"type":12}""".trimIndent()
                    ),
                    Pair(
                            PostTypeDummy(Post.Companion.PostType.VIADEO_GROUP_MESSAGE),
                            """{"type":13}""".trimIndent()
                    ),
                    Pair(
                            PostTypeDummy(Post.Companion.PostType.VIADEO_OTHER),
                            """{"type":14}""".trimIndent()
                    ),
                    Pair(
                            PostTypeDummy(Post.Companion.PostType.TWITTER_FAVOURITE_AND_TWEET),
                            """{"type":15}""".trimIndent()
                    ),
                    Pair(
                            PostTypeDummy(Post.Companion.PostType.TWITTER_FAVOURITE_AND_MENTION),
                            """{"type":16}""".trimIndent()
                    ),
                    Pair(
                            PostTypeDummy(Post.Companion.PostType.TWITTER_MENTION_AND_TWEET),
                            """{"type":17}""".trimIndent()
                    ),
                    Pair(
                            PostTypeDummy(Post.Companion.PostType.TWITTER_FAVOURITE_AND_MENTION_AND_TWEET),
                            """{"type":18}""".trimIndent()
                    ),
                    Pair(
                            PostTypeDummy(Post.Companion.PostType.FLICKR_POST),
                            """{"type":19}""".trimIndent()
                    ),
                    Pair(
                            PostTypeDummy(Post.Companion.PostType.INSTAGRAM_POST),
                            """{"type":20}""".trimIndent()
                    ),
                    Pair(
                            PostTypeDummy(Post.Companion.PostType.FLICKR_POST_FAVOURITE),
                            """{"type":21}""".trimIndent()
                    ),
                    Pair(
                            PostTypeDummy(Post.Companion.PostType.FACEBOOK_INTERNAL_POST),
                            """{"type":22}""".trimIndent()
                    ),
                    Pair(
                            PostTypeDummy(Post.Companion.PostType.FACEBOOK_GROUP_POST),
                            """{"type":23}""".trimIndent()
                    ),
                    Pair(
                            PostTypeDummy(Post.Companion.PostType.PINTEREST_PIN),
                            """{"type":24}""".trimIndent()
                    ),
                    Pair(
                            PostTypeDummy(Post.Companion.PostType.PINTEREST_LIKE),
                            """{"type":25}""".trimIndent()
                    ),
                    Pair(
                            PostTypeDummy(Post.Companion.PostType.SEARCH_WIDGET),
                            """{"type":26}""".trimIndent()
                    ),
                    Pair(
                            PostTypeDummy(Post.Companion.PostType.ACTIVITY_WIDGET),
                            """{"type":27}""".trimIndent()
                    ),
                    Pair(
                            PostTypeDummy(Post.Companion.PostType.HERE_LOCATION_WIDGET),
                            """{"type":28}""".trimIndent()
                    ),
                    Pair(
                            null,
                            """{"type":"wrong"}""".trimIndent()
                    )
            )
}

class PostSpec : ModelTest<Post>(Post::class.java) {
    override val emptyTest: Post? = null

    override val jsonObjectTests: List<Pair<Post?, String>> =
            listOf(
                    Pair(
                            Post(
                                    "dummyBaseId",
                                    "dummyEntityId",
                                    "dummyPostId",
                                    "dummySocialNetworkUserEntityId",
                                    "dummyReferenceEntityId",
                                    1,
                                    "dummyPersonEntityId",
                                    "dummyPersonFullName",
                                    "dummyPersonUserName",
                                    "dummyPersonFileUrl",
                                    2,
                                    "dummyPostUrl",
                                    "dummyText",
                                    "dummyTitle",
                                    3,
                                    Post.Companion.PostType.STANDARD,
                                    4,
                                    5,
                                    6,
                                    7,
                                    8
                            ),
                            """
                                {
                                    "baseid":"dummyBaseId",
                                    "entityid":"dummyEntityId",
                                    "postid":"dummyPostId",
                                    "socialnetworkuserentityid":"dummySocialNetworkUserEntityId",
                                    "referenceentityid":"dummyReferenceEntityId",
                                    "referenceentitytype":1,
                                    "personentityid":"dummyPersonEntityId",
                                    "personfullname":"dummyPersonFullName",
                                    "personusername":"dummyPersonUserName",
                                    "personfileurl":"dummyPersonFileUrl",
                                    "createddate":2,
                                    "posturl":"dummyPostUrl",
                                    "text":"dummyText",
                                    "title":"dummyTitle",
                                    "updateddate":3,
                                    "type":0,
                                    "commentcount":4,
                                    "sharecount":5,
                                    "likecount":6,
                                    "favouritecount":7,
                                    "islikes":8
                                }
                            """.trimIndent()
                    )
            )
}