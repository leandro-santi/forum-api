package com.solitudeworks.forum.services

import com.solitudeworks.forum.dtos.TopicDto
import com.solitudeworks.forum.forms.TopicForm
import com.solitudeworks.forum.mappers.TopicDtoMapper
import com.solitudeworks.forum.mappers.TopicViewMapper
import com.solitudeworks.forum.models.Topic
import com.solitudeworks.forum.views.TopicView
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicService(
    private var topics: List<Topic>,
    private val topicViewMapper: TopicViewMapper,
    private val topicDtoMapper: TopicDtoMapper
) {

    fun list(): List<TopicView> {
        return topics.stream().map { topic ->
            topicViewMapper.map(topic)
        }.collect(Collectors.toList())
    }

    fun searchId(id: Int): TopicView {
        val topic = topics.stream().filter { topic ->
            topic.id == id
        }.findFirst().get()

        return topicViewMapper.map(topic)
    }

    // POST
    fun registerTopic(topicDto: TopicDto) {
        val topic = topicDtoMapper.map(topicDto)
        topic.id = topics.size + 1
        topics = topics.plus(topic)
    }

    // PUT
    fun updateTopic(topicForm: TopicForm) {
        val topic = topics.stream().filter { topic ->
            topic.id == topicForm.id
        }.findFirst().get()

        topics = topics.minus(topic).plus(
            Topic(
                id = topicForm.id,
                title = topicForm.title,
                question = topicForm.question,
                author = topic.author,
                course = topic.course,
                answers = topic.answers,
                status = topic.status,
                date = topic.date
            )
        )
    }

    // DELETE
    fun deleteTopic(id: Int) {
        val topic = topics.stream().filter { topic ->
            topic.id == id
        }.findFirst().get()

        topics = topics.minus(topic)
    }

    // PATCH
    fun updateFieldsTopic(topicForm: TopicForm) {
        for (topic in topics) {
            if (topic.id == topicForm.id) {
                topic.title = topicForm.title
                topic.question = topicForm.question
                break
            }
        }
    }

}