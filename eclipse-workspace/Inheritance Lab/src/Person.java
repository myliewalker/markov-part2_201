
public class Person {

	private String name = "";
	private int birthYear = 0;
	public Person (String newName, int newBirthYear)
	{
		name = newName;
		birthYear = newBirthYear;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getBirthYear()
	{
		return birthYear;
	}
	
	public String toString()
	{
		return getClass().getName() + "[name: " + name + "]" + "[birth year: " + birthYear + "]";
	}
}
