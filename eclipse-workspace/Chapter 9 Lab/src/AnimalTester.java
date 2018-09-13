import java.util.ArrayList;

public class AnimalTester {
	
	public static void main(String[] args)
	{
		
		ArrayList<Speakable> list = new ArrayList<Speakable>();
		for (Speakable obj : list)
		{
			list.add(obj);
		}
		
		for (int i = 0; i < list.size(); i++)
		{
			list.get(i).speak();
		}
	}
}
