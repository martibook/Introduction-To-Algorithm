import chapter7.quicksort.src.*
import org.junit.Assert
import org.junit.Test

class Test {
    @Test
    fun testBasicPartition() {
        //TODO: implement your test here
        val A: IntArray = intArrayOf(3, 7, 8, 1, 0, 2, 5, 6, 4)
        val q = basicPartition(A, 0, A.size - 1)
        for (i in 0 until q) {
            if (A[i] > A[q]) {
                Assert.assertTrue("A[i] should be <= A[q]", false)
            }
        }
        for (i in q + 1 until A.size) {
            if (A[i] < A[q]) {
                Assert.assertTrue("A[i] should be >= A[q]", false)
            }
        }
    }

    @Test
    fun testEnhancedPartition() {
        //TODO: implement your test here
        val A = intArrayOf(2, 6, 7, 4, 4, 1, 9, 4)
        val (a, b) = enhancedPartition(A, 0, A.size - 1)
        val x = A[a]
        for (i in 0 until a) {
            if (A[i] >= x) {
                Assert.assertTrue("A[i] should be < x", false)
            }
        }
        for (i in a until b + 1) {
            if (A[i] != x) {
                Assert.assertTrue("A[i] should be = x", false)
            }
        }
        for (i in b + 1 until A.size) {
            if (A[i] <= x) {
                Assert.assertTrue("A[i] should be > x", false)
            }
        }
    }

    @Test
    fun testBasicQuicksort() {
        val A: IntArray = intArrayOf(3, 7, 8, 1, 0, 2, 5, 6, 4)
        basicQuicksort(A, 0, A.size-1)
        for (i in 1 until A.size) {
            if (A[i] < A[i-1]) {
                Assert.assertTrue("A[i] should be > A[i-1", false)
            }
        }
    }

    @Test
    fun testEnhancedQuicksort() {
        val A = intArrayOf(2, 6, 7, 4, 4, 1, 9, 4)
        enhancedQuicksort(A, 0, A.size-1)
        for (i in 1 until A.size) {
            if (A[i] < A[i-1]) {
                Assert.assertTrue("A[i] should be > A[i-1", false)
            }
        }
    }

    @Test
    fun testEnhancedFuzzyQuicksort() {
        val F = arrayOf(Pair(4,6), Pair(1,2), Pair(3,5), Pair(6,7), Pair(6,9))
        enhancedFuzzyQuicksort(F, 0, F.size-1)
        for (i in 1 until F.size) {
            if (F[i-1].first > F[i].second) {
                Assert.assertTrue("A[i-1] should be <= A[i]", false)
            }
        }
    }
}
