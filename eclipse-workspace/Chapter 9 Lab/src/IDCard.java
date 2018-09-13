
public class IDCard extends Card{

	private String idNumber;
	
	public IDCard(String name, String number)
	{
		super (name);
		idNumber = number;
	}
	
	public String format()
	{
		return super.format() + "ID number: " + idNumber;
	}
	
	public boolean isExpired()
	{
		return false;
	}
	
	public String toString()
	{
		return getClass().getName() + "[name: " + getName() + "]" + "[ID number: " + idNumber + "]";
	}
	
	public boolean equals(Object c, Object n)
	{
		if (super.getName() == c && super.getName().equals(c) && idNumber == n && idNumber.equals(n))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
