import java.util.ArrayList;
import java.util.List;

public class WalkerM_UnoPlayer implements UnoPlayer {
    /**
     * play - This method is called when it's your turn and you need to
     * choose what card to play.
     *
     * The hand parameter tells you what's in your hand. You can call
     * getColor(), getRank(), and getNumber() on each of the cards it
     * contains to see what it is. The color will be the color of the card,
     * or "Color.NONE" if the card is a wild card. The rank will be
     * "Rank.NUMBER" for all numbered cards, and another value (e.g.,
     * "Rank.SKIP," "Rank.REVERSE," etc.) for special cards. The value of
     * a card's "number" only has meaning if it is a number card. 
     * (Otherwise, it will be -1.)
     *
     * The upCard parameter works the same way, and tells you what the 
     * up card (in the middle of the table) is.
     *
     * The calledColor parameter only has meaning if the up card is a wild,
     * and tells you what color the player who played that wild card called.
     *
     * Finally, the state parameter is a GameState object on which you can 
     * invoke methods if you choose to access certain detailed information
     * about the game (like who is currently ahead, what colors each player
     * has recently called, etc.)
     *
     * You must return a value from this method indicating which card you
     * wish to play. If you return a number 0 or greater, that means you
     * want to play the card at that index. If you return -1, that means
     * that you cannot play any of your cards (none of them are legal plays)
     * in which case you will be forced to draw a card (this will happen
     * automatically for you.)
     */
    public int play(List<Card> hand, Card upCard, Color calledColor, GameState state)
    {
    		boolean canPlay = false;
    		boolean eliminate = false;
        boolean last = false;
        boolean multipleUnos = false;
        boolean mostB = false;
        boolean mostG = false;
        boolean mostR = false;
        boolean mostY = false;
        boolean secondB = false;
        boolean secondG = false;
        boolean secondR = false;
        boolean secondY = false;
        boolean thirdB = false;
        boolean thirdG = false;
        boolean thirdR = false;
        boolean thirdY = false;
        boolean fourthB = false;
        boolean fourthG = false;
        boolean fourthR = false;
        boolean fourthY = false;
        Card temp;
        
        //Determines whether a card can be played. COMPLETE.
        for (int i = 0; i < hand.size(); i++)
        {
        		if (playable(upCard, hand.get(i), calledColor) == true)
        		{
        			canPlay = true;
        		}
        }
        if (canPlay == false)
        {
        		return -1;
        }
       
        //Creates array lists of all the colors, special cards, and wild cards
        ArrayList<Card> b = new ArrayList<Card>();
        for (int i = 0; i < hand.size(); i++)
        {
        		if (hand.get(i).getColor().equals(Color.BLUE))
        		{
        			b.add(hand.get(i));
        		}
        }
        ArrayList<Card> blue = new ArrayList<Card>();
        	for (int i = 0; i < b.size(); i++)
        	{
       		blue.add(sort(b).get(i));
       	}
        
        ArrayList<Card> g = new ArrayList<Card>();
        for (int i = 0; i < hand.size(); i++)
        {
        		if (hand.get(i).getColor().equals(Color.GREEN))
        		{
        			g.add(hand.get(i));
        		}
        }
        ArrayList<Card> green = new ArrayList<Card>();
    		for (int i = 0; i < g.size(); i++)
    		{
    			green.add(sort(g).get(i));
    		}	
        
        ArrayList<Card> r = new ArrayList<Card>();
        for (int i = 0; i < hand.size(); i++)
        {
        		if (hand.get(i).getColor().equals(Color.RED))
        		{
        			r.add(hand.get(i));
        		}
        }
        ArrayList<Card> red = new ArrayList<Card>();
        for (int i = 0; i < r.size(); i++)
    		{
        		red.add(sort(r).get(i));
    		}
    	
        ArrayList<Card> y = new ArrayList<Card>();
        for (int i = 0; i < hand.size(); i++)
        {
        		if (hand.get(i).getColor().equals(Color.YELLOW))
        		{
        			y.add(hand.get(i));
        		}
        }
        ArrayList<Card> yellow = new ArrayList<Card>();
        for (int i = 0; i < y.size(); i++)
        {
        		yellow.add(sort(y).get(i));
        }
    	
        ArrayList<Card> special = new ArrayList<Card>();
        for (int i = 0; i < hand.size(); i++)
        {
        		if (hand.get(i).getRank().equals(Rank.WILD) || hand.get(i).getRank().equals(Rank.WILD_D4) || hand.get(i).getRank().equals(Rank.DRAW_TWO) || hand.get(i).getRank().equals(Rank.SKIP) || hand.get(i).getRank().equals(Rank.REVERSE))
			{
				special.add(hand.get(i));
			}
        }
        for (int j = 0; j < special.size(); j++)
        {
        		if (special.get(j).getRank().equals(Rank.DRAW_TWO))
        		{
        			temp = special.get(j);
        			special.remove(j);
        			special.add(temp);
        		}
        }
        for (int j = 0; j < special.size(); j++)
        {
        		if (special.get(j).getRank().equals(Rank.SKIP))
        		{
        			temp = special.get(j);
        			special.remove(j);
        			special.add(temp);
        		}
        }
        for (int j = 0; j < special.size(); j++)
        {
        		if (special.get(j).getRank().equals(Rank.WILD_D4))
        		{
        			temp = special.get(j);
        			special.remove(j);
        			special.add(temp);
        		}
        }
        for (int j = 0; j < special.size(); j++)
        {
        		if (special.get(j).getRank().equals(Rank.REVERSE))
        		{
        			temp = special.get(j);
        			special.remove(j);
        			special.add(temp);
        		}
        }
        for (int j = 0; j < special.size(); j++)
        {
        		if (special.get(j).getRank().equals(Rank.WILD))
        		{
        			temp = special.get(j);
        			special.remove(j);
        			special.add(temp);
        		}
        }
        
        ArrayList<Card> wild = new ArrayList<Card>();
        for (int i = 0; i < wild.size(); i++)
        {
        		if (hand.get(i).getRank().equals(Rank.WILD))
        		{
        			wild.add(hand.get(i));
        		}
        }
        for (int i = 0; i < wild.size(); i++)
        {
        		if (hand.get(i).getRank().equals(Rank.WILD_D4))
        		{
        			wild.add(hand.get(i));
        		}
        }
        
        //Determines the color with the greatest number of cards      
        int max = getMax(blue, green, red, yellow);
        if (max == blue.size())
        {
        		mostB = true;
        }
        else if (max == green.size())
        {
        		mostG = true;
        }
        else if (max == red.size())
        {
        		mostR = true;
        }
        else if (max == yellow.size())
        {
        		mostY = true;
        }
        
        int second = getHighest(blue, green, red, yellow, max);
        if (second == blue.size())
        {
        		secondB = true;
        }
        else if (second == green.size())
        {
        		secondG = true;
        }
        else if (second == red.size())
        {
        		secondR = true;
        }
        else if (second == yellow.size())
        {
        		secondY = true;
        }
        
        int third = getHighest(blue, green, red, yellow, second);
        if (third == blue.size())
        {
        		thirdB = true;
        }
        else if (third == green.size())
        {
        		thirdG = true;
        }
        else if (third == red.size())
        {
        		thirdR = true;
        }
        else if (third == yellow.size())
        {
        		thirdY = true;
        }
        
        int fourth = getHighest(blue, green, red, yellow, third);
        if (fourth == blue.size())
        {
        		fourthB = true;
        }
        else if (fourth == green.size())
        {
        		fourthG = true;
        }
        else if (fourth == red.size())
        {
        		fourthR = true;
        }
        else if (fourth == yellow.size())
        {
        		fourthY = true;
        }
        
        //Checks the number of cards in opponents hands
        for (int i = 0; i < state.getNumCardsInHandsOfUpcomingPlayers().length; i++)
        {
        		if (state.getNumCardsInHandsOfUpcomingPlayers()[i] <= 3)
        		{
        			eliminate = true;
        		}
        }
        
        int n = 0;
        for (int i = 0; i < state.getNumCardsInHandsOfUpcomingPlayers().length - n; i++)
        {
        		for (n = 0; n < state.getNumCardsInHandsOfUpcomingPlayers().length-1; n++)
        		{
        			if (state.getNumCardsInHandsOfUpcomingPlayers()[i] == 0 && state.getNumCardsInHandsOfUpcomingPlayers()[i+n] == 0)
        			{
        				multipleUnos = true;
        			}
        		}
        }
        for (int i = 1; i < state.getNumCardsInHandsOfUpcomingPlayers().length; i++)
        {
        		if (state.getNumCardsInHandsOfUpcomingPlayers()[i] == 1)
        		{
        			last = true;
        		}
        }
        
        //If a wild or wild draw four is played
        if (upCard.getRank().equals(Rank.WILD) || upCard.getRank().equals(Rank.WILD_D4))
        {
        		int e = elimination(eliminate, multipleUnos, last, hand, state, special, upCard, calledColor);
        		if (e >= 0)
        		{
        			return e;
       		}
        		if (calledColor == Color.BLUE && blue.size() > 0)
        		{
        			return indexOf(hand, blue.get(0));
        		}
        		if (calledColor == Color.GREEN && green.size() > 0)
        		{
        			return indexOf(hand, green.get(0));
        		}
        		if (calledColor == Color.RED && red.size() > 0)
        		{
        			return indexOf(hand, red.get(0));
        		}
        		if (calledColor == Color.YELLOW && yellow.size() > 0)
        		{
        			return indexOf(hand, yellow.get(0));
        		}
        		if (wild.size() > 0)
        		{
        			return indexOf(hand, wild.get(0));
        		}
        		return -1;
        }
        
        //If the person to the right has two cards
        if (state.getNumCardsInHandsOfUpcomingPlayers()[state.getNumCardsInHandsOfUpcomingPlayers().length-1] == 2 && state.getNumCardsInHandsOfUpcomingPlayers()[0] != 1)
        {	
        		for (int i = 0; i < hand.size(); i++)
        		{
        			if (hand.get(i).getRank().equals(Rank.REVERSE) && (hand.get(i).getColor().equals(upCard.getColor()) || hand.get(i).getRank().equals(upCard.getRank())))
      			{
        				return i;
        			}
        		}
        	}
        
        //If the person to the left has one card
        if (state.getNumCardsInHandsOfUpcomingPlayers()[0] == 1)
        {
        		for (int k = 1; k < state.getNumCardsInHandsOfUpcomingPlayers().length; k++)
        		{
        			if (state.getNumCardsInHandsOfUpcomingPlayers()[k] == 1)
        			{
        				for (int j = 0; j < special.size(); j++)
            			{
            				if (special.get(j).getRank().equals(Rank.WILD_D4))
            				{
            					return j;
            				}
            			}
        			}
        		}
        		for (int i = 0; i < special.size(); i++)
        		{
        			if (special.get(i).getRank().equals(Rank.DRAW_TWO))
        			{
        				if (special.get(i).getColor().equals(upCard.getColor()) || upCard.getRank().equals(Rank.DRAW_TWO))
        				{
        					return i;
        				}
        			}
        		}
        		if (state.getNumCardsInHandsOfUpcomingPlayers()[state.getNumCardsInHandsOfUpcomingPlayers().length-1] == 1)
        		{
        			for (int i = 0; i < special.size(); i++)
            		{
            			if (special.get(i).getRank().equals(Rank.REVERSE))
            			{
            				if (special.get(i).getColor().equals(upCard.getColor()) || upCard.getRank().equals(Rank.REVERSE))
            				{
            					return i;
            				}
            			}
            		}
        		}
        		for (int i = 0; i < special.size(); i++)
        		{
        			if (special.get(i).getColor().equals(upCard.getColor()) || special.get(i).getRank().equals(upCard.getRank()) || special.get(i).getRank().equals(Rank.WILD) || special.get(i).getRank().equals(Rank.WILD_D4))
        			{
        				return i;
        			}
        		}
        }
        
        //WHEN YOU CAN RETURN THE MAX COLOR	
        	if (mostB == true)
        	{
        		int e = elimination(eliminate, multipleUnos, last, hand, state, special, upCard, calledColor);
        		if (e >= 0)
        		{
        			return e;
       		}
        		if (upCard.getColor().equals(Color.BLUE) && blue.size() > 0)
        		{
        			return indexOf(hand, blue.get(0));
        		}
        		if (upCard.getRank().equals(Rank.WILD) && calledColor.equals(Color.BLUE) && blue.size() > 0)
        		{
        			return indexOf(hand, blue.get(0));
        		}
        		for (int i = 0; i < hand.size(); i++)
        		{
        			if ((upCard.getRank() == Rank.NUMBER && upCard.getNumber() == hand.get(i).getNumber()) || (upCard.getRank() != Rank.NUMBER && upCard.getRank().equals(hand.get(i).getRank())))
        			{
        				return i;
        			}
        		}
        	}
        	if (mostG == true)
        	{
        		int e = elimination(eliminate, multipleUnos, last, hand, state, special, upCard, calledColor);
        		if (e >= 0)
        		{
        			return e;
       		}
        		if (upCard.getColor().equals(Color.GREEN) && green.size() > 0)
        		{
        			return indexOf(hand, green.get(0));
        		}
        		if (upCard.getRank().equals(Rank.WILD) && calledColor.equals(Color.GREEN) && green.size() > 0)
        		{
        			return indexOf(hand, green.get(0));
        		}
        		for (int i = 0; i < hand.size(); i++)
        		{
        			if ((upCard.getRank() == Rank.NUMBER && upCard.getNumber() == hand.get(i).getNumber()) || (upCard.getRank() != Rank.NUMBER && upCard.getRank().equals(hand.get(i).getRank())))
        			{
        				return i;
        			}
        		}
        	}
        if (mostR == true)
        	{
        		int e = elimination(eliminate, multipleUnos, last, hand, state, special, upCard, calledColor);
        		if (e >= 0)
        		{
        			return e;
       		}
        		if (upCard.getColor().equals(Color.RED) && red.size() > 0)
        		{
        			return indexOf(hand, red.get(0));
        		}
        		if (upCard.getRank().equals(Rank.WILD) && calledColor.equals(Color.RED) && red.size() > 0)
        		{
        			return indexOf(hand, red.get(0));
        		}
        		for (int i = 0; i < hand.size(); i++)
        		{
        			if ((upCard.getRank() == Rank.NUMBER && upCard.getNumber() == hand.get(i).getNumber()) || (upCard.getRank() != Rank.NUMBER && upCard.getRank().equals(hand.get(i).getRank())))
        			{
        				return i;
        			}
        		}
        	}
        	if (mostY == true)
        	{
        		int e = elimination(eliminate, multipleUnos, last, hand, state, special, upCard, calledColor);
        		if (e >= 0)
        		{
        			return e;
       		}
        		if (upCard.getColor().equals(Color.YELLOW) && yellow.size() > 0)
        		{
        			return indexOf(hand, yellow.get(0));
        		}
        		if (upCard.getRank().equals(Rank.WILD) && calledColor.equals(Color.YELLOW) && yellow.size() > 0)
        		{
        			return indexOf(hand, yellow.get(0));
        		}
        		for (int i = 0; i < hand.size(); i++)
        		{
        			if ((upCard.getRank() == Rank.NUMBER && upCard.getNumber() == hand.get(i).getNumber()) || (upCard.getRank() != Rank.NUMBER && upCard.getRank().equals(hand.get(i).getRank())))
        			{
        				return i;
        			}
        		}
        	}
        		
        	//IF YOU CAN RETURN THE SECOND MOST
        if (secondB = true)
        {
        		int e = elimination(eliminate, multipleUnos, last, hand, state, special, upCard, calledColor);
        		if (e >= 0)
        		{
        			return e;
       		}
        		if (upCard.getColor().equals(Color.BLUE) && blue.size() > 0)
        		{
        			return indexOf(hand, blue.get(0));
        		}
        		if (upCard.getRank().equals(Rank.WILD) && calledColor.equals(Color.BLUE) && blue.size() > 0)
        		{
        			return indexOf(hand, blue.get(0));
        		}
        		for (int i = 0; i < hand.size(); i++)
        		{
        			if ((upCard.getRank() == Rank.NUMBER && upCard.getNumber() == hand.get(i).getNumber()) || (upCard.getRank() != Rank.NUMBER && upCard.getRank().equals(hand.get(i).getRank())))
        			{
        				return i;
        			}
        		}
        }
        	if (secondG = true)
        {
        		int e = elimination(eliminate, multipleUnos, last, hand, state, special, upCard, calledColor);
        		if (e >= 0)
        		{
        			return e;
       		}
        		if (upCard.getColor().equals(Color.GREEN) && green.size() > 0)
        		{
        			return indexOf(hand, green.get(0));
        		}
        		if (upCard.getRank().equals(Rank.WILD) && calledColor.equals(Color.GREEN) && green.size() > 0)
        		{
        			return indexOf(hand, green.get(0));
        		}
        		for (int i = 0; i < hand.size(); i++)
        		{
        			if ((upCard.getRank() == Rank.NUMBER && upCard.getNumber() == hand.get(i).getNumber()) || (upCard.getRank() != Rank.NUMBER && upCard.getRank().equals(hand.get(i).getRank())))
        			{
        				return i;
        			}
        		}
        }
        	if (secondR = true)
        {
        		int e = elimination(eliminate, multipleUnos, last, hand, state, special, upCard, calledColor);
        		if (e >= 0)
        		{
        			return e;
       		}
        		if (upCard.getColor().equals(Color.RED) && red.size() > 0)
        		{
        			return indexOf(hand, red.get(0));
        		}
        		if (upCard.getRank().equals(Rank.WILD) && calledColor.equals(Color.RED) && red.size() > 0)
        		{
        			return indexOf(hand, red.get(0));
        		}
        		for (int i = 0; i < hand.size(); i++)
        		{
        			if ((upCard.getRank() == Rank.NUMBER && upCard.getNumber() == hand.get(i).getNumber()) || (upCard.getRank() != Rank.NUMBER && upCard.getRank().equals(hand.get(i).getRank())))
        			{
        				return i;
        			}
        		}
        }
        	if (secondY = true)
        {
        		int e = elimination(eliminate, multipleUnos, last, hand, state, special, upCard, calledColor);
        		if (e >= 0)
        		{
        			return e;
       		}
        		if (upCard.getColor().equals(Color.YELLOW) && yellow.size() > 0)
        		{
        			return indexOf(hand, yellow.get(0));
        		}
        		if (upCard.getRank().equals(Rank.WILD) && calledColor.equals(Color.YELLOW) && yellow.size() > 0)
        		{
        			return indexOf(hand, yellow.get(0));
        		}
        		for (int i = 0; i < hand.size(); i++)
        		{
        			if ((upCard.getRank() == Rank.NUMBER && upCard.getNumber() == hand.get(i).getNumber()) || (upCard.getRank() != Rank.NUMBER && upCard.getRank().equals(hand.get(i).getRank())))
        			{
        				return i;
        			}
        		}
        }
        		
        	//IF YOU CAN PLAY THE THIRD MOST
        	if (thirdB = true)
        {
        		int e = elimination(eliminate, multipleUnos, last, hand, state, special, upCard, calledColor);
        		if (e >= 0)
        		{
        			return e;
       		}
        		if (upCard.getColor().equals(Color.BLUE) && blue.size() > 0)
        		{
        			return indexOf(hand, blue.get(0));
        		}
        		if (upCard.getRank().equals(Rank.WILD) && calledColor.equals(Color.BLUE) && blue.size() > 0)
        		{
        			return indexOf(hand, blue.get(0));
        		}
        		for (int i = 0; i < hand.size(); i++)
        		{
        			if ((upCard.getRank() == Rank.NUMBER && upCard.getNumber() == hand.get(i).getNumber()) || (upCard.getRank() != Rank.NUMBER && upCard.getRank().equals(hand.get(i).getRank())))
        			{
        				return i;
        			}
        		}
        }
        	if (thirdG = true)
        {
        		int e = elimination(eliminate, multipleUnos, last, hand, state, special, upCard, calledColor);
        		if (e >= 0)
        		{
        			return e;
       		}
        		if (upCard.getColor().equals(Color.GREEN) && green.size() > 0)
        		{
        			return indexOf(hand, green.get(0));
        		}
        		if (upCard.getRank().equals(Rank.WILD) && calledColor.equals(Color.GREEN) && green.size() > 0)
        		{
        			return indexOf(hand, green.get(0));
        		}
        		for (int i = 0; i < hand.size(); i++)
        		{
        			if ((upCard.getRank() == Rank.NUMBER && upCard.getNumber() == hand.get(i).getNumber()) || (upCard.getRank() != Rank.NUMBER && upCard.getRank().equals(hand.get(i).getRank())))
        			{
        				return i;
        			}
        		}
        }
        	if (thirdR = true)
        {
        		int e = elimination(eliminate, multipleUnos, last, hand, state, special, upCard, calledColor);
        		if (e >= 0)
        		{
        			return e;
       		}
        		if (upCard.getColor().equals(Color.RED) && red.size() > 0)
        		{
        			return indexOf(hand, red.get(0));
        		}
        		if (upCard.getRank().equals(Rank.WILD) && calledColor.equals(Color.RED) && red.size() > 0)
        		{
        			return indexOf(hand, red.get(0));
        		}
        		for (int i = 0; i < hand.size(); i++)
        		{
        			if ((upCard.getRank() == Rank.NUMBER && upCard.getNumber() == hand.get(i).getNumber()) || (upCard.getRank() != Rank.NUMBER && upCard.getRank().equals(hand.get(i).getRank())))
        			{
        				return i;
        			}
        		}
        }
        	if (thirdY = true)
        {
        		int e = elimination(eliminate, multipleUnos, last, hand, state, special, upCard, calledColor);
        		if (e >= 0)
        		{
        			return e;
       		}
        		if (upCard.getColor().equals(Color.YELLOW) && yellow.size() > 0)
        		{
        			return indexOf(hand, yellow.get(0));
        		}
        		if (upCard.getRank().equals(Rank.WILD) && calledColor.equals(Color.YELLOW) && yellow.size() > 0)
        		{
        			return indexOf(hand, yellow.get(0));
        		}
        		for (int i = 0; i < hand.size(); i++)
        		{
        			if ((upCard.getRank() == Rank.NUMBER && upCard.getNumber() == hand.get(i).getNumber()) || (upCard.getRank() != Rank.NUMBER && upCard.getRank().equals(hand.get(i).getRank())))
        			{
        				return i;
        			}
        		}
        }
        	
        	//IF YOU CAN PLAY THE LAST MOST CARD
        	if (fourthB = true)
        {
        		int e = elimination(eliminate, multipleUnos, last, hand, state, special, upCard, calledColor);
        		if (e >= 0)
        		{
        			return e;
       		}
        		if (upCard.getColor().equals(Color.BLUE) && blue.size() > 0)
        		{
        			return indexOf(hand, blue.get(0));
        		}
        		if (upCard.getRank().equals(Rank.WILD) && calledColor.equals(Color.BLUE) && blue.size() > 0)
        		{
        			return indexOf(hand, blue.get(0));
        		}
        		for (int i = 0; i < hand.size(); i++)
        		{
        			if ((upCard.getRank() == Rank.NUMBER && upCard.getNumber() == hand.get(i).getNumber()) || (upCard.getRank() != Rank.NUMBER && upCard.getRank().equals(hand.get(i).getRank())))
        			{
        				return i;
        			}
        		}
        }
        	if (fourthG = true)
        {
        		int e = elimination(eliminate, multipleUnos, last, hand, state, special, upCard, calledColor);
        		if (e >= 0)
        		{
        			return e;
       		}
        		if (upCard.getColor().equals(Color.GREEN) && green.size() > 0)
        		{
        			return indexOf(hand, green.get(0));
        		}
        		if (upCard.getRank().equals(Rank.WILD) && calledColor.equals(Color.GREEN) && green.size() > 0)
        		{
        			return indexOf(hand, green.get(0));
        		}
        		for (int i = 0; i < hand.size(); i++)
        		{
        			if ((upCard.getRank() == Rank.NUMBER && upCard.getNumber() == hand.get(i).getNumber()) || (upCard.getRank() != Rank.NUMBER && upCard.getRank().equals(hand.get(i).getRank())))
        			{
        				return i;
        			}
        		}
        }
        	if (fourthR = true)
        {
        		int e = elimination(eliminate, multipleUnos, last, hand, state, special, upCard, calledColor);
        		if (e >= 0)
        		{
        			return e;
       		}
        		if (upCard.getColor().equals(Color.RED) && red.size() > 0)
        		{
        			return indexOf(hand, red.get(0));
        		}
        		if (upCard.getRank().equals(Rank.WILD) && calledColor.equals(Color.RED) && red.size() > 0)
        		{
        			return indexOf(hand, red.get(0));
        		}
        		for (int i = 0; i < hand.size(); i++)
        		{
        			if ((upCard.getRank() == Rank.NUMBER && upCard.getNumber() == hand.get(i).getNumber()) || (upCard.getRank() != Rank.NUMBER && upCard.getRank().equals(hand.get(i).getRank())))
        			{
        				return i;
        			}
        		}
        }
        	if (fourthY = true)
        {
        		int e = elimination(eliminate, multipleUnos, last, hand, state, special, upCard, calledColor);
        		if (e >= 0)
        		{
        			return e;
       		}
        		if (upCard.getColor().equals(Color.YELLOW) && yellow.size() > 0)
        		{
        			return indexOf(hand, yellow.get(0));
        		}
        		if (upCard.getRank().equals(Rank.WILD) && calledColor.equals(Color.YELLOW) && yellow.size() > 0)
        		{
        			return indexOf(hand, yellow.get(0));
        		}
        		for (int i = 0; i < hand.size(); i++)
        		{
        			if ((upCard.getRank() == Rank.NUMBER && upCard.getNumber() == hand.get(i).getNumber()) || (upCard.getRank() != Rank.NUMBER && upCard.getRank().equals(hand.get(i).getRank())))
        			{
        				return i;
        			}
        		}        
        }
        return -1;
    }

