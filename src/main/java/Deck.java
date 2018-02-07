/** 
 * A Big Deck that does Deck-like things. - Assignment II
 * CPS109 - Instructor: Dr. Eric Harley
 *        - TA: ???
 * @author Shahnawaz Syed
 */

import java.util.*;

public class Deck 
{
	/**
	 * Create and initialize 4 arrays that have indices 13.
	 * Create an array 'names' which contains the four suits of a standard deck of cards.
	 * Create and initialize an integer variable rounds, which counts the number of rounds played.
	 * Create and initialize an integer previousNum, which checks to make sure that a number when switching hands is
	   repeated twice.
	 * Create and initialize an integer Java Dollars that will deal out and calculate the amount of pay-out user receives.
	 * Create and initialize a boolean variable quit, which when flagged will end the process.
	 */
	public static String[] cardSpades  = new String[13];
	public static String[] cardDiamonds  = new String[13];
	public static String[] cardHearts  = new String[13];
	public static String[] cardClubs  = new String[13];
	public static String[] names = {"Clubs", "Diamonds", "Hearts", "Spades"};
	public static int rounds = 0;
	public static int previousNum = 0;
	public static int JavaDollars = 0;
	public static boolean quit = false;

	/**
	 * The method 'create' assigns the values 1 to 13 (inclusive) to each suit.
	 */
	public static void create()
	{
		int i;
		for (i = 0; i < 13; i++)
		{
			cardSpades[i] = Integer.toString((i+1));
			cardDiamonds[i] = Integer.toString((i+1));
			cardHearts[i] = Integer.toString((i+1));
			cardClubs[i] = Integer.toString((i+1));
		}
	}
	/**
	 * The method 'swap', helps shuffle the values and indices of the desired array.
	 * @param a is the array wished to shuffle.
	 * @param i is the number where a temporary value is stored. This will work best with a for loop since the location of i can always be randomized depending on the length of the array.
	 * @param change is the part in the array which swaps the value from temp.
	 */
	public static void swap(String[] a, int i, int change) 
	{
		String temp = a[i];
		a[i] = a[change];
		a[change] = temp;
	}

	/**
	 * Creates the hand, utilizing two arrays: the face value and the suit respectively. Must be of length 10.
	 * Why 10? Read on below.
	 * @param a the face value array, of length 10.
	 * @param b the suit value array, of length 10.
	 */
	public static void hand(String[] a, String b[])
	{
		/**
		 * Creates a random object to help assign random suit names to each face value.
		 */
		Random dealing = new Random();
		int deal;
		/**
		 * So. Why store 10 values? Simple. I store 10 cards because I don't want to shrink or delete pre-existing arrays.
		 * I'm a memory hog.
		 * So I created two arrays of index 10, one array stores 10 face values, the other stores 10 suit names.
		 * Indices 0-4 (inclusive) will be strictly accessed by the program as your hand, and indices 5-10 (inclusive) will be any value you wish to swap cards with.
		 * This is efficient to me as the values of the cards do not have to repeatedly be shuffled, and methods and objects don't have to be repeatedly called.
		 * In fact this saves and frees up more RAM then other programs, and prevents code from being manipulated via outside sources.
		 */
		for (int i = 0; i < 10; i++)
		{
			deal = dealing.nextInt(4);
			b[i] = names[deal];
			/**
			 * If statements are assigning values to @param a randomnly, from 0-3 (inclusive)
			 */
			if (deal == 0)
			{
				a[i] = cardClubs[i];
			}
			else if (deal == 1)
			{
				a[i] = cardDiamonds[i];
			}
			else if (deal == 2)
			{
				a[i] = cardHearts[i];

			}
			else if (deal == 3)
			{
				a[i] = cardSpades[i];
			}
		}
	}
	/**
	 * The method 'change' is 'swap, in a sense it helps change the values and indices of the desired array.
	 * The one difference is that I increment i by 5 so that it accesses the arrays in the indices 5 ahead.
	 * @param b is the array wished to shuffle.
	 * @param i is the number where a temporary value is stored. This will work best with a for loop since the location of i can always be randomized depending on the length of the array.
	 * @param change is the part in the array which swaps the value from temp.
	 */
	private static void change(String[] b, int i, int switchCards) 
	{
		String temp = b[i];
		b[(switchCards - 1)] = b[(i+5)];
		b[i+5] = temp;
	}

