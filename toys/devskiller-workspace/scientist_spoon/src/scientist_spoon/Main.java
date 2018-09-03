package scientist_spoon;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        final Scientist s1 = new Scientist("Charles");
        final Scientist s2 = new Scientist("Pier");
        final Scientist s3 = new Scientist("Bob");
        final Scientist s4 = new Scientist("Ivan");

        final Spoon spoon = new Spoon(s1);

        new Thread(new Runnable() {
                @Override
                public void run() {
                    s1.eat(spoon, s2);
                }
            }
        ).start();
        new Thread(new Runnable() {
                @Override
                public void run() {
                    s2.eat(spoon, s3);
                }
            }
        ).start();
        new Thread(new Runnable() {
                @Override
                public void run() {
                    s3.eat(spoon, s4);
                }
            }
        ).start();
        new Thread(new Runnable() {
                @Override
                public void run() {
                    s4.eat(spoon, s1);
                }
            }
        ).start();
    }
}