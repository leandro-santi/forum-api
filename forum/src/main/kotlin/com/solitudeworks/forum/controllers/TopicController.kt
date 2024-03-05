package com.solitudeworks.forum.controllers

import com.solitudeworks.forum.dtos.TopicDto
import com.solitudeworks.forum.services.TopicService
import com.solitudeworks.forum.views.TopicView
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topics")
class TopicController(private val service: TopicService) {

    /*
        @GetMapping
        fun sampleRequest() : String {
            return "Hello Again!"
        }
    */

    @GetMapping
    fun listTopics(): List<TopicView> {
        return service.list()
    }

    @GetMapping("/{id}")
    fun searchById(@PathVariable id: Int): TopicView {
        return service.searchId(id)
    }

    @PostMapping
    fun registerTopic(@RequestBody topicDto: TopicDto) {
        service.registerTopic(topicDto)
    }

}