	/**
	 * Takes the card value and suit arrays respectively and outputs them in a fancy output!
	 * @param a is the card value array
	 * @param b is the suit array
	 */
	public static void current(String[] a, String[] b)
	{
		System.out.println("------------------------------");
		System.out.println("      Your Current Hand: ");
		System.out.println("------------------------------");
		/** 
		 * Print out all values of the array.
		 */
		for (int i = 0; i < 5; i++)
		{
			/**
			 * If the card is 1, 11, 12, 13, then print out A, J, Q, K respectively instead.
			 * Read the switchNames method below for more details.
			 */
			switchNames(a, i);
			System.out.println(b[i]);
		}
	}
	/**
	 * the 'hitMe' method when accessed, changes up the cards depending on the values given.
	 * @param ans is to check whether or not the user wants to switch cards around.
	 * @param a is the value of the card array
	 * @param b is the suit array
	 * @param c is the boolean which checks if the game has quit or not, as in that case the card will not return certain values.
	 */
	public static void hitMe(String ans, String a[], String b[], boolean c)
	{
		/**
		 * Initialize the amount of the cards that are to be switched, and the amount of cards to switch.
		 * Create a new object that reads input.
		 * Declare and initialize a boolean variable that is read from the parameter to check when the program is exiting.
		 */
		int switchCards, switchLength;
		Scanner scan = new Scanner(System.in);
		boolean flag = c;

		/**
		 * Asks the user if they would like to change up their cards, or not. 
		 * If you don't type in the right answer, keep looping until the end-user learns how to type.
		 */
		while(flag == false)
		{
			/**
			 * If yes, continue the application.
			 */
			if (ans.equalsIgnoreCase("Yes"))
			{	
				/**
				 * The while loop will eventually end, as you have decided to switch your cards.
				 */
				flag = true;
				/**
				 * The amount of cards to switch is entered first.
				 */
				System.out.println("Type in the amount of cards (from 1-5) you would like to change.");
				/**
				 * Throw an exception. As we're dealing with an integer. If you enter anything else, return an error.
				 */
				try
				{
					switchLength = scan.nextInt();

					/**
					 * Check to make sure the user enters a number from 1 to 5, not more, not less.
					 */
					if (switchLength <= 0 || switchLength > 5)
					{
						flag = false;
						System.out.println("Error: Please enter a number between 1 and 5.");
						System.out.println();
					}
					/**
					 * If you enter 5, just switch them all.
					 */
					else if (switchLength == 5)
					{
						flag = true;
						for (int i = 0; i < switchLength; i++)
						{
							//switch card value
							change(a, i, (i+1));
							change(b, i, (i+1));
						}
						newDeal(a, b);
					}
					/**
					 * If you enter a valid number, continue on. Now this time, enter the numbers from the list above to switch that card.
					 */
					else
					{
						System.out.println("Please enter the card's hand number from above to switch that card.");
						for (int i = 0; i < switchLength; i++)
						{
							switchCards = scan.nextInt();
							/**
							 * At this point I'm ticked off. If you enter a number less than or equal to 0, or greater than 5, the program will keep repeating itself.
							 * This is done to prevent erroneous changes to the code, as well as changing previous cards over and over again.
							 * You can only change your card once. That's it! Follow the rules!
							 */
							if (switchCards <= 0 || switchCards > 5 || previousNum == switchCards)
							{
								System.out.println("Error: Please, enter a number from 1 to 5 next time. The game will now restart again.");
								switchLength = 0;
								previousNum = switchCards;
								flag = false;
							}
							/**
							 * If you executed the program correctly, then the user will be notified.
							 * Make sure you set the previousNum to switchCards so that the program will check for that.
							 */
							else
							{
								if (flag == true)
								{
									/**
									 * Perform the switch here: change the hand and the values using the method switchCards.
									 */
									change(a, i, switchCards);
									change(b, i, switchCards);
									System.out.println("The card has been switched succesfully!");
									previousNum = switchCards;

								}
							}
						}
						/**
						 * If, and only if the flag is raised, then output the new hand.
						 */
						if (flag == true)
						{
							newDeal(a, b);
						}

					}
				}
				/**
				 * Let the user know what error he made when entering any other value instead of an integer.
				 * Quit needs to be true or else it'll loop like crazy.
				 */
				catch(InputMismatchException e)
				{
					System.out.println("Error: You must enter a valid integer. The game will now quit pre-maturely.");
					quit = true;
				}

			}

			/**
			 * You don't want to switch your hand? Well aren't you confident. We increase the counter rounds here, to calculate
			   Java Dollars, and just tell the user how long he's wasted his life with this game.
			 */
			else if (ans.equalsIgnoreCase("No"))
			{
				flag = true;
				System.out.println("Alright, you seem confident with your hand! Let's see how you do... ");
				rounds++;
			}
			/**
			 * If you type in anything or than 'Yes' or 'No', then you will have to endure the loop of death.
			 */
			else
			{
				flag = false;
				System.out.println("Please type in 'Yes' or 'No'.");
				ans = scan.nextLine();
			}
		}
	}

