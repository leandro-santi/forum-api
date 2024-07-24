package com.solitudeworks.forum.dtos.forms

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class UpdateTopicForm(
    @field:NotNull val id: Int,
    @field:NotEmpty(message = "It can not be empty.") @field:Size(min = 5, max = 100) val title: String,
    @field:NotEmpty(message = "It can not be empty.") @field:Size(min = 5, max = 300) val message: String,
)
