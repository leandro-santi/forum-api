package com.solitudeworks.forum.util

interface Mapper<T, U> {
    fun map(t: T): U
}
