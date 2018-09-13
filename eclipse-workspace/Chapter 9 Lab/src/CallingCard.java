
public class CallingCard extends Card {

	private String cardNumber;
	private String pin;
	
	public CallingCard (String name, String n, String p)
	{
		super (name);
		cardNumber = n;
		pin = p;
	}
	
	public String format()
	{
		return super.format() + "Card number: " + cardNumber + "PIN: " + pin;
	}
	
	public boolean isExpired()
	{
		return false;
	}
	
	public String toString()
	{
		return getClass().getName() + "[name: " + getName() + "]" + "[cardNumber: " + cardNumber + "]" + "[pin: " + pin + "]";
	}
	
	public boolean equals(Object c, Object n, Object p)
	{
		if (super.getName() == c && super.getName().equals(c) && cardNumber == n && cardNumber.equals(n) && pin == p && pin.equals(pin))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
