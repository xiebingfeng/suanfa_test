package com.heap

import com.utils.PrintableMaxHeap
import com.utils.swap

open class MaxHeap(capacity: Int) {

    var data: Array<Int?> = arrayOfNulls(capacity + 1)
    var count: Int = 0;

    fun size(): Int {
        return count;
    }

    fun isEmpty(): Boolean {
        return count == 0;
    }

    // 向最大堆中插入一个新的元素 item
    fun insert(item: Int) {
        data[count + 1] = item;
        count++;
        shiftUp(count);
    }

    // 从最大堆中取出堆顶元素, 即堆中所存储的最大数据
    fun extractMax(): Int {
        val ret = data[1]
        swap(data, 1, count)
        count--
        shiftDown(1)
        return ret!!
    }

    //********************
    //* 最大堆核心辅助函数
    //********************
    private fun shiftUp(k: Int) {
        var i = k
        while (i > 1 && data[i / 2]!! < data[i]!!) {
            swap(data, i / 2, i)
            i /= 2;
        }
    }

    private fun shiftDown(k: Int) {
        var i = k
        while (2 * i <= count) {
            var j = 2 * i
            if (j + 1 <= count && data[j + 1]!! > data[j]!!) {
                j++
            }

            if (data[i]!! >= data[j]!!)
                break
            swap(data, i, j)
            i = j
        }
    }
}

// 测试 MaxHeap
fun main(args: Array<String>) {
    val maxHeap = MaxHeap(300)
    val N = 9 // 堆中元素个数
    val M = 100 // 堆中元素取值范围[0, M)
    for (i in 0 until N) maxHeap.insert((Math.random() * M).toInt())

    PrintableMaxHeap.treePrint(maxHeap)

    maxHeap.extractMax()
    PrintableMaxHeap.treePrint(maxHeap)
}