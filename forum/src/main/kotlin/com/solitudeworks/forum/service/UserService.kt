package com.solitudeworks.forum.service

import com.solitudeworks.forum.model.User
import com.solitudeworks.forum.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
) {
    fun searchById(id: Int): User = userRepository.findById(id).get()
}
