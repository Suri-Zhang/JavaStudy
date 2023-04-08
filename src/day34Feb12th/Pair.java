package day34Feb12th;

/**
 * Generic Pair Class for Generic Participation Exercise
 * 
 * @author john1819
 *
 */
public class Pair<T>
{
	private T first;
	private T second;

	/**
	 * Constructs a pair containing two given elements.
	 * 
	 * @param firstElement
	 * @param secondElement      element
	 */
	public Pair(T firstElement, T secondElement)
	{
		first = firstElement;
		second = secondElement;
	}

	/**
	 * Swap method should swap the first and second elements of the pair.
	 */
	public void swap(){
		T temp = first;
		first = second;
		second = temp;
	}
	/**
	 * @return the first
	 */
	public T getFirst()
	{
		return first;
	}

	/**
	 * @return the second
	 */
	public T getSecond()
	{
		return second;
	}

	@Override
	public String toString()
	{
		return "Pair [first=" + first + ", second=" + second + "]";
	}

}
