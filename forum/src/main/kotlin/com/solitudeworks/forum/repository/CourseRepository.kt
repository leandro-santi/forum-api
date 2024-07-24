package com.solitudeworks.forum.repository

import com.solitudeworks.forum.model.Course
import org.springframework.data.jpa.repository.JpaRepository

interface CourseRepository : JpaRepository<Course, Int>
