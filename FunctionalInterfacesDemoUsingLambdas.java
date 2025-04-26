import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfacesDemoUsingLambdas {
    public static void main(String[] args) {
        Random rand = new Random();
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Function<Integer, Integer> doubleMe = n -> n * 2;
        Consumer<Integer> con = n -> System.out.printf("Square of %d is: %d\n", n, n * n);
        Supplier<Integer> randomGenerator = () ->rand.nextInt(10) + 1;

        int number = randomGenerator.get();
        System.out.println("Generated number: " + number);
        con.accept(isEven.test(number) ? doubleMe.apply(number): number);
    }
}
