package com.solitudeworks.forum

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

/*
    This is a basic CRUD sample simulating forum posts
    GET, POST, PUT, DELETE, PATCH
*/

@SpringBootApplication
@EnableCaching
class ForumApplication

fun main(args: Array<String>) {
    runApplication<ForumApplication>(*args)
}
