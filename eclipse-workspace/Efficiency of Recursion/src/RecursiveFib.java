import java.util.Scanner;
public class RecursiveFib {
	public static void main(String[] args)
	{  
		long startTime = System.nanoTime();
		Scanner sc = new Scanner(System.in);
	    System.out.print("Enter n: ");
	    int n = sc.nextInt();
	    	sc.close();
	      
	    System.out.println("fib(" + n + ") = " + fib(n));

	    for (int i = 1; i <= n; i++)
	    {
	       long f = fib(i);
	       System.out.println("fib(" + i + ") = " + f);
	    }
	    
	    System.out.println("Time elapsed:" + (System.nanoTime() - startTime));
	 }

	 public static long fib(int n)
	 {  
		 if (n <= 2) { return 1; }
	     else { return fib(n - 1) + fib(n - 2); }
	 }

}
