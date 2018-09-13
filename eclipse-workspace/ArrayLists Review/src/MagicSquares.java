import java.util.Scanner;
import java.util.ArrayList;
public class MagicSquares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter 16 integers");
		
		ArrayList <Integer> list = new ArrayList <Integer> ();
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 4; j++)
			{
			list.add(sc.nextInt());
			}
		}
		
	}

}
