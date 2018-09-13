import java.util.Scanner;
public class LargestInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a string of integers");
		String values [] = {sc.nextLine()};
		String largest = values[0];
		for (int i = 0; i < values.length; i++)
		{
			if (values[i].compareTo(largest) > 0)
			{
				largest = values[i];
			}
		}
		System.out.println(largest);
		sc.close();
	}

}
