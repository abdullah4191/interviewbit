package codeScratch;

public class CountAndSay {
	/**
	 * @param n
	 *            the nth
	 * @return the nth sequence
	 */
	public String countAndSay(int n) {
		String s = "1";
		while (n-- > 1) {
			char[] c = s.toCharArray();
			String t = "";
			int cnt = 1;

			int i = 1;
			while (i <= c.length) {
				if (i == c.length) {
					t += cnt + "" + c[i - 1];
				} else if (c[i] == c[i - 1]) {
					cnt++;
				} else {
					t += cnt + "" + c[i - 1];
					cnt = 1;
				}
				i++;
			}
			s = t;
			System.out.println(n+"--------------------------------------");
			System.out.println(s);
		}
		return s;
	}

	public static void main(String[] args) {
		CountAndSay instance = new CountAndSay();
		System.out.println(instance.countAndSay(8));

	}

}
