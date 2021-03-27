package com.utils

fun swap(arr: Array<Int?>, i: Int, j: Int) {
    val t = arr[i]
    arr[i] = arr[j]
    arr[j] = t
}

fun printIntArray(arr: Array<Int?>, checkResult: Boolean = false) {
    arr.forEach {
        print(it)
        print(' ')
    }

    if (checkResult) {
        println()
        println(checkArray(arr))
    }
}

fun checkArray(arr: Array<Int?>): Boolean {
    arr.forEachIndexed { index, it ->
        if (index > 0 && arr[index]!! < arr[index - 1]!!) {
            return false
        }
    }
    return true
}


fun getRandomIntArray(count: Int = 10): Array<Int?> {
    val array = arrayOfNulls<Int>(count)
    for (i in 0 until count) {
        array[i] = (1..1000).shuffled().last()
    }
    return array
}


