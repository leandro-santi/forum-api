package com.solitudeworks.forum.dto.views

import com.solitudeworks.forum.model.StatusTopic
import java.time.LocalDateTime

data class TopicView(
    val id: Int?,
    val title: String,
    val message: String,
    val status: StatusTopic,
    val date: LocalDateTime,
)
