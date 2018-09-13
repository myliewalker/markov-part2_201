
public class City implements Comparable<City>{

	private String name;
	private String state;
	public City(String cityName, String cityState)
	{
		name = cityName;
		state = cityState;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getState()
	{
		return state;
	}
	
	public String toString()
	{
		return getClass().getName() + "[name: " + name + "]" + "[state: " + state + "]";
	}

	@Override
	public int compareTo(City o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
