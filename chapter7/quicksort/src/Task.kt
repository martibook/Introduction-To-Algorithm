// type your solution here

package chapter7.quicksort.src

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
        if (A[j] < x) {
            i += 1
            swap(A, i, j) // 被换到 A[j] 的 A[i] 属于[i+1,k]区间，==x
            k += 1
            swap(A, k, j) // 被置换后的 A[j]==x, 需被换到 [i+1,k]区间
        }
        if (A[j] == x) {
            k += 1
            swap(A, k, j)
        }
        if (A[j] > x) {
            // do nothing
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
        val pair = enhancedPartition(A, p, r)
        enhancedQuicksort(A, p, pair.first-1)
        enhancedQuicksort(A, pair.second+1, r)
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
}



