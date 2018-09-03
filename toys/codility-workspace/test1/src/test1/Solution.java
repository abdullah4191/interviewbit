package test1;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

class Solution {
	public int solution() {
		int[] A = { 1, 2, 3 };
		int result = 1;
		boolean found = false;
		A = Arrays.stream(A).filter(x -> x > 0).sorted().distinct().toArray();
		System.out.println(Arrays.toString(A));
		for (int i = 0; i < A.length; i++) {
			result = i + 1;
			if (result != A[i]) {
				found = true;
				break;
			}
		}
		if (!found && result == A.length) {
			result++;
		}
		return result;
	}

	public int solution2() {
		int[] A = {1, 3, 6, 4, 1, 2};
		int result = 1;
		SortedSet<Integer> set = new TreeSet<Integer>();
		set.addAll(Arrays.stream(A).boxed().collect(Collectors.toList()));
		set.removeIf(x -> x.intValue() < 1);
		if (set.isEmpty())
			return result;
		for (int i = 1; i < set.size()+1; i++) {
			result = i;
			if (!set.contains(Integer.valueOf(i))) {
				return i;
			}
		}

		return set.size() + 1;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution2());
	}
}