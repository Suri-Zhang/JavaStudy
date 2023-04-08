import day35Feb18th.GenericStack;

import java.util.*;

/**
 * @author Rex Joush
 * @time 2023.03.09
 */
public class Daily<T> {


    public List<Integer> collapse(List<Integer> list) {

        Queue<Integer> queue = new LinkedList<>(list);

        int size = list.size();

        while (size > 1) {
            Integer p1 = queue.poll();
            Integer p2 = queue.poll();
            queue.add(p1 + p2);
            size -= 2;
        }

        if (size == 1) {
            queue.add(queue.poll());
        }
        return new ArrayList<>(queue);

    }

    public String[] words;
    public int size;
    public int size() {
        return size;
    }
    public void removeAllInstances(String s) {
        if (size == 0) {
            return;
        }

        for (int i = 0; i < size(); i++) {
            if (words[i].equals(s)) {
                for (int j = i; j < size - 1; j++) {
                    words[j] = words[j + 1];
                }
                size--;
            }
        }
    }





    public static <T> void reverseQueue(Queue<T> theQueue) {
        Stack<T> stack = new Stack<>();

        while (!theQueue.isEmpty()) {
            stack.add(theQueue.poll());
        }
        StringBuilder s = new StringBuilder();
        while (!stack.isEmpty()) {
            s.append(stack.pop()).append(" ");
        }
    }
    private Node<T> head;
    private Node<T> tail;

    public String toStringBackwards() {
        if (size() == 0) {
            return "";
        }
        Stack<Node<T>> stack = new Stack<>();

        Node<T> p = head;
        while (p != null) {
            stack.add(p);
            p = p.next;
        }

        StringBuilder s = new StringBuilder();
        while (!stack.isEmpty()) {
            s.append(stack.pop().data).append(" ");
        }
        return s.toString();
    }

    private class Node<E> {
        private E data;
        private Node<E> next;
        private Node<E> previous;

        /**
         * Constructs a new node with the specified data
         *
         * @param data
         */
        private Node(E data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }


    public static <T extends Comparable<T>> boolean equals(GenericStack<T> stack1, GenericStack<T> stack2) {

        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (!stack1.pop().equals(stack2.pop())) {
                return false;
            }
        }
        return stack1.isEmpty() && stack2.isEmpty();
    }
    public static void main(String[] args) {
        Daily<String> daily = new Daily<>();
        GenericStack<String> stack1 = new GenericStack<>();
        stack1.push("joush");
        stack1.push("rex");
        GenericStack<String> stack2 = new GenericStack<>();
        stack2.push("joush");
        stack2.push("aaa");
        System.out.println(Daily.equals(stack1, stack2));
    }
}
