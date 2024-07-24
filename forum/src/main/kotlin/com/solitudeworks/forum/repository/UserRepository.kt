package com.solitudeworks.forum.repository

import com.solitudeworks.forum.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Int>
