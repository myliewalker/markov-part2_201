
public class Backwards {

	String newWord = "";
	String remaining;
	public String reverse (String word)
	{
		if (newWord.length() == 0)
		{
			remaining = word.substring(0);
		}
		else
		{
			remaining = word.substring(1);
		}
		String first = word.substring(remaining.length()-1);
		newWord = newWord + first;
		reverse(remaining);
		return newWord;
	}
}
