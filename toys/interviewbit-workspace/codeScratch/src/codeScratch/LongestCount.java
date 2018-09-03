package codeScratch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestCount {

	private static int getCount(List<Integer> nums) {
		// return 2;
		// TODO: implement
		if (nums.isEmpty())
			return 0;
		int index = 0, count = 0;
		Integer seriesId = nums.get(index);

		while (index < nums.size() && seriesId == nums.get(++index)) {

		}
		return -1;

	}

	static Integer maxRepeating(List<Integer> nums) {
		if (nums.isEmpty())
			return 0;
		int len = nums.size();
		int maxCount = 0;

		for (int i = 0; i < len; i++) {
			int count = 1;
			for (int j = i + 1; j < len; j++) {
				if (nums.get(i) != nums.get(j)) {
					//i = j;
					break;
				}
				count++;
			}

			if (count > maxCount) {
				maxCount = count;
			}
		}
		return maxCount;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String[] arrItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
		List<Integer> arr = new ArrayList<>();
		for (int i = 0; i < arrItems.length; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr.add(arrItem);
		}
		bufferedReader.close();

		System.out.println(maxRepeating(arr));
	}

}
