package com.heap

import com.utils.PrintableIndexMaxHeap
import com.utils.PrintableIndexMaxHeapData
import com.utils.swap

class IndexMaxHeap(private val capacity: Int) {

    var data = arrayOfNulls<Int>(capacity + 1)
    var index = arrayOfNulls<Int>(capacity + 1)
    var count: Int = 0

    fun getIndexData(i: Int): Int {
        return data[index[i]!!]!!
    }

    fun isEmpty() = count == 0

    fun size() = count

    fun insert(item: Int) {
        if (count + 1 > capacity) {
            println("容量已满，插入失败")
        } else {
            count++
            data[count] = item
            index[count] = count

            //身上调整
            shiftUp(count)
        }
    }

    private fun shiftUp(_k: Int) {
        var k = _k
        //比较的是data数组
        //注意此时堆中存储的是index值，比较的是对应index值对应的data[]数组的值
        if (k > 1 && data[index[k / 2]!!]!! < data[index[k]!!]!!) {
            //交换的是index数组
            swap(index, k / 2, k)
        } else
            return

        k /= 2
        shiftUp(k)
    }

    private fun shiftDown(_k: Int) {
        var k = _k
        while (2 * k <= count) {
            var j = 2 * k
            if (j + 1 <= count && data[index[j + 1]!!]!! > data[index[j]!!]!!) {
                j += 1
            }
            if (data[index[j]!!]!! > data[index[k]!!]!!) {
                val temp = index[j]!!
                index[j] = index[k]
                index[k] = temp
                k = j
            } else
                break
        }
    }

    fun getMaxIndex(): Int {
        return index[1]!!

    }

    fun getItemByIndex(i: Int): Int {
        return data[index[i]!!]!!

    }

    fun change(i: Int, newValue: Int) {
        data[i] = newValue

        for (j in 1..count) {
            if (index[j] == i) {
                shiftUp(j)
                shiftDown(j)
                return
            }
        }
    }

    fun printData() {
        data.forEachIndexed { index, it ->
            it?.let {
                print("($index)$it  ")
            }
        }
        println()
    }

}

// 测试 MaxHeap
fun main(args: Array<String>) {
    val maxHeap = IndexMaxHeap(100)
    val N = 10 // 堆中元素个数
    val M = 100 // 堆中元素取值范围[0, M)
    for (i in 0 until N) maxHeap.insert((Math.random() * M).toInt())

    maxHeap.printData();
    PrintableIndexMaxHeap.treePrint(maxHeap)
    PrintableIndexMaxHeapData.treePrint(maxHeap)

    maxHeap.change(2, 300)

    PrintableIndexMaxHeap.treePrint(maxHeap)
    PrintableIndexMaxHeapData.treePrint(maxHeap)
}