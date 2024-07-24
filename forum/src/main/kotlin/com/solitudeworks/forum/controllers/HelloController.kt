package com.solitudeworks.forum.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/*
    This is a basic controller sample
    Controller mapped at /hello address
    a GET requisition will call this (hello() function) as default
    @RequestMapping("/hello") can be mapped
*/

@RestController
@RequestMapping
class HelloController {
    @GetMapping
    fun hello(): String = "Hello World!"

    @GetMapping("/greet")
    fun helloFromObiWan(): String = "Hello There!"

    @GetMapping("/answer")
    fun answerFromGrievous(): String = "I've been waiting for you!"
}
