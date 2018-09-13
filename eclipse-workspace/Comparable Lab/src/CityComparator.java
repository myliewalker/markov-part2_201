import java.util.Comparator;
public class CityComparator implements Comparator<City>{

	public int compare(City a, City b)
	{
		if (a.getState() != b.getState())
		{
			return a.getState().compareTo(b.getState());
		}
		else
		{
			return a.getName().compareTo(b.getName());
		}
	}
}
