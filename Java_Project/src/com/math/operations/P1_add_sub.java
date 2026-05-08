package com.math.operations;

class Cal {
    int add(int a,int b) {
        return a+b;
    }
    int subtract(int a,int b) {
        return a-b;
    }
}
public class P1_add_sub {

	public static void main(String[] args) {
        Cal c=new Cal();
        System.out.println("Addition: "+c.add(10,200));
        System.out.println("Subtraction: "+c.subtract(10,200));
    }

}
