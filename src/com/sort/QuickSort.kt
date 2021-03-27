package com.sort

import com.utils.getRandomIntArray
import com.utils.printIntArray
import com.utils.swap

fun main(args: Array<String>) {
    val arr = getRandomIntArray(count = 14)
//    val arr = arrayOf(171, 80, 23)

    quickSort(arr, 0, arr.size - 1);
    printIntArray(arr, true)
}

/**
 * 快速排序，刚开始的思想 跟归并排序刚好相反。这里讲究的是先大范围有序，再小范围有序
 * 先取一个值，当做参考点，如第一个数(v)
 * 再对后面的数遍历，如果比这个数大，那就继续，否则把那个数放到之前j的位置，并++
 *
 * 优化：把第一个数当参考点，在面对相对有序的数组时，会有性能上的问题。
 * 所以好的办法就是先取个随机位置的数，再跟第l个数替换下
 */
fun quickSort(arr: Array<Int?>, low: Int, high: Int) {
    if (low >= high) {
        return
    }
    val p: Int
    var l = low
    var r = high

    p = arr[l]!!

    while (l < r) {
        while (arr[r]!! >= p && l < r)
            r--

        while (arr[l]!! <= p && l < r)
            l++

        swap(arr, l, r)
    }

    swap(arr, low, l)

    quickSort(arr, low, r - 1)
    quickSort(arr, r + 1, high)
}