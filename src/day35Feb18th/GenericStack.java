package day35Feb18th;

/**
 * Complete the empty methods so that this class works with
 * the StackDriver.java class given.  You may implement
 * using either a LinkedList or an array.  You MAY NOT use
 * the Java library Stack, LinkedList, or ArrayList classes.
 * @author john1819
 *
 */
public class GenericStack<T> extends LinkedList<T> implements StackInterface<T>  {

    public GenericStack() {
        super();
    }

	@Override
	public void push(T newEntry) {
        insertFirst(newEntry);
	}

	@Override
	public T pop() {
        return removeFirst();
	}

	@Override
	public T peek() {
        return getFirst();
	}

	@Override
	public boolean isEmpty() {
		return getSize() == 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
        while (!isEmpty()) {
            pop();
        }
	}

}
