package codeScratch;

public class PrimeTester {
	public int isPrime(int A) {
		if (A == 0 || A == 1)
			return 0;
		for (int i = 2; i <= Math.sqrt(A); i++) {
			if (A % i == 0)
				return 0;
		}
		return 1;
	}

	public static void main(String[] args) {
		PrimeTester instance = new PrimeTester();
		System.out.println(instance.isPrime(8));

	}

}
