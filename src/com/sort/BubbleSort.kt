package com.sort

import com.utils.getRandomIntArray
import com.utils.printIntArray
import com.utils.swap

fun main(args: Array<String>) {
    val sortArray = getRandomIntArray(count = 5)

    sort(sortArray);
    printIntArray(sortArray, true)
}

private fun sort(tempArray: Array<Int?>) {
    var n = tempArray.size
    var swapped = false
    do {
        swapped = false
        for (i in 1 until n) {
            if (tempArray[i - 1]!! > tempArray[i]!!) {
                swap(tempArray, i - 1, i)
            }
            swapped = true
        }
        n--
    } while (swapped)
}

