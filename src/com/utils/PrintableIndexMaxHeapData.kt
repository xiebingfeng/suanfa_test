package com.utils

import com.heap.IndexMaxHeap
import com.heap.MaxHeap
import kotlin.math.pow

// 我们的PrintableMaxHeap只能处理整数信息，所以继承的是MaxHeap<Comparable<Integer>>
object PrintableIndexMaxHeapData {

    // 以树状打印整个堆结构
    fun treePrint(heap: IndexMaxHeap) {
        if (heap.size() >= 100) {
            println("This print function can only work for less than 100 integer")
            return
        }
//        println("The max heap size is: " + heap.size())
//        println("Data in the max heap: ")
//        for (i in 1..heap.size()) {
//            // 我们的print函数要求堆中的所有整数在[0, 100)的范围内
//            assert(heap.getIndexData(i) >= 0 && heap.getIndexData(i) < 100)
//            print(heap.getIndexData(i).toString() + " ")
//        }
        println()
        println()
        var n: Int = heap.size()
        var maxLevel = 0
        var numberPerLevel = 1
        while (n > 0) {
            maxLevel += 1
            n -= numberPerLevel
            numberPerLevel *= 2
        }
        val maxLevelNumber = 2.0.pow(maxLevel - 1.toDouble()).toInt()
        var curTreeMaxLevelNumber = maxLevelNumber
        var index = 1
        for (level in 0 until maxLevel) {
            var line1 = String(CharArray(maxLevelNumber * 3 - 1)).replace('\u0000', ' ')
            val curLevelNumber = (heap.count - 2.0.pow(level.toDouble()).toInt() + 1).coerceAtMost(2.0.pow(level.toDouble()).toInt())
            var isLeft = true
            run {
                var indexCurLevel = 0
                while (indexCurLevel < curLevelNumber) {
                    line1 = putNumberInLine(heap.getIndexData(index), line1, indexCurLevel, curTreeMaxLevelNumber * 3 - 1, isLeft)
                    isLeft = !isLeft
                    index++
                    indexCurLevel++
                }
            }
            println(line1)
            if (level == maxLevel - 1) break
            var line2 = String(CharArray(maxLevelNumber * 3 - 1)).replace('\u0000', ' ')
            for (indexCurLevel in 0 until curLevelNumber) line2 = putBranchInLine(line2, indexCurLevel, curTreeMaxLevelNumber * 3 - 1)
            println(line2)
            curTreeMaxLevelNumber /= 2
        }
    }

    private fun putNumberInLine(num: Int, line: String, indexCurLevel: Int, curTreeWidth: Int, isLeft: Boolean): String {
        var line = line
        val subTreeWidth = (curTreeWidth - 1) / 2
        val offset = indexCurLevel * (curTreeWidth + 1) + subTreeWidth
        assert(offset + 1 < line.length)
        line = if (num >= 10) line.substring(0, offset + 0) + num.toString() + line.substring(offset + 2)
        else {
            if (isLeft)
                line.substring(0, offset + 0) + num.toString() + line.substring(offset + 1)
            else line.substring(0, offset + 1) + num.toString() + line.substring(offset + 2)
        }
        return line
    }

    private fun putBranchInLine(line: String, indexCurLevel: Int, curTreeWidth: Int): String {
        var line = line
        val subTreeWidth = (curTreeWidth - 1) / 2
        val subSubTreeWidth = (subTreeWidth - 1) / 2
        val offsetLeft = indexCurLevel * (curTreeWidth + 1) + subSubTreeWidth
        assert(offsetLeft + 1 < line.length)
        val offsetRight = indexCurLevel * (curTreeWidth + 1) + subTreeWidth + 1 + subSubTreeWidth
        assert(offsetRight < line.length)
        line = line.substring(0, offsetLeft + 1) + "/" + line.substring(offsetLeft + 2)
        line = line.substring(0, offsetRight) + "\\" + line.substring(offsetRight + 1)
        return line
    }

//    companion object {
//        // 测试 PrintableMaxHeap
//        fun main(args: Array<String>) {
////            val maxHeap = PrintableMaxHeap(100)
////            val N = 31 // 堆中元素个数
////            val M = 100 // 堆中元素取值范围[0, M)
////            for (i in 0 until N) maxHeap.insert((Math.random() * M).toInt())
////            maxHeap.treePrint()
//        }
//    }
}