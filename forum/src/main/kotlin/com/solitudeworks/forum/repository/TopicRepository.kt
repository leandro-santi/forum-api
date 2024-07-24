package com.solitudeworks.forum.repository

import com.solitudeworks.forum.model.Topic
import org.springframework.data.jpa.repository.JpaRepository

interface TopicRepository : JpaRepository<Topic, Int>
