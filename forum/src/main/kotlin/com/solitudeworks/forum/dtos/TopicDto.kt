package com.solitudeworks.forum.dtos

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class TopicDto(
    @field:NotEmpty(message = "It can not be empty.") @field:Size(min = 5, max = 100) val title: String,
    @field:NotEmpty(message = "It can not be empty.") @field:Size(min = 5, max = 300) val question: String,
    @field:NotNull(message = "It can not be null.") val idCourse: Int,
    @field:NotNull(message = "It can not be null.") val idAuthor: Int
) {
}