package com.solitudeworks.forum.mappers

import com.solitudeworks.forum.dtos.forms.TopicForm
import com.solitudeworks.forum.interfaces.Mapper
import com.solitudeworks.forum.models.Topic
import com.solitudeworks.forum.services.CourseService
import com.solitudeworks.forum.services.UserService
import org.springframework.stereotype.Component

@Component
class TopicFormMapper(
    private val courseService: CourseService,
    private val userService: UserService,
) : Mapper<TopicForm, Topic> {
    override fun map(t: TopicForm): Topic =
        Topic(
            title = t.title,
            msg = t.message,
            course = courseService.searchById(t.idCourse),
            user = userService.searchById(t.idAuthor),
        )
}
