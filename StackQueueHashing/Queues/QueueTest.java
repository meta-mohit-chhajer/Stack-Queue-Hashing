package com.metacube.StackQueueHashing.Queues;
import org.junit.Assert;
import org.junit.Test;
public class QueueTest {
	// test case for adding queue
		@Test
		public void enqueueTest () {
			CircularQueue<Integer> queue = new CircularQueue<Integer>(3);
			Assert.assertEquals(true, queue.enqueue(1));
			Assert.assertEquals(true, queue.enqueue(2));
			Assert.assertEquals(true, queue.enqueue(3));
			queue.dequeue();
		}
		
		// test case for overflowing queue
		@Test(expected = AssertionError.class)
		public void queueFullTest () {
			CircularQueue<Integer> queue = new CircularQueue<Integer>(3);
			queue.enqueue(1);
			queue.enqueue(1);
			queue.enqueue(1);
			queue.enqueue(1);
		}
		
		// test case for removing element
		@Test
		public void dequeueTest () {
			CircularQueue<Integer> queue = new CircularQueue<Integer>(3);
			queue.enqueue(1);
			queue.enqueue(2);
			Assert.assertEquals((Integer)1, (Integer)queue.dequeue());
			queue.enqueue(3);
			Assert.assertEquals((Integer)2, (Integer)queue.dequeue());
			queue.enqueue(4);
			Assert.assertEquals((Integer)3, (Integer)queue.dequeue());
			Assert.assertEquals((Integer)4, (Integer)queue.dequeue());
		}
		
		// test case for underflowing condition
		@Test(expected = AssertionError.class)
		public void dequeueEmptyTest () {
			CircularQueue<Integer> queue = new CircularQueue<Integer>(3);
			queue.enqueue(1);
			queue.enqueue(2);
			queue.dequeue();
			queue.dequeue();
			queue.dequeue();
		}
}
