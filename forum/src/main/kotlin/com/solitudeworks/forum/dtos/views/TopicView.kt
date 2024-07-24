package com.solitudeworks.forum.dtos.views

import com.solitudeworks.forum.models.StatusTopic
import java.time.LocalDateTime

data class TopicView(
    val id: Int?,
    val title: String,
    val message: String,
    val status: StatusTopic,
    val date: LocalDateTime,
)
