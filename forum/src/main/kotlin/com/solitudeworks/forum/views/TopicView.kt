package com.solitudeworks.forum.views

import com.solitudeworks.forum.models.StatusTopic
import java.time.LocalDateTime

data class TopicView(
    val id: Int?,
    val title: String,
    val question: String,
    val status: StatusTopic,
    val date: LocalDateTime
)