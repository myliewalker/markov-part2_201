import java.util.Arrays;

public class SandwichBar
   {
      public int whichOrder(String[] available, String[] orders){
        for (int i = 0; i < orders.length; i++)
        {
        		if(canMake(orders[i], available))
        		{
        			return i;
        		}
        }
    	  	return -1;
      }
      
//      public boolean canMake(String sandwich, String[] available)
//      {
//    	  	String[] ingredients = sandwich.split(" ");
//    	  	for (int i = 0; i < ingredients.length; i++)
//    	  	{
//    	  		for (int j = 0; j < available.length; j++)
//    	  		{
//    	  			if (ingredients[i].compareTo(available[j]) != 0)
//    	  			{
//    	  				return false;
//    	  			}
//    	  		}
//    	  	}
//    	  	return true;
//      }
      public boolean canMake(String sandwich, String[] available)
      {
    	  	for (String s : sandwich.split(" "))
    	  	{
//    	  		if (! Arrays.asList(available).contains(s))
    	  		if (! isIn(s, available))
    	  		{
    	  			return false;
    	  		}
    	  	}
    	  	return true;
      }
      
      private boolean isIn(String s, String[] list)
      {
    	  	for(String t: list)
    	  	{
    	  		if (t.equals(s))
    	  		{
    	  			return true;
    	  		}
    	  	}
    	  	return false;
      }
   }