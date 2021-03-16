package com.metacube.StackQueueHashing.Queues;
	
/*
 * Queue interface to list down all possible functionalities
 * @param <T> generic type data
 */
public interface Queue<T> {
		
	 	// operation to add element to queue
		public boolean enqueue (T element);
		
		// operation to delete an element
		public T dequeue ();
		
		// operation to check if queue is empty or not
		public boolean isEmtpy ();
		
		// operation to check if queue is full or not
		public boolean isFull ();
	
}
