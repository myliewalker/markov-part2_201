/** 
   A simple program that prints a loop control variable.
*/
//public class SimpleLoop
//{
//   public static void main(String[] args)
//   {
//      int i = 0;
//      int limit = 6;
//      while (i < limit)
//      {
//         System.out.println("i = " + i);
//         i++;
//      }
//   }
//}
//This prints i = 0 / i = 1 / i = 2 / i = 3 / i = 4 / i = 5
//If you don't increment i, the loop will run forever

//public class SimpleLoop
//{
//   public static void main(String[] args)
//   {
//      int i = 6;
//      int limit = 99;
//      while (i < limit)
//      {
//         System.out.println("i = " + i);
//         i = i + 2;
//      }
//   }
//}

//import java.util.Scanner;
//public class SimpleLoop
//{
//   public static void main(String[] args)
//   {
//	  System.out.println ("What is the last number?");
//	  Scanner sc = new Scanner (System.in);
//	  int limit = sc.nextInt();
//      int i = 1;
//      int total = 0;
//      while (i <= limit)
//      {
//         total = total + i;
//         i++;
//      }
//      System.out.println(total);
//      sc.close();
//   }
//}

import java.util.Scanner;
public class SimpleLoop
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner (System.in);
		System.out.println("Please enter an integer");
		int input = sc.nextInt();
		int nInput = 1;
		int a = 2;
		while (input != 0 && nInput != 0)
		{
			System.out.println(nInput%2);
			nInput = input/a;
			a = a*2;
		}
		sc.close();
}
}
