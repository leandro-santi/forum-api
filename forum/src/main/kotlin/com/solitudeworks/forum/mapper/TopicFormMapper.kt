package com.solitudeworks.forum.mapper

import com.solitudeworks.forum.dto.forms.TopicForm
import com.solitudeworks.forum.model.Topic
import com.solitudeworks.forum.service.CourseService
import com.solitudeworks.forum.service.UserService
import com.solitudeworks.forum.util.Mapper
import org.springframework.stereotype.Component

@Component
class TopicFormMapper(
    private val courseService: CourseService,
    private val userService: UserService,
) : Mapper<TopicForm, Topic> {
    override fun map(t: TopicForm): Topic =
        Topic(
            title = t.title,
            message = t.message,
            course = courseService.searchById(t.idCourse),
            user = userService.searchById(t.idAuthor),
        )
}
