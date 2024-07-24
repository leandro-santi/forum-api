package com.solitudeworks.forum.services

import com.solitudeworks.forum.dtos.forms.TopicForm
import com.solitudeworks.forum.dtos.forms.UpdateTopicForm
import com.solitudeworks.forum.dtos.views.TopicView
import com.solitudeworks.forum.exceptions.NotFoundException
import com.solitudeworks.forum.mappers.TopicFormMapper
import com.solitudeworks.forum.mappers.TopicViewMapper
import com.solitudeworks.forum.models.Topic
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicService(
    private var topics: List<Topic>,
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper
) {

    private val notFoundExceptionMessage: String = "TOPIC WAS NOT FOUND."

    // GET
    fun list(): List<TopicView> {
        return topics.stream().map { topic ->
            topicViewMapper.map(topic)
        }.collect(Collectors.toList())
    }

    fun searchById(id: Int): TopicView {
        val topic = topics.stream().filter { topic ->
            topic.id == id
        }.findFirst().orElseThrow {
            NotFoundException(notFoundExceptionMessage)
        }

        return topicViewMapper.map(topic)
    }

    // POST
    fun registerTopic(form: TopicForm): TopicView {
        val topic = topicFormMapper.map(form)
        topic.id = topics.size + 1
        topics = topics.plus(topic)
        return topicViewMapper.map(topic)
    }

    // PUT
    fun updateTopic(form: UpdateTopicForm): TopicView {
        val topic = topics.stream().filter { topic ->
            topic.id == form.id
        }.findFirst().orElseThrow {
            NotFoundException(notFoundExceptionMessage)
        }

        val updatedTopic = Topic(
            id = form.id,
            title = form.title,
            msg = form.message,
            user = topic.user,
            course = topic.course,
            answers = topic.answers,
            status = topic.status,
            date = topic.date
        )

        topics = topics.minus(topic).plus(updatedTopic)

        return topicViewMapper.map(updatedTopic)
    }

    // DELETE
    fun deleteTopic(id: Int) {
        val topic = topics.stream().filter { topic ->
            topic.id == id
        }.findFirst().orElseThrow {
            NotFoundException(notFoundExceptionMessage)
        }

        topics = topics.minus(topic)
    }

    // PATCH
    fun updateFieldsTopic(form: UpdateTopicForm) {
        for (topic in topics) {
            if (topic.id == form.id) {
                topic.title = form.title
                topic.msg = form.message
                return
            }
        }
        throw NotFoundException(notFoundExceptionMessage)
    }

}