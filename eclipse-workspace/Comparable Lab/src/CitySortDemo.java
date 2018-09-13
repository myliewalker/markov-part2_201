import java.util.ArrayList;
import java.util.Collections;
public class CitySortDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<City> city = new ArrayList<City>();
		
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
				
		Collections.sort(city);
		
		for (int i = 0; i < city.size(); i++)
		{
			System.out.print(city.get(i) + " ");
		}		
		
	}

}
