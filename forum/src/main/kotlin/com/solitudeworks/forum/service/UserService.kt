package com.solitudeworks.forum.service

import com.solitudeworks.forum.model.User
import org.springframework.stereotype.Service

@Service
class UserService(
    private var users: List<User>,
) {
    init {
        val user =
            User(
                id = 1,
                name = "Alejandrino",
                email = "leandro@gmail.com",
            )

        users = listOf(user)
    }

    fun searchById(id: Int): User =
        users
            .stream()
            .filter { user ->
                user.id == id
            }.findFirst()
            .get()
}
