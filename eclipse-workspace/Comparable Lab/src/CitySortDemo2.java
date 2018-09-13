import java.util.ArrayList;
import java.util.Collections;

public class CitySortDemo2 {

	public static void main(String[] args)
	{
		ArrayList<City> city = new ArrayList<City> ();
		
		City NewYork = new City("New York", "New York");
		City SanFrancisco = new City ("San Francisco", "California");
		City SanDiego = new City ("San Diego", "California");
		City Chicago = new City ("Chicago", "Illinois");
		City Boston = new City ("Boston", "Massachussets");
		City ColumbusOH = new City ("Columbus", "Ohio");
		City ColumbusGA = new City ("Columbus", "Georgia");
				
		city.add(NewYork);
		city.add(SanFrancisco);
		city.add(SanDiego);
		city.add(Chicago);
		city.add(Boston);
		city.add(ColumbusOH);
		city.add(ColumbusGA);
		
		Collections.sort(city, new CityComparator());
		
		for (int i = 0; i < city.size(); i++)
		{
			System.out.println(city.get(i) + " ");
		}
		
	}
}
