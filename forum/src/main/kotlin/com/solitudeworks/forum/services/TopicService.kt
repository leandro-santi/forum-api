package com.solitudeworks.forum.services

import com.solitudeworks.forum.models.Author
import com.solitudeworks.forum.models.Course
import com.solitudeworks.forum.models.Topic
import org.springframework.stereotype.Service

@Service
class TopicService(private var topics: List<Topic>) {

    init {
        val topicOne = Topic(
            id = 1,
            title = "Kotlin Documentation",
            question = "Data Class Usage",
            course = Course(
                id = 1,
                name = "Kotlin",
                field = "Programming"
            ),
            author = Author(
                id = 1,
                name = "Ana da Silva",
                email = "ana@email.com"
            )
        )

        val topicTwo = Topic(
            id = 2,
            title = "Java Documentation",
            question = "JPA Usage",
            course = Course(
                id = 1,
                name = "Java",
                field = "Programming"
            ),
            author = Author(
                id = 1,
                name = "Ana da Silva",
                email = "ana@email.com"
            )
        )

        val topicThree = Topic(
            id = 1,
            title = "Competitive Programming",
            question = "Dynamic Programming",
            course = Course(
                id = 1,
                name = "CP",
                field = "Programming"
            ),
            author = Author(
                id = 1,
                name = "Ana da Silva",
                email = "ana@email.com"
            )
        )

        topics = listOf(topicOne, topicTwo, topicThree) // or Arrays.asList(topic, topic, topic)
    }

    fun list(): List<Topic> {
        return topics
    }

    fun searchId(id: Int): List<Topic> {
        return topics.filter { topic ->
            topic.id == id
        }
    }

}