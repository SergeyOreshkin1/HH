package com.lesson04.utils.network_utils

interface Mapper<I, O> {

    fun map(input: I): O
}
