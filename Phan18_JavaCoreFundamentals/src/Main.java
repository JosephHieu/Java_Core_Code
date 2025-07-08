import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        Predicate<Integer> isOpp = s -> s % 2 == 0;


        System.out.println(isOpp.test(10));


    }
}
