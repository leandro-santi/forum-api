package com.solitudeworks.forum.interfaces

interface Mapper<T, U> {
    fun map(t: T): U
}
