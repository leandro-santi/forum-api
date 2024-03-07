package com.solitudeworks.forum.controllers

import com.solitudeworks.forum.dtos.TopicDto
import com.solitudeworks.forum.forms.TopicForm
import com.solitudeworks.forum.services.TopicService
import com.solitudeworks.forum.views.TopicView
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
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

    // GET
    @GetMapping
    fun listTopics(): List<TopicView> {
        return service.list()
    }

    @GetMapping("/{id}")
    fun searchById(@PathVariable id: Int): TopicView {
        return service.searchId(id)
    }

    // POST
    @PostMapping
    fun registerTopic(@RequestBody @Valid topicDto: TopicDto) {
        service.registerTopic(topicDto)
    }

    // PUT
    @PutMapping
    fun updateTopic(@RequestBody @Valid topicForm: TopicForm) {
        service.updateTopic(topicForm)
    }

    // DELETE
    @DeleteMapping("/{id}")
    fun deleteTopic(@PathVariable id: Int) {
        service.deleteTopic(id)
    }

    // PATCH
    @PatchMapping
    fun updateFieldsTopic(@RequestBody @Valid topicForm: TopicForm) {
        service.updateFieldsTopic(topicForm)
    }

}