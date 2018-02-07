/** 
 * A Simulation of a 1 Player Poker Game - Assignment II
 * CPS109 - Instructor: Dr. Eric Harley
 *        - TA: ???
 * @author Shahnawaz Syed
 */

import java.util.*;
import java.lang.Math;

public class Poker 
{
	/**
	 * Create a variable of type integer, to use for wagering in the betting system of the game.
	 */
	public static int wager;

	public static void main(String[] args)
	{
		/**
		 * Create a hand and suit array of size 10; Indices:  0-4 (inclusive) will be your hand..
		 * ... 5-10 (inclusive) will be your will be your shuffle hand
		 */
		String[] hand = new String[10];
		String[] suit = new String[10];

		/**
		 * Declare scanner object, String, boolean, and integer variables for program flow.
		 */
		Scanner scan = new Scanner(System.in);
		String ans, playAgain;
		boolean flag, flagQuit;
		int rounds;

		/**
		 * Initialize the variables so that they may used during the game's duration.
		 */
		rounds = 0;
		flag = false;
		flagQuit = false;


		/**
		 * Introduce the user to the game that they are playing.
		 */
		System.out.println("Welcome to the Poker game!");
		System.out.println();

		/**
		 * While the game is not flagged to quit, keep running the game. 
		 * The conditions for quitting are if the program throws an exception, or if the user wishes to quit.
		 */
		while(flagQuit != true)
		{
			/**
			 * Ask the user how much they would like to wager. 
			 * The user must wager a certain amount (1 to infinity - inclusive) and cannot wager 0, as they must pay to play.
			 * If the user enters a number less than 0 (a negative number) then the program will take the absolute
			   value of that number.
			 */
			System.out.println("How much would you like to wager?");
			try 
			{
				wager = scan.nextInt();
				if (wager < 0)
				{
					System.out.println("Error: Assuming your wager is positive, instead of a negative number.");
					wager = Math.abs(wager);
				}
				else if (wager == 0)
				{
					System.out.println("Suddenly, the program steals 1 JavaDollar from you!");
					System.out.println("It shouts: \"You can't wager anything! There's no fun in that!\"");
					wager = 1;
				}
				wager = Deck.JavaDollars - wager;

				/**
				 * Create a deck object, by assigning values to it.
				 * Refer to Deck.java for more information on what happens here.
				 */
				Deck.create();

				/**
				 * By creating a randomizing object, the cards value, index, and assignment
				   will be randomized in fair order.
				 */
				Random rand = new Random();
				int n = 13; // length of the pile to shuffle
				for (int i = 0; i < n; i++)
				{
					int changeS = i + rand.nextInt(n - i);
					int changeD = i + rand.nextInt(n - i);
					int changeH = i + rand.nextInt(n - i);
					int changeC = i + rand.nextInt(n - i);

					Deck.swap(Deck.cardSpades, i, changeS);
					Deck.swap(Deck.cardDiamonds, i, changeD);
					Deck.swap(Deck.cardHearts, i, changeH);
					Deck.swap(Deck.cardClubs, i, changeC);	
				}

				/**
				 * The user then calls the hand method, which assigns 10 values to the hand and suit arrays respectively.
				 * For more information please refer to Deck.java
				 */
				Deck.hand(hand, suit);

				/**
				 * The user then calls the current method, which outputs the current hand.
				 * For more information please refer to Deck.java
				 */
				Deck.current(hand, suit);

				/**
				 * Ask the user if they would like to switch their cards.
				 * For more information please refer to Deck.java
				 */
				System.out.println();
				System.out.println("This is your current hand. Would you like to switch any cards?");
				ans = scan.nextLine();

				/**
				 * If they switch their hands, then the hitMe method is called from the Deck class.
				 * For more information please refer to Deck.java
				 */
				Deck.hitMe(ans, hand, suit, flag);
				/**
				 * Initializes the number of rounds that are being played.
				 */
				rounds = Deck.rounds;
				/**
				 * Makes sure the game hasn't been triggered a quit boolean flag from the Deck class. 
				 * If the game has not pre-maturely quit, then retrieve the values of the hand.
				 * Else, do nothing.
				 */

				if (Deck.quit == false)
				{
					Deck.HandValue(hand, suit);
				}
				else

					System.out.println();

				/**
				 * Interesting note: The rounds variable could be initialized at this point as well.
				 * After countless searches and checking for bugs, I had to compensate for the fact that 
				   I threw an exception for anything other than an integer entered when assigning variables.
				   Come on. I totally deserve 10/10, bro.
				 */

				System.out.println("Would you like to play again?");
				playAgain = scan.nextLine();

				/**
				 * Ask the user if they would like to play again. If they answer yes, then the game will not
				  flag quit, and the game will continue.
				 * If the user decides to quit, then output accordingly, and flag quit.
				 */

				if (playAgain.equalsIgnoreCase("Yes"))
				{
					flagQuit = false;
				}
				else if (playAgain.equalsIgnoreCase("No"))
				{
					flagQuit = true;
					/**
					 * If you have no money, and decide to quit, then output to the user that they are in the negatives.
					 * Otherwise, let the user know they have won a certain amount of Java Dollars.
					 */
					if (wager < 0)
					{
						System.out.println("You played " + (rounds) + " round(s) and are " +Math.abs(wager)+ " Java Dollar(s) in the hole...");
						System.out.println("You know what they say. Gambling: The sure way of getting nothing from something!");
					}
					else if (wager >= 0)
					{
						System.out.println("You played " + (rounds) + " round(s) and have won " +wager+ " Java Dollar(s)! Thanks for playing!");
					}
				}
				/**
				 * If the user doesn't enter 'Yes' or 'No', then the game does not quit until the user answers accordingly.
				 */
				else
				{
					flagQuit = false;
					System.out.println("Error: Please type in 'Yes' or 'No'.");
					playAgain = scan.nextLine();
				}
			}
			/**
			 * Let the user know that if he tries to enter anything else other than 1-5, I won't stand for it!
			 */
			catch(InputMismatchException e)
			{
				System.out.println("Error: You must enter a valid wager. The program will now quit.");
				flagQuit = true;
			}
		}
	}
}
