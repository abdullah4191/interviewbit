package codeScratch;

import java.util.ArrayList;
import java.util.List;

public class AllFactors {
	public int[] allFactors(int A) {
		if (A == 1)
			return new int[] { 1 };

		List<Integer> Arr1 = new ArrayList<Integer>();
		List<Integer> Arr2 = new ArrayList<Integer>();
		for (int i = 2; i <= Math.sqrt(A); i++) {
			if (A % i == 0) {
				Arr1.add(i);
				if (i != Math.sqrt(A)) {
					Arr2.add(A / i);
				}
			}
		}
		int size = Arr1.size() + Arr2.size() + 2;
		int[] result = new int[size];
		result[0] = 1;
		result[size - 1] = A;
		int index = 0;
		if (Arr1.size() > 0) {
			for (int i = 0; i < size - 2; i++) {
				index = i < Arr1.size() ? i : i - Arr1.size();
				if (Arr1.get(index) < Arr2.get(index)) {
					result[i + 1] = Arr1.get(index);
					Arr1.set(index, Integer.MAX_VALUE);
				} else if (Arr2.size() > 0) {
					result[size - i + 1] = Arr2.get(index);
					Arr2.set(index, Integer.MAX_VALUE);
				}

			}
		}
		return result;
	}

	public static void main(String[] args) {
		AllFactors instance = new AllFactors();
		// System.out.println(pretty.prettyPrint(3));
		int[] result = instance.allFactors(85463);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
}
