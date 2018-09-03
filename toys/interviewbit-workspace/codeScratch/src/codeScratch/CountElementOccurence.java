package codeScratch;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CountElementOccurence {

	public int findCount(final List<Integer> A, int B) {
		int count = 0;

		int start = 0, end = A.size() - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (A.get(mid) == B) {
				count++;
				int index = mid + 1;
				while (index <= A.size()-1 && A.get(index++) == B) {
					count++;
				}
				index = mid - 1;
				while (index >= 0 && A.get(index--) == B) {
					count++;
				}
				return count;
			} else if (A.get(mid) > B) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		CountElementOccurence instance = new CountElementOccurence();
		// int[] arr = { 5, 7, 7, 8, 8, 10 };
		int[] arr = { 1 };
		System.out.println(instance.findCount(IntStream.of(arr).boxed().collect(Collectors.toList()), 1));
	}

}
