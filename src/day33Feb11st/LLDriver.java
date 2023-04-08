package day33Feb11st;

public class LLDriver {
	
	public static void main(String[] args) {
		
		// As we test our methods, make sure the method works as expected...
		// ...with an empty list
		// ...with a non-empty list
		// **** YOU CAN MAKE ANY CHANGES YOU WANT TO THE CODE IN THIS METHOD ****
		// It is your tester.  Test thoroughly.
		// As we test our methods, make sure the method works as expected...
		// ...with an empty list
		// ...with a non-empty list
		
		LinkedList list = new LinkedList();
		System.out.println("?" + list.toString());
		list.insertFirst(17);
		list.removeFirst();
		list.insertFirst(20);
		System.out.println("20 17? " + list.toString());
		
		list.insertLast(50);
		list.insertLast(51);
		System.out.println("20 17 50 51? " + list.toString());
		list.insertFirst(1);
		list.insertFirst(2);
		list.insertFirst(3);
		// add test of removeFirst
		list.removeFirst();
		System.out.println(list);
		
		// add test of removeLast
		list.removeLast();
		System.out.println(list);
		
		// add test of getSize()
		System.out.println(list.getSize());
		// add test of getFirst() and getLast() - these
		//methods should not change the list
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
	}
	
}
