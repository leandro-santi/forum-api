package com.solitudeworks.forum.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/*
    Controller mapped at /hello address
    a GET requisition will call this (hello() function) as default
*/

@RestController
@RequestMapping("/hello")
class HelloController {

    @GetMapping
    fun hello(): String {
        return "Hello World!"
    }

    @GetMapping("/greet")
    fun helloFromObiWan(): String {
        return "Hello There!"
    }

    @GetMapping("/answer")
    fun answerFromGrievous(): String {
        return "I've been waiting for you!"
    }

}