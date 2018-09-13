import java.util.Scanner;
public class SmallestLargest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner (System.in);
		System.out.println("How many integers do you want to enter");
		int values[] = new int[sc.nextInt()];
		
		System.out.println("Please enter your values");
		for (int i = 0; i < values.length; i++)
		{
			values[i] = sc.nextInt();
		}
		
		int largest = values[0];
		for (int i = 0; i < values.length; i++)
		{
			if (values[i] > largest)
			{
				largest = values[i];
			}
		}
		int smallest = values[0];
		for (int i = 0; i < values.length; i++)
		{
			if (values[i] < smallest)
			{
				smallest = values[i];
			}
		}
		System.out.println("Largest = " + largest);
		System.out.println("Smallest = " + smallest);
		
		sc.close();
	}

}
