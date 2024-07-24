package com.solitudeworks.forum.mappers

import com.solitudeworks.forum.dtos.views.TopicView
import com.solitudeworks.forum.interfaces.Mapper
import com.solitudeworks.forum.models.Topic
import org.springframework.stereotype.Component

@Component
class TopicViewMapper : Mapper<Topic, TopicView> {
    override fun map(t: Topic): TopicView =
        TopicView(
            id = t.id,
            title = t.title,
            message = t.msg,
            date = t.date,
            status = t.status,
        )
}
