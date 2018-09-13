
public class Dog implements Speakable {

	String name;
	
	public Dog (String n)
	{
		name = n;
	}
	
	public void speak()
	{
		System.out.println("woof");
	}
	
	public String toString()
	{
		return getClass().getName() + "[name: " + name + "]";
	}

}
