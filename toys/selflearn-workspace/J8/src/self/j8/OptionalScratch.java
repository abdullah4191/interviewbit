package self.j8;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Optional;
import java.util.Properties;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;

public class OptionalScratch {
	Optional<String> stringOpt = Optional.of("foobar");
	Inner innerInstance = new Inner();
	Optional<Inner> innerInstanceOpt = Optional.of(innerInstance);

	public OptionalScratch() {
		innerInstance.name = "firstName";
		innerInstance.salary = 1000;
	}

	public void setInnerInstance(Inner innerInstance) {
		this.innerInstance = innerInstance;
	}

	public Inner getInnerInstance() {
		return innerInstance;
	}

	public Optional<Inner> getInnerInstanceOpt() {
		return innerInstanceOpt;
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		// System.setOut(new PrintStream("out.txt"));
		final OptionalScratch instance = new OptionalScratch();
		instance.stringOpt.ifPresent(name -> System.out.println(name));
		// instance.stringOpt.map(() -> System.out.println());
		// instance.innerInstance.name=null;

		String name = instance.innerInstanceOpt.map(Inner::getName).orElse("Not Available");
		System.out.println(name);

		int salary = instance.innerInstanceOpt.map(Inner::getSalary).orElse(-1);
		System.out.println(salary);

		Optional<OptionalScratch> optionalScratchOpt = Optional.of(instance);
		name = optionalScratchOpt.flatMap(OptionalScratch::getInnerInstanceOpt).map(Inner::getName)
				.filter(value -> "firstname".equalsIgnoreCase(value)).orElse("Not Available");
		System.out.println(name);

		System.out.println("test!");
		System.out.println(System.getProperty("java.vm.vendor"));
		Properties properties = System.getProperties();
		properties.keySet().stream()
				.forEach(o -> System.out.println(o.toString() + " : " + properties.getProperty(o.toString())));

		int[] a = IntStream.range(3, 10).toArray();
		System.out.println(a);
		//System.err.println("foo");
		//System.out.println("OptionalScratch.main()");
		final int[] x = { 0 };
		System.out.println(++x[0]);
		
		int[] nextInt = { 0 }; // optionally mark as final
		IntSupplier supplier = () -> nextInt[0]++;
		
		System.out.println(supplier.getAsInt());
		System.out.println(supplier.getAsInt());
		
		IntStream.generate(supplier).forEach(System.out::println);
	}

	public static class Inner {
		private String name;
		private int salary;

		void printName() {
			System.out.println(name);
		}

		public String getName() {
			return name;
		}

		public int getSalary() {
			return salary;
		}
	}

}
