package com.solitudeworks.forum.repository

import com.solitudeworks.forum.dto.views.TopicByCategoryView
import com.solitudeworks.forum.model.Topic
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TopicRepository : JpaRepository<Topic, Int> {
    fun findByCourseName(
        courseName: String,
        pagination: Pageable,
    ): Page<Topic>

    @Query(
        "SELECT new com.solitudeworks.forum.dto.views.TopicByCategoryView(course.category, count(t)) FROM Topic t JOIN t.course course GROUP BY course.category",
    )
    fun report(): List<TopicByCategoryView>
}
