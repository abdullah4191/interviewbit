package codeScratch;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ZigzagString {

	public static void zigzag(final String input, final int n) {
		StringBuilder sb = new StringBuilder();
		int pad = 0;
		char[] chars = input.toCharArray();
		for (int k = 0; k < chars.length; k++) {
			for (int i = 0; i < chars.length; i += 2) {
				sb.append(chars[i]);
				sb = addPadding(sb, 2);
			}
			System.out.println(sb.toString());
		}

	}

	private static StringBuilder addPadding(final StringBuilder sb, int count) {
		while (count-- >= 0) {
			sb.append(" ");
		}
		return sb;
	}

	public static void zigzag2(final String input, final int n) {
		System.out.println(input.length());
		StringBuilder sb = new StringBuilder();
		char[][] chars = new char[n][input.length() * n];
		int index = 0;
		int i = 0;
		int col = 0;
		while (index < input.length()) {
			for (int j = 0; j < input.length() / n && index < input.length(); j++) {
				System.out.println(input.charAt(index) + " ,i: " + i % n + " ,j: " + j + " ,col: " + col);
				if (Character.isLetter(chars[i % n][col])) {
					col++;
					System.out.println(
							"update: " + input.charAt(index) + " ,i: " + i % n + " ,j: " + j + " ,col: " + col);
				}
				chars[i++ % n][col] = input.charAt(index++);

			}
			// col++;
		}

		System.out.println();
		System.out.println();
		System.out.println("---------------------------------");
		for (i = 0; i < n; i++) {
			for (int j = 0; j < input.length() * n; j++) {
				sb.append(chars[i][j]);
				System.out.print(chars[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
		System.out.println("---------------------------------");
		System.out.println(sb.toString());

	}

	public static String zigzag3(final String input, final int n) {
		if (n == 1)
			return input;
		List<StringBuilder> rows = new LinkedList<StringBuilder>();
		IntStream.range(0, n).forEach(i -> rows.add(new StringBuilder()));

		int row = 0;
		boolean down = false;
		for (char c : input.toCharArray()) {
			rows.get(row).append(c);
			if (row <= 0 || row >= n - 1) {
				down = !down;
			}
			row += down ? 1 : -1;
		}
		return rows.stream().map(Object::toString).collect(Collectors.joining());

	}

	public static void main(String[] args) {
		String input = "ABCDEFGH";// "";
		// zigzag2(input, 3);
		System.out.println(zigzag3(input, 3));
	}

}
