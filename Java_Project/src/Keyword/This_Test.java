package Keyword;

class Animal
{
	int x=100;
	String name,type;
	void eat(int x,String name, String type)
	{
        this.x=x;// refer current class variable
        this.name=name;
   		this.type=type;
		System.out.println("X=  "+x);
		System.out.println("name=  "+name);
		System.out.println("type "+type);
	}
	void details()
	{
		this.eat(100, "Max","Dog");// refer current class method
	}
	Animal()
	{
		//this(10);
		System.out.println("Default constructor");
	}
	Animal(int a)
	{
		this();
	}
}
 
 
public class This_Test {
 
	public static void main(String[] args) {
		
		Animal a=new Animal(1);
		a.details();
 
	}
 
}