package com.solitudeworks.forum.services

import com.solitudeworks.forum.dtos.TopicDto
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

    fun registerTopic(topicDto: TopicDto) {
        val topic = topicDtoMapper.map(topicDto)
        topic.id = topics.size + 1
        topics = topics.plus(topic)
    }

}