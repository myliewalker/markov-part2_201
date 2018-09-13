
public class Billfold extends Card {
	
	private Card card1;
	private Card card2;
	private int count = 0;
	
	public Billfold (Card c1, Card c2)
	{
		card1 = c1;
		card2 = c2;
	}
	
	public void addCard (Card c)
	{
		if (card1 == null)
		{
			card1 = c;
		}
		else
		{
			if (card2 == null)
			{
				card2 = c;
			}
		}
	}
	
	public String formatCards()
	{
		return "[" + card1 + "|" + card2 + "]";
	}
	
	public int getExpiredCardCount()
	{
		if (card1.isExpired())
		{
			count++;
		}
		if (card2.isExpired())
		{
			count++;
		}
		return count;
	}
}

