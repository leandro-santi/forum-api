package com.solitudeworks.forum.service

import com.solitudeworks.forum.model.Course
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
