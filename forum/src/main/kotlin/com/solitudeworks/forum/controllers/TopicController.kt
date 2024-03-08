package com.solitudeworks.forum.controllers

import com.solitudeworks.forum.dtos.TopicDto
import com.solitudeworks.forum.forms.TopicForm
import com.solitudeworks.forum.services.TopicService
import com.solitudeworks.forum.views.TopicView
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

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

    // POST -> Returns code 201 with a response body
    @PostMapping
    fun registerTopic(
        @RequestBody @Valid topicDto: TopicDto,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicView> {
        val topicView = service.registerTopic(topicDto)
        val uri = uriBuilder.path("/topic/${topicView.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicView)
    }

    // PUT -> Returns code 200 with a response body
    @PutMapping
    fun updateTopic(@RequestBody @Valid topicForm: TopicForm): ResponseEntity<TopicView> {
        val topicView = service.updateTopic(topicForm)
        return ResponseEntity.ok(topicView)

    }

    // DELETE -> Returns code 204 with no content as response
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteTopic(@PathVariable id: Int) {
        service.deleteTopic(id)
    }

    // PATCH
    @PatchMapping
    fun updateFieldsTopic(@RequestBody @Valid topicForm: TopicForm) {
        service.updateFieldsTopic(topicForm)
    }

}