package com.solitudeworks.forum.service

import com.solitudeworks.forum.model.Course
import com.solitudeworks.forum.repository.CourseRepository
import org.springframework.stereotype.Service

@Service
class CourseService(
    private val courseRepository: CourseRepository,
) {
    fun searchById(id: Int): Course = courseRepository.findById(id).get()
}
