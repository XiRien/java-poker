import java.util.ArrayList;

public class Hand
{
    private ArrayList<Card> hand = new ArrayList<>();

    public void addCard(Card fromDeck)
    {
        hand.add(fromDeck);
    }

    public void removeCard(int cardIndex)
    {
        if (hand.contains(hand.get(cardIndex)))
        {
            hand.remove(cardIndex);
        }
        else
        {
            throw new IllegalArgumentException("Card is not in the hand");
        }
    }

    public ArrayList<Card> hand()
    {
        return hand;
    }

    //TODO - need to sort by value and rank/suit
    public static void sortHand(ArrayList<Card> hand)
    {
        Card temp;
        for (int i = 1; i < hand.size(); ++i)
        {
            for (int j = i; j > 0; --j)
            {
                Card tempCard;
                Card tempCard2;
                tempCard = hand.get(j);
                tempCard2 = hand.get(j-1);
                if (tempCard.getValue() < tempCard2.getValue())
                {
                    temp = tempCard;
                    hand.set(j, tempCard2);
                    hand.set(j-1, temp);
                }
            }
        }
    }

    public int checkStrength()
    {
        HandStrength strength = new HandStrength(hand);
//        strength.isHighCard(hand);
        strength.isPair();
        strength.isTwoPair();
        strength.isThreeKind();
        strength.isStraight();
        strength.isFlush();
        strength.isFullHouse();
        strength.isFourKind();
        strength.isStraightFlush();
        strength.isRoyalFlush();
        return strength.checkStrength();
    }
}
