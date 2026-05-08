package Inheritance;

//Single Inheritance
class Animal{
	void eat(String eat) 
	{
		System.out.println("Food eat: "+eat);
	}
	void sound(String sound) 
	{
		System.out.println("Sound like: "+sound);
	}
}
class Dog extends Animal
{
	void colour() 
	{
		System.out.println("Black");
	}
}
class Cat extends Animal
{
	void Run() 
	{
		System.out.println("Cat Run");
	}
}
public class Single_Inheritance 
{
	public static void main(String[] args)
	{
		Dog dg = new Dog();
		dg.eat("Meat");
		dg.sound("Bhow bhow");
		dg.colour();
		
		Cat ct = new Cat();
		ct.eat("Fish");
		ct.sound("Mow Mow");
		ct.Run();
//		ct.colour(); will not work as not extends
	}
}
