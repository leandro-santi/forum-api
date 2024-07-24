package com.solitudeworks.forum.mapper

import com.solitudeworks.forum.dto.views.TopicView
import com.solitudeworks.forum.model.Topic
import com.solitudeworks.forum.util.Mapper
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
