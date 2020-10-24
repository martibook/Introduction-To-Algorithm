import org.junit.Assert
import org.junit.Test

class Test {

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

    @Test
    fun testStack() {
        //TODO: implement your test here
        runStack()
        Assert.assertTrue("stack", true)
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

    @Test
    fun testQueue() {
        runQueue()
        Assert.assertTrue("queue", true)
    }
}