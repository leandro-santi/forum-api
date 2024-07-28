package com.solitudeworks.forum.controller

import com.solitudeworks.forum.dto.forms.TopicForm
import com.solitudeworks.forum.dto.forms.UpdateTopicForm
import com.solitudeworks.forum.dto.views.TopicView
import com.solitudeworks.forum.service.TopicService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/topics")
class TopicController(
    private val service: TopicService,
) {
    //region GET
    @GetMapping
    fun listTopics(
        @RequestParam(required = false) nameCourse: String?,
        @PageableDefault(size = 5, sort = ["date"], direction = Sort.Direction.DESC) pagination: Pageable,
    ): Page<TopicView> = service.list(nameCourse, pagination)

    @GetMapping("/{id}")
    fun searchTopicsById(
        @PathVariable id: Int,
    ): TopicView = service.searchById(id)
    //endregion GET

    //region POST -> Returns code 201 with a response body
    @PostMapping
    @Transactional
    fun registerTopic(
        @RequestBody @Valid form: TopicForm,
        uriBuilder: UriComponentsBuilder,
    ): ResponseEntity<TopicView> {
        val topicView = service.registerTopic(form)
        val uri = uriBuilder.path("/topics/${topicView.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicView)
    }
    //endregion

    //region PUT -> Returns code 200 with a response body
    @PutMapping
    @Transactional
    fun updateTopic(
        @RequestBody @Valid form: UpdateTopicForm,
    ): ResponseEntity<TopicView> {
        val topicView = service.updateTopic(form)
        return ResponseEntity.ok(topicView)
    }
    //endregion

    //region DELETE -> Returns code 204 with no content as response
    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteTopic(
        @PathVariable id: Int,
    ) {
        service.deleteTopic(id)
    }
    //endregion

    //region PATCH
    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    fun updateFieldsTopic(
        @RequestBody @Valid form: UpdateTopicForm,
    ) {
        service.updateFieldsTopic(form)
    }
    //endregion
}
