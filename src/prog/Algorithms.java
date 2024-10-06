package prog;

import java.math.BigInteger;
import java.util.Arrays;

public class Algorithms {

	public static int powInt(int a, int b) {
		int resp = 1;
		for (int i=1; i<=b; i++)
			resp *= a;
		return resp;
	}

	/**
	 * A Narcissistic Number (or Armstrong Number) is a positive number which is the sum of its own digits, 
	 * each raised to the power of the number of digits in a given base. 
	 * Note: in this case it is restricted to decimal (base 10).
	 * 
	 * The method receives a number, and it answers if it is narcissistic. 
	 * 
	 * For example, take 153 (3 digits), which is narcissistic: 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153
	 * and 1652 (4 digits), which isn't: 1^4 + 6^4 + 5^4 + 2^4 = 1 + 1296 + 625 + 16 = 1938.
	 * 
	 * @param number is a positive integer
	 * @return true or false depending upon whether the given number is a Narcissistic number in base 10
	 */
	public static boolean isNarcissistic(int number) {
		int i = 1;
		int digits = 0;
		while (number/i >= 1) {
			i *= 10;
			digits++;
		}
		int sum = 0;
		int aux = number;
		i = 1;
		while (i<=digits && sum<=number) {
			sum += powInt(aux%10,digits);
			aux /= 10;
			i++;
		}
		return (sum == number);
	}

	/**
	 * The method takes in a string of one or more words, and returns the same string, 
	 * but with all words that have five or more letters reversed. 
	 * Strings passed in will consist of only letters and spaces. 
	 * Spaces will be included only when more than one word is present.
	 * 
	 * Examples:
	 * "Hey fellow warriors"  --> "Hey wollef sroirraw" 
	 * "This is a test        --> "This is a test" 
	 * "This is another test" --> "This is rehtona test"
	 * 
	 * @param sentence is a string of one or more words (only letters and spaces, spaces will be included only when more than one word is present)
	 * @return the same string, but with all words that have five or more letters reversed
	 */
	public static String spinWords(String sentence) {

		//split the sentence in an array
		String[] words = sentence.split(" ");
		for (int i=0; i<words.length; i++) {
			String word = words[i];
			int length = word.length();
			if (length >= 5) {
				//reverse the word

				//option one:
				/*StringBuilder aux = new StringBuilder();
				for (int j=length-1; j>=0; j--) {
					aux.append(String.valueOf(word.charAt(j)));
				}*/

				//option two:
				StringBuilder aux = new StringBuilder(word);
				aux.reverse();
				words[i] = aux.toString();
			}	
		}

		//re-join the sentence
		StringBuilder resp = new StringBuilder();
		for (String word : words) {
			resp.append(word);
			resp.append(" ");
		}

		return resp.toString().substring(0, resp.length()-1);
	}

	/**
	 * As the "like" system, people can "like" blog posts, pictures or other items, 
	 * this method creates the text that should be displayed next to such an item.
	 * It takes an array containing the names of people that like an item and it returns the display text as shown in the examples:
	 * []                                -->  "no one likes this"
	 * ["Peter"]                         -->  "Peter likes this"
	 * ["Jacob", "Alex"]                 -->  "Jacob and Alex like this"
	 * ["Max", "John", "Mark"]           -->  "Max, John and Mark like this"
	 * ["Alex", "Jacob", "Mark", "Max"]  -->  "Alex, Jacob and 2 others like this"
	 * Note: For 4 or more names, the number in "and 2 others" simply increases.
	 * 
	 * @param names is an array of strings of names
	 * @return a string with the names from the param (see the note)
	 */
	public static String whoLikesIt(String... names) {
		int numElements = names.length;
		StringBuilder resp = new StringBuilder();
		final String individualLike = " likes this";
		final String multipleLike = " like this";
		switch (numElements) {
		case 0:
			resp.append("no one")
			.append(individualLike);
			break;
		case 1:
			resp.append(names[0])
			.append(individualLike);
			break;
		case 2:
			resp.append(names[0]).append(" and ").append(names[1])
			.append(multipleLike);
			break;
		case 3:
			resp.append(names[0]).append(", ").append(names[1]).append(" and ").append(names[2])
			.append(multipleLike);
			break;
		default:
			resp.append(names[0]).append(", ").append(names[1]).append(" and ").append(numElements-2).append(" others")
			.append(multipleLike);
		}
		return resp.toString();
	}

