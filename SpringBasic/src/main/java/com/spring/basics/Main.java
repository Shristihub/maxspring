package com.spring.basics;

class Base{
	public void test() {
		System.out.println("great");
	}
}
class Da extends Base{
	public void test() {
		System.out.println("greatday");
	}
}
class Db extends Da{
	public void test() {
		System.out.println("hi");
	}
	
}
public class Main {
	public static void main(String[] args) {
		Base a1 = new Db();
		Base a2 = new Da();
		Base a3 = new Db();
		
		a1= a3;
		Base a4 = a3;
		a1.test();
		a4.test();
		
	}

}
