package test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import collections.linkedlist.FindMiddleElement;

public class TestFindMiddleElementinLinkedList {

	@Test
	public void test() {
		assertEquals("C", FindMiddleElement.search(Arrays.asList("A", "B", "C", "D", "E")));
		assertEquals("A", FindMiddleElement.search(Arrays.asList("A", "B")));
	}

}
