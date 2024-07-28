package com.solitudeworks.forum.repository

import com.solitudeworks.forum.model.Topic
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface TopicRepository : JpaRepository<Topic, Int> {
    fun findByCourseName(
        courseName: String,
        pagination: Pageable,
    ): Page<Topic>
}
