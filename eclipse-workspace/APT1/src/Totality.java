
public class Totality {
	public int sum(int[] a, String stype) {
		int total = 0;
        if (stype.equals("even"))
        {
        		for (int i = 0; i < a.length; i++)
        		{
        			if (i%2 == 0)
        			{
        				total+=a[i];
        			}
        		}
        		return total;
        }
        if (stype.equals("odd"))
        {
        		for (int i = 0; i < a.length; i++)
        		{
        			if (i%2 != 0)
        			{
        				total+=a[i];
        			}
        		}
        		return total;
        }
        if (stype.equals("all"))
        {
        		for (int i = 0; i < a.length; i++)
        		{
        			total+=a[i];
        		}
        		return total;
        }
        return 0;
    }
}
