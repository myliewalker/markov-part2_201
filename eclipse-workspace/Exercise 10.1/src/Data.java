
public class Data {

	public static double average(Measurable[] objects)
	{
		double sum = 0;
		for (Measurable obj : objects)
		{
			sum = sum + obj.getMeasure();
		}
		if (objects.length > 0) { return sum / objects.length; }
		else { return 0; }
	}
	
	private double largest = 0;
	public double computeLargest(Measurable[] objects)
	{
		for (Measurable obj: objects)
		{
			if (obj > largest)
			{
				largest = obj;
			}
		}
		return largest;
	}	
}