    public ArrayList<Card> sort(ArrayList<Card> c)
    {
    		Card temp;
	    for (int j = 0; j < c.size()-1; j++)
	    {
	        	if (c.get(j).getRank().equals(Rank.WILD) || c.get(j).getRank().equals(Rank.WILD_D4) || c.get(j).getRank().equals(Rank.DRAW_TWO) || c.get(j).getRank().equals(Rank.SKIP) || c.get(j).getRank().equals(Rank.REVERSE))
	        	{
	   			temp = c.get(j);
     			c.remove(j);
     			c.add(temp);
	        	}
	        	if (c.get(j+1).getNumber() > c.get(j).getNumber())
	        	{
	        		temp = c.get(j+1);
	       		c.set(j+1, c.get(j));
	       		c.set(j, temp);
	        	}
	    }
	    return c;
    }

    public int elimination (boolean eliminate, boolean multipleUnos, boolean last, List<Card> hand, GameState state, ArrayList<Card> special, Card upCard, Color calledColor)
    {
    		if (eliminate == true)
    		{
			if (multipleUnos == true)
			{
				for (int i = 0; i < hand.size(); i++)
				{
					if (hand.get(i).getRank().equals(Rank.WILD_D4))
					{
						return i;
					}
				}
			}
    			if (last == true)
			{
				if (state.getNumCardsInHandsOfUpcomingPlayers()[1] == 1)
				{
					for (int i = 0; i < special.size(); i++)
					{
						if (special.get(i).getRank() != Rank.SKIP && special.get(i).getRank() != Rank.DRAW_TWO && special.get(i).getRank() != Rank.WILD_D4)
						{
							if (state.getNumCardsInHandsOfUpcomingPlayers().length == 3 && special.get(i).getRank() != Rank.REVERSE)
							{
								return indexOf(hand, special.get(i));
							}
							return indexOf(hand, special.get(i));
						}
					}
				}
			}
    			for (int i = 0; i < special.size(); i++)
    			{
    				if (playable(upCard, special.get(i), calledColor) == true)
    				{
    					return indexOf(hand, special.get(i));
    				}
    			}
    		}
    		return -10;
    }

