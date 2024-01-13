package com.solitudeworks.forum.services

import com.solitudeworks.forum.models.Author
import org.springframework.stereotype.Service

@Service
class AuthorService(private var authors: List<Author>) {

    init {
        val author = Author(
            id = 1,
            name = "Leandrinho",
            email = "leandro@gmail.com"
        )

        authors = listOf(author)
    }

    fun searchById(id: Int): Author {
        return authors.first { author ->
            author.id == id
        }
    }

}