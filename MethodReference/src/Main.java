import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

class PlainOld {

    private static int last_id = 1;

    private int id;

    public PlainOld() {
        id = last_id++;
        System.out.println("Creating a PlainOld Object: id = " + id);
    }
}

public class Main {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(List.of(
            "Anna", "Bob", "Chuck", "Dave"));

        list.forEach(System.out::println);

        calculator(Double::sum, 10.2, 26.0);
        calculator(Integer::sum, 10, 26);


        Supplier<PlainOld> reference1 = PlainOld::new;

        PlainOld newPojo = reference1.get();

        UnaryOperator<String> a = s -> s.substring(1, 2);

        list.replaceAll(a);
        list.forEach(System.out::println);

        System.out.println("Getting array");
        PlainOld[] pojo1 = seedArray(PlainOld::new, 10);

        calculator((s1, s2) -> s1.concat(s2), "Nguyen ", "Hieu");
        calculator(String::concat, "Nguyen ", "Hieu");

        BinaryOperator<String> b1 = (s1, s2) -> s1.concat(s2);
        BiFunction<String, String, String> b2 = String::concat;
        UnaryOperator<String> b3 = String::toUpperCase;

        System.out.println(b1.apply("Nguyen ", "Hieu"));
        System.out.println(b2.apply("Nguyen ", "Hieu"));
        System.out.println(b3.apply("hieu"));

        String result = "Hello".transform(b3);
        System.out.println("Result = " + result);

        result = result.transform(String::toLowerCase);
        System.out.println("Result = " + result);

        Function<String, Boolean> f0 = String::isEmpty;
        boolean resultBoolean = result.transform(f0);
        System.out.println("Result = " + resultBoolean);



    }

    private static <T> void calculator(BinaryOperator<T> function, T value1, T value2) {

        T result = function.apply(value1, value2);
        System.out.println("Result of operation: " + result);
    }

    private static PlainOld[] seedArray(Supplier<PlainOld> reference, int count) {

        PlainOld[] array = new PlainOld[count];
        Arrays.setAll(array, i -> reference.get());
        return array;
    }
}