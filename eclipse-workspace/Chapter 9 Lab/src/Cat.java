
public class Cat implements Speakable {

	String name;
	public Cat (String n)
	{
		name = n;
	}
	
	public void speak()
	{
		System.out.println("meow");
	}
	
	public String toString()
	{
		return getClass().getName() + "[name: " + name + "]";
	}
}
