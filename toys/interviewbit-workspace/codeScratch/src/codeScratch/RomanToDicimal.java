package codeScratch;

import java.security.InvalidParameterException;
import java.util.Collections;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;

public class RomanToDicimal {

	public static NavigableMap<Integer, String> table;

	static {
		NavigableMap<Integer, String> conversionTable = new TreeMap<Integer, String>();

		// I V X L C D M
		// 1 5 10 50 100 500 1,000
		conversionTable.put(1, "I");
		conversionTable.put(4, "IV");
		conversionTable.put(5, "V");
		conversionTable.put(9, "IX");
		conversionTable.put(10, "X");
		conversionTable.put(40, "XL");
		conversionTable.put(50, "L");
		conversionTable.put(90, "XC");
		conversionTable.put(100, "C");
		conversionTable.put(400, "CD");
		conversionTable.put(500, "D");
		conversionTable.put(900, "CM");
		conversionTable.put(1000, "M");
		table = Collections.unmodifiableNavigableMap(conversionTable);
	}

	public static String convert(int number) throws InvalidParameterException {
		if (number == 0)
			throw new InvalidParameterException();

		StringBuilder sb = new StringBuilder();
		while (number > 0) {
			Map.Entry<Integer, String> entry = table.floorEntry(number);
			sb = append(sb, entry.getValue(), number / entry.getKey());
			number = number % entry.getKey();
		}

		return sb.toString();
	}

	private static StringBuilder append(StringBuilder sb, String str, int n) {
		while (n-- > 0)
			sb.append(str);

		return sb;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input = 0;
		Scanner scanner = new Scanner(System.in);
		// System.out.println(scanner.hasNextInt());
		if (scanner.hasNextInt())
			input = scanner.nextInt();
		scanner.close();
		// System.out.println(input);
		System.out.println(convert(input));
		// table.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " " +
		// e.getValue()));
	}

}
