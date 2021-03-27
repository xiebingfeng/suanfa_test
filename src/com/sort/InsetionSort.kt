package com.sort

import com.utils.getRandomIntArray
import com.utils.printIntArray
import com.utils.swap
import javax.sound.midi.Soundbank

fun main(args: Array<String>) {
    val sortArray = getRandomIntArray(count = 12)
//    val sortArray = Array<Int?>(13) {
//        it
//    }
//    sortArray[0] = 32
//    sortArray[1] = 22
//    sortArray[2] = 12

    sort(sortArray)
    printIntArray(sortArray, true)
}

/**
 * 插入排序
 * 核心的一点是 j之前的多是有序的,如下面的break，到那个点了，就不用再比较了，反正是有序的了
 */
private fun sort(arr: Array<Int?>) {
    val size = arr.size

    for (i in 1 until size) {
        val temp = arr[i]
        var t = i - 1;

        //前面的那个数比后面的数大
        while (t >= 0 && arr[t]!! > temp!!) {
            arr[t + 1] = arr[t]
            t--
        }
        arr[t + 1] = temp
    }
}