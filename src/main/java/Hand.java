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

    public int checkStrength()
    {
        HandStrength strength = new HandStrength();
        return strength.checkStrength();
    }
}
