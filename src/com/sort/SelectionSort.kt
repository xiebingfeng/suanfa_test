package com.sort

import com.utils.getRandomIntArray
import com.utils.printIntArray
import com.utils.swap

fun main(args: Array<String>) {
    val sortArray = getRandomIntArray(count = 12)

    sort(sortArray)
    printIntArray(sortArray, true)
}

private fun sort(tempArray: Array<Int?>) {
    val size = tempArray.indices
    for (i in size) {
        var minIndex = i
        for (j in i until tempArray.size) {
            if (tempArray[j]!! < tempArray[minIndex]!!) {
                minIndex = j;
            }
        }
        if (minIndex != i) {
            swap(tempArray, i, minIndex)
        }
    }

}

