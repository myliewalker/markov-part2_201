import java.util.Scanner;
import java.util.ArrayList;

public class BarChart {
	public static ArrayList<Integer> readValues()
	{
	Scanner sc = new Scanner(System.in);
	ArrayList <Integer> values = new ArrayList <Integer>(100);

	System.out.println ("Please enter some integers. Enter a negative number to quit.");
	int n = sc.nextInt();
	while (n >= 0)
	{
		values.add(n);
		n = sc.nextInt();
	}
	return values;
	}
	
	public static int findMax (ArrayList<Integer> values)
	{
	int max = values.get(0);
	for (int x : values)
	{
		if (x > max)
		{
			max = x;
		}
	}
	return max;
	}
	
	public static void printBarChart (ArrayList<Integer> values)
	{
	int max = findMax(values);
	for (int i = 0; i < values.size(); i++)
	{
		int n = values.get(i);
		int stars = (40*n/max);
		for (int j = 0; j < stars; j++)
		{
			System.out.print("*");
		}
		System.out.print("");
	}
	}
}
