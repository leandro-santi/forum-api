package com.solitudeworks.forum.model

import java.time.LocalDateTime

data class Answers(
    val id: Int?,
    val message: String,
    val date: LocalDateTime = LocalDateTime.now(),
    val user: User,
    val topic: Topic,
    val solution: Boolean,
)
