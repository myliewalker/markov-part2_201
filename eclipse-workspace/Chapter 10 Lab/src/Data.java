
public class Data {

	public static double average(Measurable[] objects) {
	      double sum = 0;
	      for (Measurable obj : objects) {
	         sum = sum + obj.getMeasure();
	      }
	      if (objects.length > 0) { return sum / objects.length;}
	      else { return 0; }
	   }

	   /**
	      Computes the maximum of the measures of the given objects.
	      @param objects an array of Measurable objects
	      @return the maximum of the measures, null if array is empty
	   */
	   public static Measurable max(Measurable [] objects) {
	      if (objects.length == 0) { return null; }
	      Measurable max = objects[0];
	      for (Measurable obj : objects) {
	         if (obj.getMeasure() > max.getMeasure()) {
	            max = obj;
	         }
	      }

	      return max;
	   }
	   
	   double total = 0;
	   int count = 0;
	   public double averageHeight(Person[] objects)
	   {
		   for (int i = 0; i < objects.length; i++)
		   {
			   total +=objects[i].getHeight();
			   count++;
		   }
		   return total/count;
	   }
	   
	   double tallest = 0;
	   String person;
	   public String tallest(Person[] objects)
	   {
		   for (int i = 0; i < objects.length; i++)
		   {
			   if (objects[i].getHeight() > tallest)
			   {
				   tallest = objects[i].getHeight();
				   person = objects[i].getName();
			   }
		   }
		   return person;
		   
	   }

}
