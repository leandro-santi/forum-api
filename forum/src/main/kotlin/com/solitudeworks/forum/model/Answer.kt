package com.solitudeworks.forum.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Answer(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,
    val message: String,
    val date: LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    val user: User,
    @ManyToOne
    val topic: Topic,
    val solution: Boolean,
)