	/**
	 * Method 'newDeal' outputs the new hand, with arrays 'a' and 'b'.
	 * @param a is the card array
	 * @param b is the suit array 
	 */
	public static void newDeal(String a[], String b[])
	{
		quit = false;
		rounds++;
		System.out.println();
		System.out.println("All cards have been switched successfully.");
		System.out.println();
		System.out.println("Let's see how you do now!");
		System.out.println("------------------------------");
		System.out.println("        Your New Hand: ");
		System.out.println("------------------------------");

		for (int i = 0; i < 5; i++)
		{
			/**
			 * If the card is 1, 11, 12, 13, then print out A, J, Q, K respectively instead.
			 * Read the switchNames method below for more details.
			 */
			switchNames(a, i);
			System.out.println(b[i]);
		}
	}

	/**
	 * Method 'HandValue' returns the Hand Strength value of the card.
	 * According to the pay-out chart in the Java Textbook, you receive certain pay-out for each hand that scores.
	 * In descending order, the user receives the points: 250, 50, 25, 6, 5, 4, 3, 2, 1
	 * @param a the card array values
	 * @param b the suit array values
	 */
	public static void HandValue(String[] a, String[] b)
	{
		/**
		 * For all of the if statements, the format is fairly simple. 
		 * Each HandStrength requires an array. Some require both the face value and the suit.
		 * Except for Royal Flush, Straight Flush, and a Flush, the other methods needed just the card value array.
		 * Pay out according to the chart in Chapter 7 of the Big Java textbook, and add to the value of wager in the
		 * Poker class.
		 */
		if(HandStrength.RoyalFlush(a, b) == true)
		{
			System.out.println();
			System.out.println("Royal Flush is found!");
			JavaDollars += 250 + Poker.wager;
			System.out.println("You currently have " + JavaDollars + " JavaDollars!");
		}
		else if(HandStrength.StraightFlush(a, b) == true)
		{
			System.out.println();
			System.out.println("Straight Flush is found!");
			JavaDollars += 50 + Poker.wager;
			System.out.println("You currently have " + JavaDollars + " JavaDollars!");
		}
		else if(HandStrength.FourKind(a) == true)
		{
			System.out.println();
			System.out.println("Four of a Kind is found!");
			JavaDollars += 25 + Poker.wager;
			System.out.println("You currently have " + JavaDollars + " JavaDollars!");
		}
		else if(HandStrength.FullHouse(a) == true)
		{
			System.out.println();
			System.out.println("Full House is found!");
			JavaDollars += 6 + Poker.wager;
			System.out.println("You currently have " + JavaDollars + " JavaDollars!");
		}
		else if(HandStrength.Flush(a, b) == true)
		{
			System.out.println();
			System.out.println("Flush is found!");
			JavaDollars += 5 + Poker.wager;
			System.out.println("You currently have " + JavaDollars + " JavaDollars!");
		}
		else if(HandStrength.Straight(a) == true)
		{
			System.out.println();
			System.out.println("Straight is found!");
			JavaDollars += 4 + Poker.wager;
			System.out.println("You currently have " + JavaDollars + " JavaDollars!");
		}
		else if(HandStrength.ThreeKind(a) == true)
		{
			System.out.println();
			System.out.println("Three of a kind is found!");
			JavaDollars += 3 + Poker.wager;
			System.out.println("You currently have " + JavaDollars + " JavaDollars!");
		}
		else if(HandStrength.TwoPair(a) == true)
		{
			System.out.println();
			System.out.println("Two pairs is found!");
			JavaDollars += 2 + Poker.wager;
			System.out.println("You currently have " + JavaDollars + " JavaDollars!");
		}
		else if(HandStrength.Pair(a) == true)
		{
			System.out.println();
			System.out.println("Pair is found!");
			JavaDollars += 1 + Poker.wager;
			System.out.println("You currently have " + JavaDollars + " JavaDollars!");
		}
		/**
		 * If nothing was found, return the user pity.
		 */
		else
			System.out.println("Nothing found...Sorry!");
	} 
	/**
	 * This simple methods switches the values of 1, 11, 12, and 13 to Ace, Jack, Queen, and King respectively
	 * @param a the array (face value) to switch names for during output
	 * @param i for index in the array @param a
	 */
	public static void switchNames(String[] a, int i)
	{
		System.out.print((i+1) +". ");
		if (a[i].equals("1"))
		{
			System.out.print("A of ");
		}
		else if (a[i].equals("11"))
		{
			System.out.print("J of ");
		}
		else if (a[i].equals("12"))
		{
			System.out.print("Q of ");
		}
		else if (a[i].equals("13"))
		{
			System.out.print("K of ");
		}
		else
		{
			System.out.print(a[i]+ " of ");
		}
	}
}