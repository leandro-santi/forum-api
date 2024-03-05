package com.solitudeworks.forum.mappers

import com.solitudeworks.forum.dtos.TopicDto
import com.solitudeworks.forum.interfaces.Mapper
import com.solitudeworks.forum.models.Topic
import com.solitudeworks.forum.services.AuthorService
import com.solitudeworks.forum.services.CourseService
import org.springframework.stereotype.Component

@Component
class TopicDtoMapper(
    private val courseService: CourseService,
    private val authorService: AuthorService
) : Mapper<TopicDto, Topic> {

    override fun map(t: TopicDto): Topic {
        return Topic(
            title = t.title,
            question = t.question,
            course = courseService.searchById(t.idCourse),
            author = authorService.searchById(t.idAuthor)
        )
    }

}
