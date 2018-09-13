import java.util.Scanner;
public class EvenOdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner (System.in);
		System.out.println("How many integers would you like to enter?");
		int values[] = new int [sc.nextInt()];
		
		System.out.println("Please enter the values");
		for (int i = 0; i < values.length; i++)
		{
			values[i] = sc.nextInt();
		}
		
		int even = 0;
		int odd = 0;
		for (int i = 0; i < values.length; i++)
		{
			if (values[i] % 2 == 0)
			{
				even++;
			}
			else
			{
				odd++;
			}
		}
		System.out.println("There are " + even + " even integers and " + odd + " odd integers");
		
		sc.close();
	}

}
