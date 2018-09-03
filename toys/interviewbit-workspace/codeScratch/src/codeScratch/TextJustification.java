package codeScratch;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class TextJustification {

	public static String[] justify(String[] words, final int maxWidth) {
		List<String> result = new LinkedList<String>();
		List<String> aLine = new LinkedList<String>();

		String line = "";
		int lineSize = 0;
		for (String word : words) {
			if (lineSize + word.length() < maxWidth) {
				aLine.add(word);
				lineSize += word.length();
			} else {
				aLine.stream().forEach(text -> text.concat(" "));
				result.add(aLine.toString());
				aLine.clear();
				lineSize = 0;
				aLine.add(word + " ");
				lineSize += word.length();
			}

			if (lineSize >= maxWidth) {
				aLine.stream().forEach(text -> text.concat(" "));
				result.add(aLine.toString());
			}
		}

		return (String[]) result.toArray(new String[result.size()]);
	}

	public static String[] justify2(String[] words, final int maxWidth) {
		List<String> result = new LinkedList<String>();
		int textLength = Arrays.asList(words).stream().mapToInt(String::length).sum() % maxWidth;
		System.out.println("textLength " + textLength);
		return (String[]) result.toArray(new String[result.size()]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = { "This", "is", "an", "example", "of", "text", "justification." };
		String[] result = justify2(words, 16);
		for (String s : result) {
			System.out.println(s);
		}
		String[] words1={"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
		String[] result1 = justify2(words1, 20);
		for (String s : result) {
			System.out.println(s);
		}

	}

}
