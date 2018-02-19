public class Poker
{

    public static void main(String[] args)
    {
        Hand player = new Hand();
        Hand enemy = new Hand();
        Deck deck = new Deck();

        deck.shuffle();

        //deal player & enemy cards
        for (int i = 1; i <= 5; ++i)
        {
            player.addCard(deck.dealCard());
            enemy.addCard(deck.dealCard());
        }

        //sort hands
        player.sortHand(player.hand());
        enemy.sortHand(enemy.hand());

        System.out.println("===Player hand===");
        for (Card c : player.hand())
        {
            System.out.println(c);
        }
        System.out.println();

        System.out.println("===Enemy hand===");
        for (Card c : enemy.hand())
        {
            System.out.println(c);
        }

        System.out.println();
        System.out.println("Player has: " + player.checkStrength());
        System.out.println("Enemy has: " + enemy.checkStrength());
        System.out.println();
        System.out.println("Player high: " + player.returnHighCard(player.hand()));
        System.out.println("Enemy high: " + enemy.returnHighCard(enemy.hand()));
        System.out.println();

        //Debug
//        int gameNum = 1;
//        while (player.checkStrength() != 9 && enemy.checkStrength() != 9)
//        {
//            player = new Hand();
//            enemy = new Hand();
//            deck = new Deck();
//
//            deck.shuffle();
//
//            //deal player & enemy cards
//            for (int i = 1; i <= 5; ++i)
//            {
//                player.addCard(deck.dealCard());
//                enemy.addCard(deck.dealCard());
//            }
//
//            //sort hands
//            player.sortHand(player.hand());
//            enemy.sortHand(enemy.hand());
//
//            System.out.println("===Player hand===");
//            for (Card c : player.hand())
//            {
//                System.out.println(c);
//            }
//            System.out.println();
//
//            System.out.println("===Enemy hand===");
//            for (Card c : enemy.hand())
//            {
//                System.out.println(c);
//            }
//            System.out.println();
//            System.out.println("Player has: " + player.checkStrength());
//            System.out.println("Enemy has: " + enemy.checkStrength());
//            System.out.println("Player high: " + player.returnHighCard(player.hand()));
//            System.out.println("Enemy high: " + enemy.returnHighCard(enemy.hand()));
//            System.out.println();
//            gameNum++;
//            System.out.println();
//            System.out.println("game num: " + gameNum);
//        }

        if (player.checkStrength() > enemy.checkStrength())
        {
            System.out.println("Game over, you win!");
        }
        else if (player.checkStrength() < enemy.checkStrength())
        {
            System.out.println("Game over, you lose.");
        }
        else
        {
            if (player.returnHighCard(player.hand()) > enemy.returnHighCard(enemy.hand()))
            {
                System.out.println("Game over, you win!");
            }
            else if (player.returnHighCard(player.hand()) < enemy.returnHighCard(enemy.hand()))
            {
                System.out.println("Game over, you lose.");
            }
            else if (player.returnHighCard(player.hand()) == enemy.returnHighCard(enemy.hand()))
            {
                System.out.println("Game over, it's a tie!");
            }
        }
    }
}