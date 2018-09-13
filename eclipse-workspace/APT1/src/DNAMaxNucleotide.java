
public class DNAMaxNucleotide {
	int maxNuc;
	String result = "";
    public String max(String[] strands, String nuc) {
    		for (int i = 0; i < strands.length; i++)
        {
    			if (instanceOfNuc(strands[i], nuc) > maxNuc)
            	{
    				maxNuc = instanceOfNuc(strands[i], nuc);
            		result = strands[i];
            	}
    			if (instanceOfNuc(strands[i], nuc) == maxNuc)
    			{
    				if(strands[i].length() > result.length())
    				{
    					result = strands[i];
            		}
    			}
    		}
    		return result;
      }
    public int instanceOfNuc(String line, String n)
    {
    		int count = -1;
    		for (int i = 0; i < line.length(); i++)
    		{
    			if (line.substring(i, i+1).equals(n))
    			{
    				count++;
    			}
    		}
    		return count;
    }
   }