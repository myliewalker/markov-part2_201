
public class Person implements Measurable, Comparable{

	private String name;
	private double height = 0;
	
	public Person (String n, int h)
	{
		name = n;
		height = h;
	}
	
	public Person (String n)
	{
		name = n;
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getHeight()
	{
		return height;
	}

	@Override
	public double getMeasure() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}
