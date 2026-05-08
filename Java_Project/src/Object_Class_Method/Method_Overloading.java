package Object_Class_Method;

public class Method_Overloading {
	void details(int rollno, String name)
	{
		System.out.println("Rollno ="+rollno);
		System.out.println("name ="+name);
	}
	void details(String name,int rollno )
	{
		System.out.println("name ="+name);
		System.out.println("Rollno ="+rollno);
		
	}
	void details(int rollno ,String name, int age)
	{
		System.out.println("Rollno ="+rollno);
		System.out.println("name ="+name);
		System.out.println("Age ="+age);
	}
 
	public static void main(String[] args) {
		Method_Overloading stud=new Method_Overloading();
		stud.details(101, "Nisha", 20);
}
}
