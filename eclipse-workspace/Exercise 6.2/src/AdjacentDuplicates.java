import java.util.Scanner;
public class AdjacentDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("How many numbers?");
		int values[] = new int [sc.nextInt()];
		
		System.out.println("Enter numbers");
		for (int i = 0; i < values.length; i++)
		{
			values[i] = sc.nextInt();
		}
		
		boolean duplicate = false;
		for (int i = 0; i < values.length-1; i++)
		{
			if (values[i] == values[i+1])
			{
				duplicate = true;
				if (duplicate = true)
				{
					System.out.print(values[i] + " ");
				}
			}
		}
		sc.close();
		
	}

}
