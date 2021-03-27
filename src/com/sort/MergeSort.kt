package com.sort

import com.utils.getRandomIntArray
import com.utils.printIntArray
import com.utils.swap

fun main(args: Array<String>) {
    val arr = getRandomIntArray(count = 3)

    sort(arr, 0, arr.size - 1);
    printIntArray(arr, true)
}

/**
 * 归并在拆分的时候，采用的是递归要思想，想着就是把整个数组一直1分为2下去，知道见底
 * 见底后，再依次往上有规则有计划的合并，保证合并后的那部分是有序的。
 */
private fun sort(arr: Array<Int?>, l: Int, r: Int) {
    if (l >= r) {
        return
    }
    val mid = (l + r) / 2
    sort(arr, l, mid)
    sort(arr, mid + 1, r);
    merge(arr, l, mid, r)
}

/**
 * 归并算法，讲究的是先把大的数组各种分段，
 * 分到最小单位的时候，再合并回来，
 * 在合并的时候，要左右排序，保证右半部分是比左半部分大的
 */
fun merge(arr: Array<Int?>, l: Int, mid: Int, r: Int) {
    val arrayCopy = arr.copyOfRange(l, r + 1)
    var i = l
    var j = mid + 1

    for (k in l..r) {
        when {
            i > mid -> {//左半部分处理完了，直接处理右边的
                arr[k] = arrayCopy[j - l]
                j++
            }
            j > r -> {//右半部分处理完了，直接处理左边的
                arr[k] = arrayCopy[i - l]
                i++
            }
            arrayCopy[i - l]!! < arrayCopy[j - l]!! -> {
                arr[k] = arrayCopy[i - l]
                i++;
            }
            else -> {
                arr[k] = arrayCopy[j - l]
                j++;
            }
        }
    }


}

