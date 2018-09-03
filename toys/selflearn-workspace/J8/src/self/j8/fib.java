package self.j8;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;

public class fib {

	public static void main(String[] args) {
		IntSupplier fib = new IntSupplier() {
		      private int previous = 0;
		      private int current = 1;

		      public int getAsInt() {
		        int nextValue = this.previous + this.current;
		        this.previous = this.current;
		        this.current = nextValue;
		        return this.previous;
		      }
		    };
		    IntStream.generate(fib).limit(15).forEach(i -> {System.out.print(i+ " ");});
	}

}
