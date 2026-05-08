package Keyword;
class Animal1
{
	void Eat()
	{
		System.out.println("Eat food");
	}
	void Sound()
	{
		System.out.println("Make sount");
	}
}
class Dog extends Animal1
{
	void Eat()
	{
		System.out.println("Meat");
	}
	void Sound()
	{
		System.out.println("Bho bho");
	}
}
class Cat extends Animal1
{
	void Eat()
	{
		System.out.println("Fish");
	}
	void Sound()
	{
		System.out.println("mow mow");
	}
}
public class Polymorphism {

	public static void main(String[] args) {
		Dog d = new Dog();
		d.Eat();
		d.Sound();
		
		Cat c = new Cat();
		c.Eat();
		c.Sound();
	}

}