    public int getMax(ArrayList<Card> b, ArrayList<Card> g, ArrayList<Card> r, ArrayList<Card> y)
    {
        int max = b.size();
        int[] colors = {b.size(), g.size(), r.size(), y.size()};
        for (int num: colors)
        {
        		if (num > max)
        		{
        			max = num;
        		}
        }
        return max;
    }
    
    public int getHighest(ArrayList<Card> b, ArrayList<Card> g, ArrayList<Card> r, ArrayList<Card> y, int max)
    {
    		int highest = 0;
    		int[] colors = {b.size(), g.size(), r.size(), y.size()};
    		for (int num: colors)
    		{
    			if (num > highest && num < max)
    			{
    				highest = num;
    			}
    		}
    		return highest;
    }
    
    public int indexOf(List<Card> hand, Card card)
    {
		for (int i = 0; i < hand.size(); i++)
		{
			if (hand.get(i).equals(card))
			{
				return i;
			}
		}
		return 0;
	}
    
    public boolean playable(Card upCard, Card card, Color calledColor)
    {
    		boolean play = false;
    		if (card.getRank() == (Rank.WILD))
    		{
    			play = true;
    		}
    		if (card.getRank() == Rank.WILD_D4)
    		{
    			play = true;
   		}
    		if (upCard.getColor() == card.getColor())
    		{
    			play = true;
    		}
    		if (card.getColor() == calledColor)
    		{
    			play = true;
    		}
    		if (card.getRank() == Rank.NUMBER && upCard.getRank() == Rank.NUMBER && card.getNumber() == upCard.getNumber())
    		{
    			play = true;
    		}
    		if (card.getRank() != Rank.NUMBER && upCard.getRank() == card.getRank())
    		{
    			play = true;
    		}
    		return play;
    }
	
