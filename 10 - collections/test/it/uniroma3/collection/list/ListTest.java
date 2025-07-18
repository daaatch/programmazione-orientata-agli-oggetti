package it.uniroma3.collection.list;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

public class ListTest {
	
	private Collection<Integer> c;
	private Collection<Integer> t;
	
	@Before
	public void setUp () {
		c = new LinkedList<Integer>();
		t = new ArrayList<Integer>();
		c.add(1);
		c.add(2);
		c.add(3);
		t.add(1);
		t.add(2);
	}
	
	@Test
	public void testRemoveAll() {
		assertTrue(c.removeAll(t));
		Iterator<Integer> it = c.iterator();
		assertTrue(it.hasNext());
		assertEquals(3,it.next().intValue());
		assertFalse(it.hasNext());
	}
	
}