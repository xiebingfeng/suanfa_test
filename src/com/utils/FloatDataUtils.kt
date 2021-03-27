package com.utils

//fun swap(arr: Array<Float?>, i: Int, j: Int) {
//    val t = arr[i]
//    arr[i] = arr[j]
//    arr[j] = t
//}

fun printFloatArray(arr: Array<Float?>, checkResult: Boolean = false) {
    arr.forEach {
        print(it)
        print(' ')
    }

    if (checkResult) {
        println()
        println(checkArray(arr))
    }
}

fun checkArray(arr: Array<Float?>): Boolean {
    arr.forEachIndexed { index, it ->
        if (index > 0 && arr[index]!! < arr[index - 1]!!) {
            return false
        }
    }
    return true
}


//fun getRandomFloatArray(count: Int = 10): Array<Float?> {
//    val array = arrayOfNulls<Float>(count)
//    for (i in 0 until count) {
//        array[i] = (1..1000).shuffled().last()
//    }
//    return array
//}


