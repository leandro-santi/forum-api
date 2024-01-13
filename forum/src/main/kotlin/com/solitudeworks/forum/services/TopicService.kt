package com.solitudeworks.forum.services

import com.solitudeworks.forum.dto.TopicDto
import com.solitudeworks.forum.models.Author
import com.solitudeworks.forum.models.Course
import com.solitudeworks.forum.models.Topic
import org.springframework.stereotype.Service

@Service
class TopicService(
    private var topics: List<Topic>,
    private val courseService: CourseService,
    private val authorService: AuthorService
) {

    fun list(): List<Topic> {
        return topics
    }

    fun searchId(id: Int): List<Topic> {
        return topics.filter { topic ->
            topic.id == id
        }
    }

    fun registerTopic(topicDto: TopicDto) {
        topics = topics.plus(
            Topic(
                id = topics.size + 1,
                title = topicDto.title,
                question = topicDto.question,
                course = courseService.searchById(topicDto.idCourse),
                author = authorService.searchById(topicDto.idAuthor)
            )
        )
    }

}