package com.solitudeworks.forum.services

import com.solitudeworks.forum.dtos.TopicDto
import com.solitudeworks.forum.models.Topic
import com.solitudeworks.forum.views.TopicView
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicService(
    private var topics: List<Topic>,
    private val courseService: CourseService,
    private val authorService: AuthorService
) {

    fun list(): List<TopicView> {
        return topics.stream().map { topic ->
            TopicView(
                id = topic.id,
                title = topic.title,
                question = topic.question,
                date = topic.date,
                status = topic.status
            )
        }.collect(Collectors.toList())
    }

    fun searchId(id: Int): TopicView {
        val topic = topics.find { topic ->
            topic.id == id
        }

        return topic.let {
            TopicView(
                id = it!!.id,
                title = it.title,
                question = it.question,
                date = it.date,
                status = it.status
            )
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