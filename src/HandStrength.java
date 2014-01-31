/** 
 * A HandStrength class to determine the strength of a hand in a Poker game. - Assignment II
 * CPS109 - Instructor: Dr. Eric Harley
 *        - TA: ???
 * @author Shahnawaz Syed
 */

public class HandStrength 
{
	/**
	 * Checks for whether the hand contains a Pair. Initializes a value array, and a counter.
	 * @param a The parameter accepts an array that is used for assigning and checking values.
	 * @return true or false depending on whether or not a Pair was found.
	 */
	public static boolean Pair(String a[]) 
	{
		String[] values = new String[5];
		int counter = 0;
		/**
		 * Put the numeric value of the card into an array called values.
		 * Why the numeric value? I really don't know. If I just left it the same way, it would return null.
		 */
		assignArray(values, a);

		/**
		 * Loop through the array 25 times.
		 * Compare each value of parameter array 'a' to all the values in the values array.
		 * If the counter equals 2, then return true, and stop everything else.
		 */
		for(int i = 0; i < values.length; i++)
		{
			for(int j = 0; j < 5; j++){
				if(values[i].equals(a[j].toString()))
				{
					counter++;
					if(counter == 2)
					{
						return true;
					}
				}
			}
			counter = 0;
		}
		return false;
	}

	/**
	 * Checks for whether the hand contains a Two Pair. Initializes a value array, an integer sum, and a counter.
	 * @param a The parameter accepts an array that is used for assigning and checking values.
	 * @return true or false depending on whether or not a Two Pair was found.
	 */

	public static boolean TwoPair(String a[])
	{
		String[] values = new String[5];
		int counter = 0;
		int sum = 0;

		/**
		 * Having a Two Pair can be the same as having a Four of a Kind, since both can have the same values.
		 * This will make sure that if a Four of a Kind is true, then the Two Pair boolean is false.
		 */
		if(FourKind(a) == true)
		{
			return false;
		}

		/**
		 * Put the numeric value of the card into an array called values.
		 * Why the numeric value? I really don't know. If I just left it the same way, it would return null.
		 */
		assignArray(values, a);

		/**
		 * Loop through the array 25 times.
		 * Compare each value of parameter array 'a' to all the values in the values array.
		 * If the sum is 4, then return true, and stop everything else.
		 */
		for(int i = 0; i < values.length; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				if(values[i].equals(a[j].toString()))
				{
					counter++;
				}
			}
			if(counter > 1)
			{
				sum++;
			}

			counter = 0;
		}

