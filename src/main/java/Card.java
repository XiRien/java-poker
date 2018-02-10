public class Card
{
    private final int suit;
    private final int value;

    public Card(int suit, int value)
    {
        this.suit = suit;
        this.value = value;
        if (suit < 1 || suit > 4)
        {
            throw new IllegalArgumentException("Illegal suit");

        }
        if (value < 1 || value > 13)
        {
            throw new IllegalArgumentException("Illegal value");
        }
    }

    public int getSuit()
    {
        return suit;
    }

    public int getValue()
    {
        return value;
    }

    private static String convertNums(int suit, int value)
    {
        String stringSuit;
        String stringValue;
        switch (suit)
        {
            case 1:
                stringSuit = "Diamonds";
                break;

            case 2:
                stringSuit = "Hearts";
                break;

            case 3:
                stringSuit = "Clubs";
                break;

            case 4:
                stringSuit = "Spades";
                break;

            default:
                stringSuit = "Invalid string";
                break;
        }
        switch (value)
        {
            case 1:
                stringValue = "Ace";
                break;

            case 2:
                stringValue = "Two";
                break;

            case 3:
                stringValue = "Three";
                break;

            case 4:
                stringValue = "Four";
                break;

            case 5:
                stringValue = "Five";
                break;

            case 6:
                stringValue = "Six";
                break;

            case 7:
                stringValue = "Seven";
                break;

            case 8:
                stringValue = "Eight";
                break;

            case 9:
                stringValue = "Nine";
                break;

            case 10:
                stringValue = "Ten";
                break;

            case 11:
                stringValue = "Jack";
                break;

            case 12:
                stringValue = "Queen";
                break;

            case 13:
                stringValue = "King";
                break;

            default:
                stringValue = "Invalid string";
                break;
        }
        return stringValue + " of " + stringSuit;
    }

    @Override
    public String toString()
    {
        return convertNums(suit, value);
    }
}
