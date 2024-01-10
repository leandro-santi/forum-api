package com.solitudeworks.forum.services

import com.solitudeworks.forum.models.Author
import com.solitudeworks.forum.models.Course
import com.solitudeworks.forum.models.Topic
import org.springframework.stereotype.Service

@Service
class TopicService {

    fun list(): List<Topic> {
        val topic = Topic(
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

        return listOf(topic, topic, topic) // Arrays.asList(topic, topic, topic)
    }

}