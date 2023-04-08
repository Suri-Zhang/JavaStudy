package day36Feb23th;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Optional;

public class ArrayQueueTest {

	QueueInterface<Integer> queue;

	@Before
	public void createQueue() {
		queue = new ArrayQueue<>(); // change to LinkedQueue when you are ready
	}

	@Test(expected = Exception.class)
	public void whenExceptionThrown_thenExpectationSatisfied() {
		queue.clear();
		queue.remove();
		
	}

	@Test
	public void remove() {
		queue.add(1);
		int remove = queue.remove();
		assertEquals(1, remove);
	}

	@Test
	public void testAdd() {
		assertTrue(queue.isEmpty());
		queue.add(0);
		assertFalse(queue.isEmpty());
	}

	@Test
	public void testAddOne() {
		queue.add(1);
		assertFalse(queue.isEmpty());
		queue.add(12);
		assertFalse(queue.isEmpty());
	}

	@Test
	public void testIsEmpty() {
		assertTrue(queue.isEmpty());
		queue.add(10);
		assertFalse(queue.isEmpty());
	}

	@Test
	public void testPeek() {
		int[] data = { 47, 83, 55, 99, 66, 27, 68 };

		for (int n : data) {
			queue.add(n);
			assertEquals(47, (int) queue.peek());
		}

	}

	@Test
	public void testQueueing() {
		int[] data = { 47, 83, 55, 99, 66, 27, 68 };

		for (int n : data) {
			queue.add(n);
			assertFalse(queue.isEmpty());
			assertEquals(n, (int) queue.remove());
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
			assertEquals(data[i], (int) queue.remove());
		}
		for (int n : data) {
			assertEquals(n, (int) queue.remove());
		}

		while (!queue.isEmpty()) {
			queue.remove();
		}

		assertTrue(queue.isEmpty());

	}

	@Test
	public void testRemoveOne() {
		queue.add(2);
		assertFalse(queue.isEmpty());
		queue.remove();
		assertTrue(queue.isEmpty());
	}

}