	/**
	 * The method increments a string, to create a new string.
	 * If the string already ends with a number, the number is incremented by 1.
	 * If the string does not end with a number. the number 1 is appended to the new string.
	 * 
	 * Examples:
	 * foo -> foo1
	 * foobar23 -> foobar24
	 * foo0042 -> foo0043
	 * foo9 -> foo10
	 * foo099 -> foo100
	 * 
	 * Attention: if the number has leading zeros the amount of digits should be considered.
	 * 
	 * @param str is a string
	 * @return the same string incremented by 1 (if it ends in a number, if not, a 1 is appended
	 */
	public static String incrementString(String str) {
		int i = str.length()-1;
		while (i >= 0 && Character.isDigit(str.charAt(i))) {
			i--;
		}
		String resp;
		if (i == str.length()-1) {
			resp = str.concat("1");
		} else {
			StringBuilder format = new StringBuilder("%0"); //"%010d"
			format.append(str.length()-1-i).append("d");
			BigInteger num = new BigInteger(str.substring(i+1));
			num = num.add(BigInteger.ONE);
			resp = new StringBuilder(str.substring(0, i+1))
					.append(String.format(format.toString(), num))
					.toString();
		}
		return resp;
	}

	/**
	 * Once upon a time, on a way through the old wild mountainous west, a man was given directions to go from one point to another. 
	 * The directions were "NORTH", "SOUTH", "WEST", "EAST". Clearly "NORTH" and "SOUTH" are opposite, "WEST" and "EAST" too.
	 * Going to one direction and coming back the opposite direction right away is a needless effort. 
	 * Since this is the wild west, with dreadful weather and not much water, it's important to save yourself some energy, otherwise you might die of thirst!
	 * 
	 * The directions given to the man are, for example, the following:
	 * ["NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"]
	 * You can immediately see that going "NORTH" and immediately "SOUTH" is not reasonable, better stay to the same place! 
	 * So the idea is to give to the man a simplified version of the plan. A better plan in this case is simply:
	 * ["WEST"]
	 * 
	 * Other examples:
	 * In ["NORTH", "SOUTH", "EAST", "WEST"], the direction "NORTH" + "SOUTH" is going north and coming back right away.
	 * The path becomes ["EAST", "WEST"], now "EAST" and "WEST" annihilate each other, therefore, the final result is [].
	 * In ["NORTH", "EAST", "WEST", "SOUTH", "WEST", "WEST"], "NORTH" and "SOUTH" are not directly opposite 
	 * but they become directly opposite after the reduction of "EAST" and "WEST" so the whole path is reducible to ["WEST", "WEST"].
	 * 
	 * This method takes an array of strings and returns an array of strings with the needless directions removed (W<->E or S<->N side by side).
	 * 
	 * Note:
	 * Not all paths can be made simpler. The path ["NORTH", "WEST", "SOUTH", "EAST"] is not reducible. 
	 * "NORTH" and "WEST", "WEST" and "SOUTH", "SOUTH" and "EAST" are not directly opposite of each other and can't become such. 
	 * Hence the result path is itself : ["NORTH", "WEST", "SOUTH", "EAST"].
	 * 
	 * @param arr is an array of strings with directions
	 * @return the same array of strings, with the needless directions removed (W<->E or S<->N side by side)
	 */
	public static String[] dirReduc(String[] arr) {
		int cleanings = 0; //times of reductions
		for (int i=1; i<arr.length; i++) {
			//looking for the previous element not cleaned (replaced with "")
			int j = i-1;
			while (j>=0 && arr[j].equals("")) {
				j--;
			}
			if (j == -1) { //there aren't previous elements to compare
				continue;
			}
			String prev = arr[j];

			//checking if a cleaning has to be done
			if ((prev.equals("NORTH") && arr[i].equals("SOUTH")) ||
					(prev.equals("SOUTH") && arr[i].equals("NORTH")) ||
					(prev.equals("EAST")  && arr[i].equals("WEST")) ||
					(prev.equals("WEST")  && arr[i].equals("EAST"))) {
				arr[i] = "";
				arr[j] = "";
				cleanings++;
			}
		}

		String[] resp = new String[arr.length-(2*cleanings)]; //new array with less elements
		int j = 0; //for resp
		for (int i=0; i<arr.length; i++) { //for arr
			if (!arr[i].equals("")) { //copying just the elements not cleaned
				resp[j] = arr[i];
				j++;
			}
		}
		return resp;
	}

	public static void main(String[] args) {
		System.out.println(isNarcissistic(112));

		System.out.println(spinWords("Abcde Bcde Cdefg Defghi Ef Fghijkl Ghi"));
		//System.out.println(spinWords("Welcome"));
		//System.out.println(spinWords("Hey fellow warriors"));

		System.out.println(whoLikesIt());
		System.out.println(whoLikesIt("Peter"));
		System.out.println(whoLikesIt("Jacob", "Alex"));
		System.out.println(whoLikesIt("Max", "John", "Mark"));
		System.out.println(whoLikesIt("Alex", "Jacob", "Mark", "Max"));

		System.out.println(incrementString("00123"));
		System.out.println(incrementString("foobar000"));
		System.out.println(incrementString("foobar001"));
		System.out.println(incrementString(""));
		System.out.println(incrementString("foo99"));
		System.out.println(incrementString("00000000000010379788349801487222163837"));

		System.out.println(Arrays.toString(dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"})));
		System.out.println(Arrays.toString(dirReduc(new String[]{"NORTH","SOUTH","SOUTH","EAST","WEST","NORTH"})));

	}

}
