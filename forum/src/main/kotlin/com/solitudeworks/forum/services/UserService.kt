package com.solitudeworks.forum.services

import com.solitudeworks.forum.models.User
import org.springframework.stereotype.Service

@Service
class UserService(private var users: List<User>) {

    init {
        val user = User(
            id = 1,
            name = "Alejandrino",
            email = "leandro@gmail.com"
        )

        users = listOf(user)
    }

    fun searchById(id: Int): User {
        return users.stream().filter { user ->
            user.id == id
        }.findFirst().get()
    }

}