		if(sum == 4)
		{
			return true;
		}
		return false;
	}
	/**
	 * Checks for whether the hand contains a Three of a Kind. Initializes a value array, and a counter.
	 * It is to note, that a Three of a Kind is almost the same as a Two Pair.
	 * @param a The parameter accepts an array that is used for assigning and checking values.
	 * @return true or false depending on whether or not a Three of a Kind was found.
	 */
	public static  boolean ThreeKind(String a[]) 
	{
		String[] values = new String[5];
		int counter = 0;

		/**
		 * Put the numeric value of the card into an array called values.
		 * Why the numeric value? I really don't know. If I just left it the same way, it would return null.
		 */
		assignArray(values, a);

		/**
		 * Loop through the array 25 times.
		 * Compare each value of parameter array 'a' to all the values in the values array.
		 * If the counter equals 3, then return true, and stop everything else.
		 */
		for(int i = 0; i < values.length; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				if(values[i].equals(a[j].toString()))
				{
					counter++;
				}
				if(counter == 3)
				{
					return true;
				}
			}
			counter = 0;
		}
		return false;
	} 

	/**
	 * Checks for whether the hand contains a Straight. Initializes a value array.
	 * Since the value of A can be a low or high card, we make the neccessary change below.
	 * @param a The parameter accepts an array that is used for assigning and checking values.
	 * @return true or false depending on whether or not a Straight was found.
	 */
	public static  boolean Straight(String[] a)
	{
		int[] values = new int[5];

		/**
		 * This is the same as setting the values in the previous boolean methods, but the 
		   difference here is that we want to make sure that the values of A can loop around.
		 */
		for(int i = 0; i < 5; i++)
		{
			values[i] = Integer.parseInt(a[i]);
			/**
			 * In my code, 1 is equal to Ace. So if the number 1 is found, let 1 be equal to 14 as well.
			 */
			if(values[i] == 1)
			{
				values[i] = 14;
			}
		}
		/**
		 * Calls the sort method (made by me because I am a pro), which sorts the values to ascending order. 
		 */
		sort(values);

		/**
		 * This code specifically checks for a straight. Each successive card should also be incremented by 1
		   as we will get a lot of nulls if other wise!
		 */

		for(int i = 0; i < values.length - 1; i++)
		{
			if(values[i] != values[i+1] - 1)
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks for whether the hand contains a Flush. Initializes a card array to check values.
	 * @param a is the hand's face value.
	 * @param b is the hand's suit.
	 * @return true or false depending on whether or not a Flush was found.
	 */
	public static  boolean Flush(String a[], String b[]) 
	{
		String card = b[0].toString();
		for(int i = 1; i < 5; i++)
		{
			if(!(b[i].equals(card)))
			{
				return false;
			}
		}
		return true;
	}
	/**
	 * Checks for whether the hand contains a Full House. Initializes a value array, an integer sum, and a counter.
	 * @param a is the hand's face value.
	 * @return true or false depending on whether or not a Full House was found.
	 */
	public static  boolean FullHouse(String a[])
	{
		String[] values = new String[5];
		int counter = 0;
		int sum = 0;

		/**
		 * A four of a kind can also be represented as a full house, we return this value as false
		   if Four of a Kind returns true.
		 */
		if(FourKind(a) == true)
		{
			return false;
		}

		/**
		 * Put the numeric value of the card into an array called values.
		 * Why the numeric value? I really don't know. If I just left it the same way, it would return null.
		 */
		assignArray(values, a);

		/**
		 * Check for if the values are equivalent, if they are, then increment counter by 1.
		 * Whenever counter is greater than one, increment sum. If sum is not equivalent by 5, reset counter until this is the case.
		 * If Sum is equivalent to 5, return true for Full House.
		 */
		for(int i = 0; i < values.length; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				if(values[i].equals(a[j].toString()))
				{
					counter++;
				}
			}
			if(counter > 1)
			{
				sum++;
			}

			counter = 0;
		}

		if(sum == 5)
		{
			return true;
		}

		return false;
	} 
	/**
	 * Checks for whether the hand contains a Four of a Kind. Initializes a card array to check values, and a counter.
	 * @param a is the hand's face value.
	 * @return true or false depending on whether or not a Four of a Kind was found.
	 */
	public static boolean FourKind(String a[]) 
	{
		String[] values = new String[5];
		int counter = 0;

		/**
		 * Put the numeric value of the card into an array called values.
		 * Why the numeric value? I really don't know. If I just left it the same way, it would return null.
		 */
		assignArray(values, a);

		/**
		 * This code is more or less the same code from Pair, except that we are searching for value 4 instead of 2.
		 */
		for(int i = 0; i < values.length; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				if(values[i].equals(a[j].toString()))
				{
					counter++;
				}
				if(counter == 4)
				{
					return true;
				}
			}
			counter = 0;
		}
		return false;
	}
	/**
	 * Checks for whether the hand contains a Straight Flush. Initializes a card array to check values.
	 * @param a is the hand's face value.
	 * @param b is the hand's suit.
	 * @return true or false depending on whether or not a Straight Flush was found.
	 */

	public static boolean StraightFlush(String a[], String b[])
	{
		/**
		 * A Straight Flush can only be true if the Straight Flush contains a Straight, and a Flush. 
		 * Therefore, we make things easier by assigning true for the Straight Flush, if it is found.
		 */
		if(Straight(a) == true && Flush(a, b) == true)
		{
			return true;
		}

		return false;
	}

	/**
	 * Checks for whether the hand contains a Royal Flush. Initializes a card array to check values.
	 * @param a is the hand's face value.
	 * @param b is the hand's suit.
	 * @return true or false depending on whether or not a Royal Flush was found.
	 */
	public static boolean RoyalFlush(String a[], String b[])
	{
		/**
		 * If the Royal Flush does not contain a flush or a straight, it is automatically not a Royal Flush.
		 * We make things easier for us by just returning flush off the bat.
		 * Besides, you have more of a chance getting hit by a car
		   than getting a a Royal Flush in this game. ;)
		 */
		if(Flush(a, b) == false || Straight(a) == false)
		{
			return false;
		}

		/**
		 * Values is initialized
		 */
		int[] values = new int[5];

		/**
		 * Set values for the array. Once again, the rule from Straight applies here, where ace can loop around.
		 */
		for(int i = 0; i < 5; i++)
		{
			values[i] = Integer.parseInt(a[i]);
			/**
			 * In my code, 1 is equal to Ace. So if the number 1 is found, let 1 be equal to 14 as well.
			 */
			if(values[i] == 1)
			{
				values[i] = 14;
			}
		}

		/**
		 * Sort the values to make checking easier.
		 */
		sort(values);

		/**
		 * Another check special to the Royal Flush: If the first card in the index is 10, then we can assume 
		   that it is a royal flush automatically.
		   Otherwise return false for everything.
		 */
		if(values[0] == 10)
		{
			return true;
		}
		return false;
	}

	/**
	 * Custom sort method created by yours truly.
	 * @param values the array to be sorted, which in this case is the values of the hand assigned for checks
	 */
	public static void sort(int[] values)
	{
		values = new int[5];
		int sort;
		int temp;

		/**
		 * I'm not explaining this one. Sorry. This is generic pre-school sort methods that are taught for 
		   practicing arrays.
		 */
		for(int i = 1; i < values.length; i++)
		{
			sort = i;
			while(sort != 0)
			{
				if(values[sort] < values[sort-1])
				{
					temp = values[sort];
					values[sort] = values[sort-1];
					values[sort-1]= temp;
				}
				sort--;
			}
		}
	}
	/**
	 * To prevent repeated code, this method automatically assigns values from one array to another.
	 * @param a the array to assign values to
	 * @param b the array to retrieve values from
	 */
	public static void assignArray(String[] a, String[] b)
	{
		for(int i = 0; i < 5; i++)
		{
			a[i] = b[i].toString();
		}
	}
}