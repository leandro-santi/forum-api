package com.solitudeworks.forum.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "resposta")
data class Answer(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,
    val message: String,
    val date: LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User,
    @ManyToOne
    @JoinColumn(name = "topic_id")
    val topic: Topic,
    val solution: Boolean,
)
