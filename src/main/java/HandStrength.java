import java.util.ArrayList;

//TODO - use method in tie conditions
public class HandStrength
{
    private static boolean isRoyal = false;
    private ArrayList<Card> hand;
    private int strength = 0;
    private int threeHelper = 0;
    private int twoPairHelper = 0;
    int tempCard;
    int tempCard2;
    int tempCard3;
    int tempCard4;
    int tempCard5;

    public HandStrength(ArrayList<Card> hand)
    {
        this.hand = hand;
        tempCard = hand.get(0).getValue();
        tempCard2 = hand.get(1).getValue();
        tempCard3 = hand.get(2).getValue();
        tempCard4 = hand.get(3).getValue();
        tempCard5 = hand.get(4).getValue();
    }

    public int checkStrength()
    {
        return strength;
    }

    public boolean isPair()
    {
        for (int i = 1; i < hand.size(); ++i)
        {
            for (int j = i; j > 0; --j)
            {
                int temp1 = hand.get(j).getValue();
                int temp2 = hand.get(j-1).getValue();
                if (temp1 == temp2)
                {
                    strength = 1;
                    twoPairHelper = temp1;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isTwoPair()
    {
        if (isPair())
        {
            ArrayList<Card> threeHand = new ArrayList<Card>();
            for (Card c: hand)
            {
                if (c.getValue() != twoPairHelper)
                {
                    threeHand.add(c);
                }
            }
            for (int i = 1; i < threeHand.size(); ++i)
            {
                for (int j = i; j > 0; --j)
                {
                    int temp1 = threeHand.get(j).getValue();
                    int temp2 = threeHand.get(j-1).getValue();
                    if (temp1 == temp2)
                    {
                        strength = 2;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isThreeKind()
    {
        if (tempCard == tempCard2 && tempCard == tempCard3)
        {
            strength = 3;
            threeHelper = 1;
            return true;
        }
        else if (tempCard2 == tempCard3 && tempCard2 == tempCard4)
        {
            strength = 3;
            threeHelper = 2;
            return true;
        }
        else if (tempCard3 == tempCard4 && tempCard3 == tempCard5)
        {
            strength = 3;
            threeHelper = 3;
            return true;
        }
        return false;
    }

    public boolean isStraight()
    {

        if (tempCard5 - tempCard4 == 1 && tempCard4 - tempCard3 == 1 && tempCard3 - tempCard2 == 1 && tempCard2 - tempCard == 1)
        {
            strength = 4;
            return true;
        }
        return false;
    }

    public boolean isFlush()
    {
        for (int i = 1; i < hand.size(); ++i)
        {
            for (int j = i; j > 0; --j)
            {
                int temp1= hand.get(j).getSuit();
                int temp2 = hand.get(j-1).getSuit();
                if (temp1 != temp2)
                {
                    return false;
                }
            }
        }
        strength = 5;
        return true;
    }

    /* if three pair & two pair == true */
    public boolean isFullHouse()
    {
        if (isThreeKind())
        {
            if (threeHelper == 1 && tempCard4 == tempCard5)
            {
                strength = 6;
                return true;
            }
            else if (threeHelper == 2 && tempCard == tempCard5)
            {
                strength = 6;
                return true;
            }
            else if (threeHelper == 3 && tempCard == tempCard2)
            {
                strength = 6;
                return true;
            }
        }
        return false;
    }

    public boolean isFourKind()
    {
        if (threeHelper == 1 && tempCard4 == tempCard)
        {
            strength = 7;
            return true;
        }
        return false;
    }

    public boolean isStraightFlush()
    {
        if (isFlush() && isStraight())
        {
            if (tempCard == 1 && tempCard2 == 10 && tempCard3 == 11 && tempCard4 == 12 && tempCard5 == 13)
            {
                isRoyal = true;
            }
            strength = 8;
            return true;
        }
        return false;
    }

    public boolean isRoyalFlush()
    {
        if (isRoyal)
        {
            strength = 9;
            return true;
        }
        return false;
    }
}