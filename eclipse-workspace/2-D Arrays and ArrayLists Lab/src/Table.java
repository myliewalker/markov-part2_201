
public class Table 
{
   private int[][] values;

   public Table(int rows, int columns)
   {
      values = new int[rows][columns];
   }
   
   public void set(int i, int j, int n)
   {
      values[i][j] = n;
   }
   
   public static void neighborAverage(n)
   {
	   int x = 0;
	   int y = 0;
	   int n = 0;
	   int k = 0;
	   if (j-1 >= 0)
	   {
		   x = j-1;
	   }
	   if (j+1 < values.length)
	   {
		   y = j+1;
	   }
	   if (i-1 >= 0)
	   {
		   n = i-1;
	   }
	   if (i+1 < values[0].length)
	   {
		   k = i+1;
	   }
	   
	   int counter = 1;
	   if (x > 0)
	   {
		   counter++;
	   }
	   if (y > 0)
	   {
		   counter++;
	   }
	   if (k > 0)
	   {
		   counter++;
	   }
	   if (n > 0)
	   {
		   counter++;
	   }
	   
	   System.out.print((x + y + k + n) / counter);
   }
}
