package com.solitudeworks.forum.exception

class NotFoundException(
    val msg: String?,
) : RuntimeException(msg)
