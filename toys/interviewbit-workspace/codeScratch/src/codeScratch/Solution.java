package codeScratch;

import java.util.Arrays;
import java.util.List;

public class Solution {

	static String mergeStrings(String a, String b) {
		if (a.isEmpty() && !b.isEmpty())
			return b;
		else if (!a.isEmpty() && b.isEmpty())
			return a;
		else if (a.isEmpty() && b.isEmpty())
			return "";
		String result = "";
		int i = 0;
		for (; i < a.length(); i++) {
			result += a.charAt(i);
			if (i < b.length()) {
				result += b.charAt(i);
			}
		}
		if (i < b.length())
			result += b.substring(i);
		return result;

	}

	static void textQueries(List<String> sentences, List<String> queries) {
		for (String query : queries) {
			List<String> phrases = Arrays.asList(query.split(" "));
			for (int i = 0; i < sentences.size(); i++) {
				String sentence = sentences.get(i);
				boolean match = true;
				for (String phrase : phrases) {
					if (!sentence.contains(phrase)) {
						match = false;
						break;
					}
				}
				if (match) {
					System.out.print(i + " ");
				}
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(mergeStrings("11111", "222"));
		//textQueries(sentences, queries);

	}

}
