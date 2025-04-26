import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfacesDemo {
    public static void main(String[] args) {
        Predicate<Integer> isEven = new Predicate<Integer>() {
            public boolean test(Integer n) {
                return n % 2 == 0;
            }
        };

        Function<Integer, Integer> doubleMe = new Function<>() {
            public Integer apply(Integer n) {
                return n * 2;
            }
        };

        Consumer<Integer> con = new Consumer<>() {
            public void accept(Integer n) {
                System.out.printf("Square of %d is: %d\n", n, n * n);
            }
        };

        Random rand = new Random();
        Supplier<Integer> randomGenerator = new Supplier<>() {
            public Integer get() {
                return rand.nextInt(10) + 1;
            }
        };

        int number = randomGenerator.get();
        System.out.println("Generated number: " + number);
        con.accept(isEven.test(number) ? doubleMe.apply(number): number);
    }
}
