package com.solitudeworks.forum.mappers

import com.solitudeworks.forum.interfaces.Mapper
import com.solitudeworks.forum.models.Topic
import com.solitudeworks.forum.views.TopicView
import org.springframework.stereotype.Component

@Component
class TopicViewMapper : Mapper<Topic, TopicView> {

    override fun map(t: Topic): TopicView {
        return TopicView(
            id = t.id,
            title = t.title,
            question = t.question,
            date = t.date,
            status = t.status
        )
    }

}