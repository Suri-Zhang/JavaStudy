package day37Feb27th;

import java.util.NoSuchElementException;

public class LinkedList<T extends Comparable<T>> implements List<T> {

    private Node head;
    private Node tail;
    private int size;

    /*
     * Creates an empty list.
     */
    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean add(T value) {
        insertLast(value);
        return true;
    }

    @Override
    public T remove() {
        return removeLast();
    }

    @Override
    public int size() {
        return getSize();
    }

    @Override
    public void clear() {
        int size = getSize();
        while (size != 0) {
            remove();
            size--;
        }
    }

    /*
     * Returns a space-separated list of the elements in the list.
     * If the list contains no elements, return an empty string ""
     */
    public String toString() {
        if (head == null || head.next == null) {
            return "";
        }
        Node current = head;
        String result = "";  // create empty String
        while (current != null) {
            result = result + current.data + "\n";
            current = current.next;

        }
        return result;
    }

	@Override
	public void sort() {
		head = mergeSort(head);
        Node p = head;
        while (p.next != null) {
            p = p.next;
        }
        tail = p;
	}

	private Node mergeSort(Node h) {
        // Base case : if head is null
        if (h == null || h.next == null) {
            return h;
        }

        Node middle = getMiddle(h);
        Node nextOfMiddle = middle.next;
        middle.next = null;
        Node left = mergeSort(h);
        Node right = mergeSort(nextOfMiddle);
        return sortedMerge(left, right);
    }

    private Node sortedMerge(Node a, Node b) {
        Node result = null;
        if (a == null)
            return b;
        if (b == null)
            return a;
        Node temp = null;
        if (a.data.compareTo(b.data) < 0) {
            result = a;
            temp = sortedMerge(a.next, b);
        } else {
            result = b;
            temp = sortedMerge(a, b.next);
        }
        result.next = temp;
        temp.pre = result;
        return result;
    }

    private Node getMiddle(Node head) {
        if (head == null) {
            return null;
        }
        Node slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    /*
     * Returns the first item in the list. If the list is empty,
     * throw a NoSuchElementException.
     */
    public T getFirst() {
        if (head != null) {
            return head.data;
        } else {
            throw new NoSuchElementException();
        }
    }

    /*
     * Returns the last item in the list. If the list is empty,
     * throw a NoSuchElementException.
     */
    public T getLast() {
        if (tail != null) {
            return tail.data;
        } else {
            throw new NoSuchElementException();
        }
    }

    /*
     * Returns the item at the specified index. If the index
     * is not valid, throw an IndexOutOfBoundsException.
     */
    public T getAt(int index) {
        Node current = head;
        int i = 0;
        while (current != null && i <= index) {
            if (index == i) {
                return current.data;
            } else {
                i++;
            }
        }
        throw new NoSuchElementException();
    }

    /*
     * Inserts an item at the beginning of the list.
     */
    public void insertFirst(T num) {
        Node newNode = new Node(num);
        newNode.next = head;
        head.pre = newNode;
        head = newNode;
        size++;
    }

    /*
     * Inserts an item at the end of the list.
     */
    public void insertLast(T num) {
        Node newNode = new Node(num);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.pre = tail;
            tail.next = newNode;
            tail = tail.next;
        }
        size++;
    }

    /*
     * Removes and returns the first element from the list.  If the
     * list is empty, throw a NoSuchElementException.
     */
    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T returnValue = head.data;
        if (head == tail) // only one element in list
        {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
        size--;
        return returnValue;
    }

    /*
     * Removes and returns the last element from the list.  If the
     * list is empty, throw a NoSuchElementException.
     */
    public T removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T returnValue = tail.data;
        if (getSize() == 1) {
            head = null;
            tail = null;
            return returnValue;
        }
        tail = tail.pre;
        tail.next = null;

        size--;
        return returnValue;
    }

    /*
     * Returns the number of elements in the list.
     */
    public int getSize() {
        return size;
    }

    /*
     * Returns true if the list is empty, and false otherwise.
     */
    public boolean isEmpty() {
        return (head == null);
    }

    void printBackwards() {
        Node p = tail;
        while (p != head) {
            System.out.println(p.data + " ");
            p = p.pre;
        }
        System.out.println(p.data);
    }


    // A private Node class.  By making it an inner class,
    // the outer class can access it easily, but the client cannot.
    private class Node {
        private T data;
        private Node pre;
        private Node next;

        // Constructs a new Node with the specified data
        private Node(T data) {
            this.data = data;
            this.next = null;
        }

        private Node() {
            this.next = null;
            this.pre = null;
        }
    }
}
