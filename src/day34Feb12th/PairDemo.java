package day34Feb12th;

/**
 * Class to demonstrate Generic Pair class
 * @author john1819
 *
 */
public class PairDemo
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		 String[] names = { "Romeo", "Juliet", "Adam", "Eve"};
		 
		 // create a Pair with Juliet and her index in names array
		 Pair<String> jPair = new Pair("Romeo", "Juliet");
		 Pair<String> ePair = new Pair("Adam", "Eve");
		 System.out.println(jPair);
		 jPair.swap();
		 System.out.println(jPair);
		 System.out.println(ePair);

		 

	}

}
