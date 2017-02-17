package com.my.collections;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		coll1();

	}

	public static void coll1() {
		ArrayList<A> list = new ArrayList<>();
		A a1 = new A("1","one"); 
		A a2 = new A("2","one");
		A a3 = new A("3","one");
		list.add(a1);
		list.add(a2);
		list.add(a3);
		
		list.remove(a3);
		list.removeIf(m -> m.label.equals("1"));
		list.forEach(m -> System.out.println(m.label));
	}

	public static class A {
		String label, value;

		public A(String label, String value) {
			this.label = label;
			this.value = value;
		}

		public boolean equals(Object o) {
			A other = (A) o;
			return value.equalsIgnoreCase(other.value);
		}
	}
}
