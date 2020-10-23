// type your solution here

package chapter7.quicksort.src

import kotlin.math.max
import kotlin.math.min

fun swap(A: IntArray, a: Int, b: Int) {
    val t = A[a]
    A[a] = A[b]
    A[b] = t
}

fun basicPartition(A: IntArray, p: Int, r: Int): Int {

    val x = A[r]
    var i = p - 1
    for (j in p until r) {
        if (A[j] <= x) {
            i += 1
            swap(A, i, j)
        }
    }
    swap(A, i + 1, r)
    return i + 1
}

fun enhancedPartition(A: IntArray, p: Int, r: Int): Pair<Int, Int> {

    val x = A[r]
    var i = p - 1 // <x 的最后下标
    var k = i // =x 的最后下标
    for (j in p until r) {
        when {
            (A[j] < x) -> {
                i += 1
                swap(A, i, j) // 被换到 A[j] 的 A[i] 属于[i+1,k]区间，==x
                k += 1
                swap(A, k, j) // 被置换后的 A[j]==x, 需被换到 [i+1,k]区间
            }
            (A[j] == x) -> {
                k += 1
                swap(A, k, j)
            }
            (A[j] > x) -> {
                // do nothing
            }
        }
    }
    k += 1
    swap(A, k, r)
    return Pair(i + 1, k)
}

fun basicQuicksort(A: IntArray, p: Int, r: Int) {
    if (p<r) {
        val q = basicPartition(A, p, r)
        basicQuicksort(A, p, q-1)
        basicQuicksort(A, q+1, r)
    }
}

fun enhancedQuicksort(A: IntArray, p: Int, r: Int) {
    if (p<r) {
        val (i, k) = enhancedPartition(A, p, r)
        enhancedQuicksort(A, p, i-1)
        enhancedQuicksort(A, k+1, r)
    }
}

fun swap(A: Array<Pair<Int, Int>>, i:Int, j:Int) {
    val t = A[i]
    A[i] = A[j]
    A[j] = t
}

fun enhancedFuzzyPartition(A: Array<Pair<Int, Int>>, p: Int, r: Int): Pair<Int, Int> {
    // pick a random one, swap with A[r]
    var x = A[r]
    var i = p -1  // <x 的最后下标
    var k = i // =x 的最后下标
    for ( j in p until r) {
        when {
            (A[j].second < x.first) -> {
                // A[j] < x
                i += 1
                swap(A, i, j)
                k += 1
                swap(A, k, j)
            }
            (A[j].first > x.second) -> {
                // A[j] > x
                // do nothing
            }
            (A[j].second >= x.first && A[j].first <= x.second) -> {
                // intersection 想象 A[j] 平移去交叉 x, 在有交集的整个过程中，上式都成立
                k += 1
                swap(A, k, j)

                // 此时取 intersection 部分作为新的 x, 因为后续的 A[j] 只有和 intersection 有交集，这些区间才可以被看成等价
                x = Pair(max(x.first, A[j].first), min(x.second, A[j].second))
            }
        }
    }
    k += 1
    swap(A, k, r)
    return Pair(i+1, k)
}

fun enhancedFuzzyQuicksort(A: Array<Pair<Int, Int>>, p: Int, r: Int) {
    if (p<r) {
        val (i, k) = enhancedFuzzyPartition(A, p, r)
        enhancedFuzzyQuicksort(A, p, i-1)
        enhancedFuzzyQuicksort(A, k+1, r)
    }
}

fun main() {
    val A: IntArray = intArrayOf(3, 7, 8, 1, 0, 2, 5, 6, 4)
    println(A.joinToString(" "))
    basicPartition(A, 0, A.size - 1)
    println(A.joinToString(" "))

    basicQuicksort(A, 0, A.size-1)
    println(A.joinToString(" "))

    val B = intArrayOf(2, 6, 7, 4, 4, 1, 9, 4)
    println(B.joinToString(" "))
    enhancedPartition(B, 0, B.size - 1)
    println(B.joinToString(" "))

    enhancedQuicksort(B, 0, B.size-1)
    println(B.joinToString(" "))

    val F = arrayOf(Pair(4,6), Pair(1,2), Pair(3,5), Pair(6,7), Pair(6,9))
    println(F.joinToString(" "))
    enhancedFuzzyQuicksort(F, 0, F.size-1)
    println(F.joinToString(" "))
}



