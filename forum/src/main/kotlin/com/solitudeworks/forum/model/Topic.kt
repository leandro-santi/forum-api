package com.solitudeworks.forum.model

import java.time.LocalDateTime

data class Topic(
    var id: Int? = null,
    var title: String,
    var msg: String,
    val date: LocalDateTime = LocalDateTime.now(),
    val course: Course,
    val user: User,
    val status: StatusTopic = StatusTopic.NOT_ANSWERED,
    val answers: List<Answers> = ArrayList(),
)
