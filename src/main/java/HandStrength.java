public class HandStrength
{
    private static int strength = 0;

    public int checkStrength()
    {
        return strength;
    }

    private static boolean isRoyal = false;
    /* sort, if tere contains */

    public static boolean isPair(Hand hand)
    {
        strength = 1;
        return false;
    }

    /* if is pair is in list, make a new hand from the rest of the cards and check if another pair exists */
    public static boolean isTwoPair(Hand hand)
    {
        strength = 2;
        return false;
    }

    public static boolean isThreeKind(Hand hand)
    {
        strength = 3;
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

    public static boolean isStraight(Hand hand)
    {
        strength = 4;
        return true;
    }

    /* iterate through each card, if the suit is the same as the previous card in the array, return true*/
    public static boolean isFlush(Hand hand)
    {
        strength = 5;
        return true;
    }

    /* if three pair & two pair == true */
    public static boolean isFullHouse(Hand hand)
    {
        if (isThreeKind(hand))
        {
            /*take value of the three kind, check if pair is found s.t value of three kind is not in the pair, if so, fullhouse*/
            strength = 6;
        }
        return false;
    }

    public static boolean isFourKind(Hand hand)
    {
        strength = 7;
        return false;
    }

    public static boolean isStraightFlush(Hand hand)
    {
        if (isStraight(hand) && isFlush(hand) && !isRoyal)
        {
            strength = 8;
            return true;
        }

        return false;
    }

    public static boolean isRoyalFlush(Hand hand)
    {
        if (isRoyal && isFlush(hand))
        {
            strength = 9;
            return true;
        }
        return false;
    }
}