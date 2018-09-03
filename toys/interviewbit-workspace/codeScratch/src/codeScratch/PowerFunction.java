package codeScratch;

public class PowerFunction {

	double powerIterative(int base, int power) {
		double result = power > 0 ? base : 1;
		for (int i = 1; i < power; i++) {
			result *= (double) base;
		}

		return result;
	}

	static int power(int x, int y) {
		if (y == 0)
			return 1;
		else if (y % 2 == 0)
			return power(x, y / 2) * power(x, y / 2);
		else
			return x * power(x, y / 2) * power(x, y / 2);
	}

	int powerDevideAndConqure(int x, int y) {
		if (y == 0) {
			return 1;
		}
		int temp = powerDevideAndConqure(x, y / 2);
		if ((y & 1) == 0) {
			return temp * temp;
		} else {
			return x * temp * temp;
		}
	}

	// Iterative solution to calculate pow(x, n) using binary operators
	public static int powerBinary(int x, int n) {
		int pow = 1;

		// do till n is not zero
		while (n > 0) {
			// if n is odd, multiply result by x
			if ((n & 1) == 1) {
				pow *= x;
			}

			// divide n by 2
			n = n >> 1;

			// multiply x by itself
			x = x * x;
		}

		// return result
		return pow;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PowerFunction instance = new PowerFunction();
		System.out.println(instance.powerIterative(2, 50));
		System.out.println(power(2, 3));
		System.out.println(6 >> 1);
		System.out.println(instance.powerDevideAndConqure(2, 3));
		System.out.println(powerBinary(2, 3));

	}

}