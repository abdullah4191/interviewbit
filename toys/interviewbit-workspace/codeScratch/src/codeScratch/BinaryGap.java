package codeScratch;

public class BinaryGap {

	public static int solution(int N) {
		// byte byteN = new Integer(N).byteValue();
		// System.out.println(byteN);
		int result = 0, resultMax = 0;
		while (N > 1) {
			result = 0;
			if ((N & 1) == 1) {
				N = (N >> 1);
				// System.out.println(N);
				while (true) {
					if ((N & 1) == 0) {
						result++;
						N = (N >> 1);
						// System.out.println(N);
					} else {
						if (result > resultMax) {
							resultMax = result;
							// System.out.println(N);
						}
						break;
					}
				}
			} else {
				N = (N >> 1);
			}
		}
		return resultMax;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(1610612737));// 1041

	}

}
