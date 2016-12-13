package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import simple.Zoo;

public class TestZoo {

	@Test
	public void test() {
	
		assertEquals('a', Zoo.findDuplicate("java"));
		assertEquals('a', Zoo.findDuplicate("jav"));
		
	}

}
