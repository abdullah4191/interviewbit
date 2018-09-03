package codeScratch;

public class PrettyPrint {
	public int[][] prettyPrint(int A) {
		int T = 0, B = (2 * A) - 2, R = (2 * A) - 2, L = 0, dir = 0;
		int[][] Arr = new int[2 * A - 1][2 * A - 1];
		while (T <= B && L <= R) {
			if (dir == 0) {
				for (int k = L; k <= R; k++) {
					// result.add(A[T][k]);
					Arr[T][k] = A;
					//System.out.println(A);
				}
				T++;
			} else if (dir == 1) {
				for (int k = T; k <= B; k++) {
					Arr[k][R] = A;
					//System.out.println(A);
				}
				R--;
			} else if (dir == 2) {
				for (int k = R; k >= L; k--) {
					Arr[B][k] = A;
					//System.out.println(A);
				}
				B--;
			} else if (dir == 3) {
				for (int k = B; k >= T; k--) {
					Arr[k][L] = A;
					//System.out.println(A);
				}
				L++;
			}
			dir = (dir + 1) % 4;
			if (dir == 0) {
				A -= 1;
			}
		}
		for (int i = 0; i < Arr.length; i++) {
			for (int j = 0; j < Arr.length; j++) {
				System.out.print(Arr[i][j]+ " ");
			}
			System.out.println();
		}

		// return result.stream().mapToInt(Integer::intValue).toArray();
		return Arr;
	}

	public static void main(String[] args) {
		PrettyPrint pretty = new PrettyPrint();
		//System.out.println(pretty.prettyPrint(3));
		pretty.prettyPrint(9000000);
	}

}

