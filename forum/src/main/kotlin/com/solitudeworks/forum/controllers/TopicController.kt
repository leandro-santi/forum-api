package com.solitudeworks.forum.controllers

import com.solitudeworks.forum.models.Topic
import com.solitudeworks.forum.services.TopicService
import org.springframework.web.bind.annotation.GetMapping
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
    fun listTopics(): List<Topic> {
        return service.list()
    }

}