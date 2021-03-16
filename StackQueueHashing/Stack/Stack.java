package com.metacube.StackQueueHashing.Stack;

/*
 * Node class represents a single node in stack
 * @param <T>
 */
class Node<T>{
	T data;
	Node<T> next;
	
	public Node (T data) {
		this.data = data;
		this.next = null;
	}
}


/*
 * Stack implementation
 * @param <T>
 */
public class Stack<T> {
		
	    // creating the node as head
		Node<T> head;
		
		// initializing stack with head pointing to null
		public Stack () {
			this.head = null;
		}
		
		/*
		 * Adding item to stack
		 * @param data to add in stack
		 */
		public void push (T data) {
			
			// create a new node with data
			Node<T> node = new Node<>(data);
			
			// check if stack is empty or not
			if (this.head == null) {
				this.head = node;
			} else {
				node.next = this.head;
				this.head = node;
			}
		}
		
		/*
		 * Removes the element from stack
		 * @return removed element of type T
		 */
		public T pop () {
			// checks if stack is empty or not
			if (this.head == null) {
				throw new AssertionError("Stack is empty !!!");
			}
			
			// remove the node
			T data = (T)this.head.data;
			this.head = this.head.next;
			return data;
		}
		
		/*
		 * Get the top most element in stack
		 * @return element of type T
		 */
		public T getTop () {
			return this.head.data;
		}
		
		/*
		 * Checks if stack is empty or not
		 * @return true if empty else false
		 */
		public boolean isEmpty () {
			return this.head == null;
		}
}
