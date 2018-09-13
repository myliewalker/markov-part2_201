
public class Student extends Person {
	
	private String major;
	public Student (String name, int birthYear, String nMajor)
	{
		super (name, birthYear);
		major = nMajor;
	}
	
	public String getMajor()
	{
		return major;
	}
	
	public String toString()
	{
		return getClass().getName() + "[name: " + getName() + "]" + "[birth year: " + getBirthYear() + "]" + "[major: " + major + "]";
	}
}
