package day38Mar17th;

import java.util.NoSuchElementException;

/**
 * Complete the empty methods so that this class works with
 * the StackDriver.java class given.  You may implement
 * using either a LinkedList or an array.  You MAY NOT use
 * the Java library Stack, LinkedList, or ArrayList classes.
 * @author john1819
 *
 */
public class GenericStack<T> {

	private Node head;
	private Node tail;
	private int size;
    public GenericStack() {
        super();
    }


	public void push(T newEntry) {
        insertFirst(newEntry);
	}


	public T pop() {
        return removeFirst();
	}

	public T peek() {
        return getFirst();
	}


	public boolean isEmpty() {
		return getSize() == 0;
	}

	public void clear() {
		// TODO Auto-generated method stub
        while (!isEmpty()) {
            pop();
        }
	}

	public int getSize() {
		return size;
	}
	public T getFirst() {
		if (head != null) {
			return head.data;
		} else {
			throw new NoSuchElementException();
		}
	}
	public T removeFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		T returnValue = head.data;
		if (head == tail) {
			head = null;
			tail = null;
		} else {
			head= head.next;
		}
		size --;
		return returnValue;
	}

	public void insertFirst(T val) {
		Node newNode = new Node(val);
		newNode.next = head;

		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {

			head = newNode;
		}
		size ++;
	}
	private class Node {
		private T data;
		private Node next;

		// Constructs a new node with the specified data
		private Node(T data) {
			this.data = data;
			this.next = null;
		}

		private Node(){
			this.next = null;
		}
	}

}
