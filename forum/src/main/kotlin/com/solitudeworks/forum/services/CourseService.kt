package com.solitudeworks.forum.services

import com.solitudeworks.forum.models.Course
import org.springframework.stereotype.Service

@Service
class CourseService(private var courses: List<Course>) {

    init {
        val course = Course(
            id = 1,
            name = "Kotlin",
            field = "Programming"
        )

        courses = listOf(course)
    }

    fun searchById(id: Int): Course {
        return courses.first { course ->
            course.id == id
        }
    }

}