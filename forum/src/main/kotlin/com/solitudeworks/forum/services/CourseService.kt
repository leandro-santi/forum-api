package com.solitudeworks.forum.services

import com.solitudeworks.forum.models.Course
import org.springframework.stereotype.Service

@Service
class CourseService(
    private var courses: List<Course>,
) {
    init {
        val course =
            Course(
                id = 1,
                name = "Kotlin",
                category = "Programming",
            )

        courses = listOf(course)
    }

    fun searchById(id: Int): Course =
        courses
            .stream()
            .filter { course ->
                course.id == id
            }.findFirst()
            .get()
}
