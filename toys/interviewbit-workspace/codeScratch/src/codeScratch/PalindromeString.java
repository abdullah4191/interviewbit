package codeScratch;

import java.util.Arrays;

public class PalindromeString {
	public static boolean istPalindrom(String A) {
		//char[] c = {'A'};c.
		A=A.replaceAll("[^a-zA-Z\\d]", "").toLowerCase();
		//System.out.println(A);
		for (int i = 0, j = A.length() - 1; i <= j; i++, j--) {
			//System.out.println("i=" + i + " ,j=" + j);
			if (A.charAt(i) != A.charAt(j)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String wort = "reliefpfpfeiller";
		char[] warray = wort.toCharArray();
		System.out.println(istPalindrom("A man, a plan, a canal: Panama"));
	}

}
