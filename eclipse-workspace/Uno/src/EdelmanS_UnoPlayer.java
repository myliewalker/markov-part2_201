import java.util.ArrayList;
import java.util.List;

public class EdelmanS_UnoPlayer implements UnoPlayer {

    public int play(List<Card> hand, Card upCard, Color calledColor, GameState state)
    {

        List<Integer> playableNum = new ArrayList<Integer>();
        List<Integer> playableW = new ArrayList<Integer>();
        List<Integer> playableW4 = new ArrayList<Integer>();
        List<Integer> playableRev = new ArrayList<Integer>();
        List<Integer> playableDr = new ArrayList<Integer>();
        List<Integer> playableSk = new ArrayList<Integer>();

        for (int i=0; i<hand.size(); i++)
        {
                        Card c = hand.get(i);
                        if(c.getRank() == Rank.WILD)
                                playableW.add(i);

                        else if(c.getRank() == Rank.WILD_D4)
                                playableW4.add(i);

                        else if(c.getColor() != Color.NONE && (c.getColor() == upCard.getColor() || c.getColor() == calledColor))
                        {
                                if(c.getRank() == Rank.NUMBER)
                                        playableNum.add(i);
                                else if(c.getRank() == Rank.REVERSE)
                                        playableRev.add(i);
                                else if(c.getRank() == Rank.SKIP)
                                        playableSk.add(i);
                                else if(c.getRank() == Rank.DRAW_TWO)
                                        playableDr.add(i);
                        }

            else if(c.getRank() == upCard.getRank())
            {
                        if(c.getNumber() == upCard.getNumber())
                                        playableNum.add(i);
                                else if(c.getRank() == Rank.REVERSE)
                                        playableRev.add(i);
                                else if(c.getRank() == Rank.SKIP)
                                        playableSk.add(i);
                                else if(c.getRank() == Rank.DRAW_TWO)
                                        playableDr.add(i);
            }
        }

        sortNumberCards(playableNum, hand);
        Color[] myColors = colorsFromMaxToMin(hand);

        if(state.getNumCardsInHandsOfUpcomingPlayers()[0] < 2)
        {
                        if(playableW4.size()>0)
                                return playableW4.get(0);
        }

        if(state.getNumCardsInHandsOfUpcomingPlayers()[0] < 3)
        {
                        for(Color x : myColors)
                        {
                                if(playableDr.size()>0)
                                {
                                        for(int i : playableDr)
                                        {
                                                Color c = hand.get(i).getColor();
                                                if(c == x)
                                                        return i;
                                        }
                                }
                        }
                        if(playableW4.size()>0)
                                return playableW4.get(0);
        }

        if(state.getNumCardsInHandsOfUpcomingPlayers()[0] < 4)
        {
                        for(Color x : myColors)
                        {
                                if(playableDr.size()>0)
                                {
                                        for(int i : playableDr)
                                        {
                                                Color c = hand.get(i).getColor();
                                                if(c == x)
                                                        return i;
                                        }
                                }
                                if(state.getNumCardsInHandsOfUpcomingPlayers()[1] > state.getNumCardsInHandsOfUpcomingPlayers()[0]
                                                && playableSk.size()>0)
                                {
                                        for(int i : playableSk)
                                        {
                                                Color c = hand.get(i).getColor();
                                                if(c == x)
                                                        return i;
                                        }
                                }
                        } 
                        for(Color x : myColors)
                        {
                                if(state.getNumCardsInHandsOfUpcomingPlayers()[2] > state.getNumCardsInHandsOfUpcomingPlayers()[0] 
                                                && playableRev.size()>0)
                                {
                                        for(int i : playableRev)
                                        {
                                                Color c = hand.get(i).getColor();
                                                if(c == x)
                                                        return i;
                                        }
                                }
                        }
        }

        for(Color x : myColors)
        {
                        if(playableNum.size()>0)
                        {
                                for(int i : playableNum)
                                {
                                        Color c = hand.get(i).getColor();
                                        if(c == x)
                                                return i;
                                }
                        }
                        if(state.getNumCardsInHandsOfUpcomingPlayers()[2] >1 && playableRev.size()>0)
                        {
                                for(int i : playableRev)
                                {
                                        Color c = hand.get(i).getColor();
                                if(c == x)
                                        return i;
                                }
                        }
                        if(state.getNumCardsInHandsOfUpcomingPlayers()[1] >1 && playableSk.size()>0)
                        {
                                for(int i : playableSk)
                                {
                                        Color c = hand.get(i).getColor();
                                        if(c == x)
                                                return i;
                                }
                        }
                        if(playableDr.size()>0)
                        {
                                for(int i : playableDr)
                                {
                                        Color c = hand.get(i).getColor();
                                        if(c == x)
                                                return i;
                                }
                        }
        }
        if(playableW4.size()>0)
        {
                        return playableW4.get(0);
        }
        if(playableW.size()>0)
        {
                        return playableW.get(0);
        }
        if(playableSk.size()>0)
        {
                        return playableSk.get(0);
        }
        if(playableRev.size()>0)
        {
                        return playableRev.get(0);
        }
        return -1;

    }


    public Color callColor(List<Card> hand)
    {
                Color[] myColors = colorsFromMaxToMin(hand);
                return myColors[0];
    }

    public Color[] colorsFromMaxToMin(List<Card> cards)
    {
                int r = 0;
                int y = 0;
                int g = 0;
                int b = 0;
                for(Card card : cards)
                {
                        if(card.getColor() == Color.RED) r++;
                        else if(card.getColor() == Color.YELLOW) y++;
                        else if(card.getColor() == Color.GREEN) g++;
                        else if(card.getColor() == Color.BLUE) b++;
                }
                Color[] sorted = new Color[4];
                for(int i=0; i<sorted.length; i++) {
                        if(r>=y && r>=g && r>=b) { sorted[i]=Color.RED; r=-1; }
                        else if(y>=r && y>=g && y>=b) { sorted[i]=Color.YELLOW; y=-1; }
                        else if(g>=r && g>=y && g>=b) { sorted[i]=Color.GREEN; g=-1; }
                        else { sorted[i]=Color.BLUE; b=-1; }
                }
                return sorted;
    }



    public static void sortNumberCards(List<Integer> a, List<Card> hand)
    {
       for (int i = 1; i < a.size(); i++)
       {
          int next = a.get(i);
          int j = i;
          while (j > 0 && hand.get(a.get(j-1)).getNumber() < hand.get(next).getNumber())
          {
             a.set(i, a.get(j-1));
             j--;
          }
          a.set(j, next);
       }
    }


}