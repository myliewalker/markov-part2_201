
public class Instructor extends Person{

	private int salary;
	
	public Instructor (String name, int birthYear, int newSalary)
	{
		super (name, birthYear);
		salary = newSalary;
	}
	
	public int getSalary()
	{
		return salary;
	}
	
	public String toString()
	{
		return getClass().getName() + "[name: " + getName() + "]" + "[birth year: " + getBirthYear() + "]" + "[salary: " + salary + "]";
	}
}
