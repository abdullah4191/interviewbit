package scientist_spoon;

public interface ITestA extends ITest {
    default String process() {
        return "Process A";
    };
}