package codeScratch;

import java.util.Arrays;

public class LengthOfLastWord {
	public int get(String input) {
		String[] wordList = input.split(" ");
		int count = wordList.length;
		if (count > 0) {
			return Arrays.asList(wordList).get(count - 1).trim().length();
		}

		return 0;
	}

	int get2(String input) {
		input = input.trim();
		int count = 0;
		int index = input.length() - 1;
		while (index > -1 && Character.isAlphabetic(input.charAt(index))) {
			count++;
			index = input.length() - 1 - count;
		}
		return count;
	}

	public static void main(String[] args) {
		String input = "a bb";
		System.out.println(new LengthOfLastWord().get(input));
		System.out.println(new LengthOfLastWord().get2(input));
	}

}
