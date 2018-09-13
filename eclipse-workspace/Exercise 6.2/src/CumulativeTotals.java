import java.util.Scanner;
public class CumulativeTotals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner (System.in);
		System.out.println("How many values will you enter");
		int values[] = new int [sc.nextInt()];
		
		System.out.println("Please enter your values");
		for (int i = 0; i < values.length; i++)
		{
			values[i] = sc.nextInt();
		}
		
		int total = 0;
		for (int i = 0; i < values.length; i++)
		{
			total = total + values[i];
		}
		
		System.out.println("The total is " + total);
		sc.close();
	}

}
