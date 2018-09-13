import java.util.Calendar;
import java.util.GregorianCalendar;

public class DriversLicense extends Card{

	private String expiration;
	GregorianCalendar calendar = new GregorianCalendar();
	
	public boolean expired = false;
	
	public DriversLicense(String name, String exp)
	{
		super (name);
		expiration = exp;
	}
	
	public String format()
	{
		return super.format() + "Expiration year: " + expiration;
	}
	
	public boolean isExpired()
	{
		if (Integer.parseInt(expiration) < calendar.get(Calendar.YEAR))
		{
			expired = true;
		}
		return expired;
	}
	
	public String toString()
	{
		return getClass().getName() + "[name: " + getName() + "]" + "[expiration: " + expiration + "]";
	}
	
	public boolean equals(Object c, Object e)
	{
		if (super.getName() == c && super.getName().equals(c) && expiration == e && expiration.equals(e))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
