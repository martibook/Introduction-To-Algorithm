// type your solution here

class Stack(n: Int) {
    private val length = n
    private val s = IntArray(n)
    private var top = 0 // 表示新加的元素可以直接放置的位置，也就是已有元素的个数

    fun empty(): Boolean {
        return top == 0
    }
    fun push(v: Int) {
        if (top == length) {
            error("stack overflow")
        }
        s[top++] = v
    }
    fun pop(): Int {
        if (empty()) {
            error("stack underflow")
        }
        return s[--top]
    }
    fun show() {
        val stack = s.copyOfRange(0, top)
        println(stack.joinToString(" "))
    }
}

fun runStack() {
    val s = Stack(3)
    s.push(1)
    s.push(2)
    s.push(3)
    s.show()
//    s.push(4)
    s.pop()
    s.pop()
    s.pop()
    s.show()
//    s.pop()
}

class Queue(n: Int) {
    private val length = n
    private val q = IntArray(n)
    private var head = 0 // 第一个元素的下标，一开始没有元素，本应该是-1，但现在有 cnt 判空，所以可以是0， 这样 enqueue就不用take case head 了
    private var tail = 0  // 新加元素可以直接放置的位置
    private var cnt = 0 // 已有元素的个数，因为下标有循环，tail是无法表示个数的

    fun empty(): Boolean {
        return cnt == 0
    }
    fun full(): Boolean {
        return cnt == length
    }
    fun dequeue(): Int {
        if (empty()) {
            error("empty queue")
        }
        val x = q[head]
        head = (head+1) % length
        cnt -= 1
        return x
    }
    fun enqueue(v: Int) {
        if (full()) {
            error("full queue")
        }
        q[tail] = v
        tail = (tail+1) % length
        cnt += 1
    }
    fun show() {
        val valid = IntArray(cnt)
        for (i in 0 until cnt) {
            val j = (i+head)%length
            valid[i] = q[j]
        }
        println(valid.joinToString(" "))
    }
}

fun runQueue() {
    val q = Queue(3)
    q.enqueue(1)
    q.enqueue(2)
    q.enqueue(3)
    q.show()
//    q.enqueue(4)
    q.dequeue()
    q.dequeue()
    q.show()
    q.dequeue()
    q.show()
    q.enqueue(13)
    q.show()
}

fun main() {
//    runStack()
    runQueue()
}