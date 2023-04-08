package day33Feb11st;

import java.util.NoSuchElementException;

public class LinkedList {

    private Node head;
    private Node tail;
    private int size;

    /*
     * Creates an empty list.
     */
    public LinkedList() {
        head = new Node(0);
        tail = head;
        size = 0;
    }

    /*
     * Returns a space-separated list of the elements in the list.
     * If the list contains no elements, return an empty string ""
     */
    public String toString() {
        if (size == 0) {
            return "";
        }
        Node currentIndex = head.next;
        StringBuilder store = new StringBuilder();
        int index = size;
        while (index > 0) {
            store.append(currentIndex.data).append(" ");
            currentIndex = currentIndex.next;
            index--;
        }
        return store.toString();
    }


    /*
     * Returns the first item in the list. If the list is empty,
     * throw a NoSuchElementException.
     */
    public int getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.next.data;
    }

    /*
     * Returns the last item in the list. If the list is empty,
     * throw a NoSuchElementException.
     */
    public int getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return tail.data;
    }

    /*
     * Returns the item at the specified index. If the index
     * is not valid, throw an IndexOutOfBoundsException.
     */
    public int getAt(int index) {
        if (index >= size) {
            throw new NoSuchElementException();
        }
        Node current = head;
//        int times = 0;
//        while (current.next != tail) {
//            if (times == index) {
//                return current.data;
//            }
//            times++;
//            current = current.next;
//        }
        // 3
        while (index > 0) {
            current = current.next;
            index--;
        }
        return current.data;
    }

    /*
     * Inserts an item at the beginning of the list.
     */
    public void insertFirst(int num) {
        Node n = new Node(num);
        n.next = head.next;
        head.next = n;
        if (size == 0) {
            tail = n;
        }
        size++;

//        int returnValue = tail.data;
//        if (head == tail) {
//            head = null;
//            tail = null;
//        }
//        Node current = head;
//        Node temLast = null;
//        Node temNext = null;
//        while (current.next != tail) {
//            temLast = current;
//            current.data = num;
//            temNext = current.next;
//        }
//        current.next = null;
//        tail = current;
//        size++;

    }

    /*
     * Inserts an item at the end of the list.
     */
    public void insertLast(int num) {
        Node current = new Node(num);
        tail.next = current;
        tail = current;
        size++;
    }

    /*
     * Removes and returns the first element from the list.  If the
     * list is empty, throw a NoSuchElementException.
     */
    public int removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int value = head.data;
        if (size == 1) {
            tail = null;
        }
        else {
            head = head.next;
        }
        size--;
        return value;
    }

    /*
     * Removes and returns the last element from the list.  If the
     * list is empty, throw a NoSuchElementException.
     */
    public int removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Node current = head;
        while (current.next != tail) {
            current = current.next;
        }
        int returnValue = tail.data;
        tail = current;
        size--;
        //now remove the node at tail and fic the list
        //fine the next to last node

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
        return size == 0;
    }


    // A private Node class.  By making it an inner class,
    // the outer class can access it easily, but the client cannot.
    private class Node {
        private int data;
        private Node next;

        // Constructs a new node with the specified data
        private Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
