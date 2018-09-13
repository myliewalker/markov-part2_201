
public class Common {

	public int count (String a, String b)
	{
		int total = 0;
		for (int i = 0; i < a.length(); i++)
		{
			if (numInstances(a.substring(i, i+1), a) < numInstances(a.substring(i, i+1), b))
			{
				if (alreadyChecked(i, a.substring(i, i+1), a) == false)
				{
					total+=numInstances(a.substring(i, i+1), a);
				}
			}
			if (numInstances(a.substring(i, i+1), a) >= numInstances(a.substring(i, i+1), b))
			{
				if (alreadyChecked(i, a.substring(i, i+1), a) == false)
				{
					total+=numInstances(a.substring(i, i+1), b);
				}
			}
		}
		return total;
	}
	
	public int numInstances(String letter, String word)
	{
		int instances = 0;
		for (int i = 0; i < word.length(); i++)
		{
			if (letter.equals(word.substring(i, i+1)))
			{
				instances++;
			}
		}
		return instances;
	}
	
	public boolean alreadyChecked(int pos, String letter, String word)
	{
		for (int i = 0; i < pos; i++)
		{
			if (letter.equals(word.substring(i, i+1)))
			{
				return true;
			}
		}
		return false;
	}
	
}