    /**
     * callColor - This method will be called when you have just played a
     * wild card, and is your way of specifying which color you want to 
     * change it to.
     *
     * You must return a valid Color value from this method. You must not
     * return the value Color.NONE under any circumstances.
     */
    public Color callColor(List<Card> hand)
    {    	
    		int b = 0;
    		int g = 0;
    		int r = 0;
    		int y = 0;
    		int[] colors = {b, g, r, y};
    		int max = colors[0];
        for (int i = 0; i < hand.size(); i++)
        {
        		if (hand.get(i).getColor().equals(Color.BLUE))
        		{
        			b++;
        		}
        		if (hand.get(i).getColor().equals(Color.GREEN))
        		{
        			g++;
        		}
        		if (hand.get(i).getColor().equals(Color.RED))
        		{
        			r++;
        		}
        		if (hand.get(i).getColor().equals(Color.YELLOW))
        		{
        			y++;
        		}
        }
        for (int i = 0; i < colors.length; i++)
        {
        		if (colors[i] > max)
        		{
        			max = colors[i];
        		}
        }
        if (max == b)
        {
        		return Color.BLUE;
        }
        if (max == g)
        {
        		return Color.GREEN;
        }
        if (max == r)
        {
        		return Color.RED;
        }
        return Color.YELLOW;
    }
}