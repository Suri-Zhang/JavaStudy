package day36Feb23th;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LinkedQueueTest {
	
	QueueInterface<Integer> queue;
	
	@Before
	public void createQueue() {
		queue = new LinkedQueue<>(); // change to LinkedQueue when you are ready
	}


	@Test
	public void testIsEmpty() {
		assertTrue(queue.isEmpty());
		queue.add(10);
		assertFalse(queue.isEmpty());
	}
	
	@Test
	public void testPeek() {
		int[] data = {47, 83, 55, 99, 66, 27, 68};
		
		for (int n : data) {
			queue.add(n);
			assertEquals(47, (int)queue.peek());
		}
	
	}
	
	@Test
	public void testQueueing() {
		int[] data = {47, 83, 55, 99, 66, 27, 68};
		
		for (int n : data) {
			queue.add(n);
			assertFalse(queue.isEmpty());
			assertEquals(n, (int)queue.remove());
			assertTrue(queue.isEmpty());
		}		
		
		for (int n : data) {
			queue.add(n);
		}
		for (int n : data) {
			queue.add(n);
		}
		queue.remove();
		queue.remove();
		for (int n : data) {
			queue.add(n);
		}
		
		for (int i = 2; i < data.length; i++) {
			assertEquals(data[i], (int)queue.remove());
		}
		for (int n : data) {
			assertEquals(n, (int)queue.remove());
		}		
		
		while(!queue.isEmpty()) {
			queue.remove();
		}		
		
		assertTrue(queue.isEmpty());		
		
	}
	
	@Test(expected = Exception.class)
	public void whenExceptionThrown_thenExpectationSatisfied() {
		queue.clear();
		queue.remove();
	}

	@Test
	public void testAdd() {
		queue.add(1);
		assertFalse(queue.isEmpty());
	}

	@Test
	public void testRemove() {
		queue.add(1);
		int remove = queue.remove();
		assertEquals(remove, 1);
	}

	@Test
	public void testAddOne() {
		queue.add(1);
		assertFalse(queue.isEmpty());
		queue.add(3);
		assertFalse(queue.isEmpty());
	}

	@Test
	public void removeOne() {
		queue.add(4);
		assertFalse(queue.isEmpty());
		queue.remove();
		assertTrue(queue.isEmpty());
	}

	@After
	public void close() {
		System.out.println("after1");
	}

}
