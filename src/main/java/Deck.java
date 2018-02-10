import java.util.ArrayList;
import java.util.Collections;

public class Deck
{
    private ArrayList<Card> deck = new ArrayList<Card>();

    public Deck()
    {
        //create card deck
        for (int i = 1; i <= 4; ++i)
        {
            for (int j = 1; j <= 13; ++j)
            {
                deck.add(new Card(i, j));
            }
        }
    }

    public void shuffle()
    {
        Collections.shuffle(deck);
    }

    public int cardsLeft()
    {
        //return number of cards left in deck
        return deck.size();
    }

    public Card dealCard()
    {
        //deals card to player
        Card topCard = deck.get(0);
        if (deck.size() - 1 != 0)
        {
            deck.remove(0);
            return topCard;
        } else
        {
            throw new IllegalStateException("No more cards left");
        }
    }
}