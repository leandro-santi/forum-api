package com.solitudeworks.forum

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/*
    This is a basic CRUD sample simulating forum posts
    GET, POST, PUT, DELETE, PATCH
*/

@SpringBootApplication
class ForumApplication

fun main(args: Array<String>) {
    runApplication<ForumApplication>(*args)
}
