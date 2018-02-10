import java.util.ArrayList;

//TODO - use method in tie conditions
public class HandStrength
{
    private static boolean isRoyal = false;
    private ArrayList<Card> hand;
    private int strength = 0;
    private int threeHelper = 0;
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

    //TODO
//    public boolean isHighCard(ArrayList<Card> hand)
//    {
//        strength = 1;
//        return false;
//    }

    public boolean isPair()
    {
        for (int i = 1; i < hand.size(); ++i)
        {
            for (int j = i; j > 0; --j)
            {
                Card tempCard;
                Card tempCard2;
                tempCard = hand.get(j);
                tempCard2 = hand.get(j-1);
                if (tempCard.getValue() == tempCard2.getValue())
                {
                    strength = 2;
                    return true;
                }
            }
        }
        return false;
    }

    //TODO
    /* if is pair is in list, make a new hand from the rest of the cards and check if another pair exists */
    public boolean isTwoPair()
    {
        //strength = 3;
        return false;
    }

    public boolean isThreeKind()
    {
        if (tempCard == tempCard2 && tempCard == tempCard3)
        {
            strength = 4;
            threeHelper = 1;
            return true;
        }
        else if (tempCard2 == tempCard3 && tempCard2 == tempCard4)
        {
            strength = 4;
            threeHelper = 2;
            return true;
        }
        else if (tempCard3 == tempCard4 && tempCard3 == tempCard5)
        {
            strength = 4;
            threeHelper = 3;
            return true;
        }
        return false;
    }

	/*
	    sort in ascending order
	     -> if first number is ace
	      -> check if next number is 10
	       -> if so, then straight
	       -> && isRoyal = true;
	     else
	        -> if each number is an increment of the previous number
	        -> return true
	 */

    public boolean isStraight()
    {

        if (tempCard5 - tempCard4 == 1 && tempCard4 - tempCard3 == 1 && tempCard3 - tempCard2 == 1 && tempCard2 - tempCard == 1)
        {
            strength = 5;
            return true;
        }
        return false;
    }

    //TODO
    /* iterate through each card, if the suit is the same as the previous card in the array, return true*/
    public boolean isFlush()
    {
        for (int i = 0; i < 5; ++i)
        {
//            if (hand.get(i+1).getSuit() != hand.get(i).getSuit())
//            {
//                return false;
//            }
        }
//        strength = 6;
//        return true;
        return false;
    }

    /* if three pair & two pair == true */
    public boolean isFullHouse()
    {
        if (isThreeKind())
        {
            if (threeHelper == 1 && tempCard4 == tempCard5)
            {
                strength = 7;
                return true;
            }
            else if (threeHelper == 2 && tempCard == tempCard5)
            {
                strength = 7;
                return true;
            }
            else if (threeHelper == 3 && tempCard == tempCard2)
            {
                strength = 7;
                return true;
            }
        }
        return false;
    }

    public boolean isFourKind()
    {
        if (threeHelper == 1 && tempCard4 == tempCard)
        {
            strength = 8;
            return true;
        }
        return false;
    }

    public boolean isStraightFlush()
    {
        if (isStraight() && isFlush() && !isRoyal)
        {
            strength = 9;
            return true;
        }

        return false;
    }

    public boolean isRoyalFlush()
    {
        if (isRoyal && isFlush())
        {
            strength = 10;
            return true;
        }
        return false;
    }
}