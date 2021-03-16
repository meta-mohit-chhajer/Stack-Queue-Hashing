package com.metacube.StackQueueHashing.Queues;

public class CircularQueue<T> implements Queue<T> {
	int front, rear;
	
	// size of queue
	int size;
	
	// elements of queue
	int array[];
	
	public CircularQueue(int capacity) {
		this.size = capacity;
		this.front = this.rear = -1;
		this.array = new int[capacity];
	}
	
	/*
	 * Add an element to queue
	 * @param T of type Queue is defined
	 * @return true if successfully added else false
	 */
	@Override
	public boolean enqueue(T element) {
		
		// checking if queue is already full or not
		if (isFull()) {
			throw new AssertionError("Queue is full");
		} else {
			if (this.front == -1) {
				this.front = 0;
			}
			this.rear = (this.rear + 1) % this.size;
			this.array[this.rear] = (Integer)element;
			return true;
		}
	}

	/*
	 * Deleting an element from queue
	 * @return removed element is returned of type T
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T dequeue() {
		T data;
		
		// checking if queue is empty or not
		if (isEmtpy()) {
			throw new AssertionError("Queue is empty");
		} else {
			
			// remove element
			data = (T)(Integer)this.array[this.front];
			
			// adjust both front and rear of queue
			if (this.front == this.rear) {
				this.front = this.rear = -1;
			} else {
				this.front = (this.front + 1) % this.size;
			}
			return (T)data;
		}
	}

	/*
	 * Checks if queue is empty or not
	 * @return true if empty else false
	*/
	@Override
	public boolean isEmtpy() {
		if (this.front == -1) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Checks if queue if full or not
	 * @return true if full else false
	 */
	@Override
	public boolean isFull() {
		if (this.front == 0 && this.rear == this.size - 1) {
			return true;
		}
		if (this.front == this.rear + 1) {
			return true;
		}
		return false;
	}

	public static void main (String[] args) {
		CircularQueue<Integer> queue = new CircularQueue<Integer>(5);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		System.out.println(queue.dequeue());
		queue.enqueue(6);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}
}
