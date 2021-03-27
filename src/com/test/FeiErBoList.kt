package com.test

open class FeiErBoList {

    fun get(n: Int): Int {
        if (n <= 2) {
            return 1
        }
        return get(n - 1) + get(n - 2)
    }
}

fun main(args: Array<String>) {
    val list = FeiErBoList()
    println(list.get(13))
}