
public class MinHeap {
    private int size;
    int[] theHeap;


    /**
     *
     */
    public MinHeap() {
        size = 0;
        theHeap = new int[20];

    }

    /**
     * Insert element e into the minheap Return true if the element is inserted
     * successfully
     */
    public boolean insert(int e) {
        ensureCapacity();

        // implement your code here-
        //don't forget to order heap and increment size
        //after you add e
        // 1.size++
        size++;
        // 2.直接在尾部插入新节点
        theHeap[size] = e;
        // 3.调整堆的顺序，直到堆满足条件
        orderHeap();
        return true;
    }


    /**
     * Private method to aid with insertion
     * order heap after insertion
     * parent = index/2
     */
    private void orderHeap() {
        // two possible cases

        // if this is size = 1 - this is first and only
        // element no need to do anything

        // otherwise start at bottom and check that element at
        // size is greater than parents (code given is
        // incomplete- you must finish it

        int index = size;

//        int parent = size / 2;
//        while (theHeap[parent] > theHeap[index]) {
//            swapNodes(parent, index);
//            index = parent;
//        }


//         while element has parents
        while (index > 1) {
            // parent node can be found at index/2
            int parent = index / 2;
            // if element at parent index is greater than
            // element at  index - swap them
            if (theHeap[parent] > theHeap[index]) {
                swapNodes(parent, index);
            }

            // then change index to parent index.
            index = parent;
        }

    }

    /**
     * Gets the minimum element from top of the heap
     *
     * @return- the element removed
     */
    public int remove() {
        // get the value from the root so that you can return it
        // hint root = theHeap[1] since we don't use element 0
        if (size == 0) {
            return 0;
        }
        int min = theHeap[1];
        // take the value from the last node and copy it to the top
        // hint the last node is theHeap[size] since we don't use element 0
        theHeap[1] = theHeap[size];
        // fix the heap by calling fixHeap
        fixHeap(1);
        // remove the last node (set to 0)
        theHeap[size] = 0;
        // decrement size
        size--;
        // return the removed value
        return min;
    }

    /**
     * This method adjusts the heap after a removal. Makes
     * sure that no child of the indicated index is less than
     * that element in the heap.- this is a working version
     * no need to change
     *
     * @param -index to be checked for heap property
     */
    private void fixHeap(int start) {
        // start at top = is root node greater than either child
        int curr = start;
        // first see if any children exist
        if (curr * 2 + 1 <= size) {
            int min;
            if (theHeap[curr * 2] < theHeap[curr * 2 + 1]) {
                min = curr * 2;
            } else {
                min = curr * 2 + 1;
            }
            swapNodes(curr, min);
            fixHeap(min);
        }

        // 有左
        if (curr * 2 <= size) {
            if (theHeap[curr] > theHeap[curr * 2]) {
                swapNodes(curr, curr * 2);
            }
        }
            // check first child
//            if (theHeap[curr] > theHeap[curr * 2]) {
//                // swap if curr is not smaller
//                swapNodes(curr, curr * 2);
//                fixHeap(curr * 2);
//
//            }
//
//            // check second child if exists
//            if (curr * 2 + 1 <= size) {
//                if (theHeap[curr] > theHeap[curr * 2 + 1]) {
//                    // swap if curr is not smaller
//                    swapNodes(curr, (curr * 2 + 1));
//                    fixHeap(curr * 2 + 1);
//                }
//            }
    }

    /**
     * Private method to swap members of heap at indexes n1 and
     * n2.  Used to adjust heap after insertion or deletion
     *
     * @param n1
     * @param n2
     */
    private void swapNodes(int n1, int n2) {
        int temp = theHeap[n1];
        theHeap[n1] = theHeap[n2];
        theHeap[n2] = temp;

    }


    /**
     * Gets number of elements in the heap
     *
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns true if heap is empty
     *
     * @return - boolean
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Private method to make sure array size of the heap
     * is big enough. Called from insert
     */
    private void ensureCapacity() {
        if (size == (theHeap.length - 1)) {
            int[] oldHeap = theHeap;

            int[] tempHeap = new int[2 * size];
            theHeap = tempHeap;

            for (int i = 0; i <= size; i++) {
                theHeap[i] = oldHeap[i];
            }


        }
    }
}
