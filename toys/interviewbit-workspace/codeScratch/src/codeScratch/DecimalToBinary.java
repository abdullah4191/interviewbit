package codeScratch;

public class DecimalToBinary {

	public String findDigitsInBinary(int A) {
		if (A == 0)
			return "0";
		StringBuilder result = new StringBuilder();
		while (A > 0) {
			result.append(A % 2);
			A /= 2;
		}
		return result.reverse().toString();
	}

	public static void main(String[] args) {
		DecimalToBinary instance = new DecimalToBinary();
		int A = 1;
		System.out.println(instance.findDigitsInBinary(A));
		System.out.println(Integer.toBinaryString(A));
	}

}
