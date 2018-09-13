
public class Coin {
	private double value = 0;
	private String name = "";
	
	public Coin (double aValue, String aName)
	{
		value = aValue;
		name = aName;
	}
	
	public double getValue()
	{
		return value;
	}
	
	public String getName()
	{
		return name;
	}
}
