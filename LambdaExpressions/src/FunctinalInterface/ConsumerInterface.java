package FunctinalInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

public class ConsumerInterface {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(List.of(
                "alpha", "bravo", "charlie", "delta"));

        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("-------");
        list.forEach((s) -> System.out.println(s));

        System.out.println("-".repeat(30));
        final String prefix = "nato";
        list.forEach((var myString) -> {
            char first = myString.charAt(0);
            System.out.println(prefix + " " + myString + " means " + first);
        });

        int result = calculator((a, b) -> {
            System.out.println(a + " + " + b + " = " + (a + b));
            return a + b;
        }, 5, 2);

        var result2 = calculator((a, b) ->  a + b, 10.0, 1.5);

        var result3 = calculator(
                (a, b) -> a.toUpperCase() + " " + b.toUpperCase(),
                "Ralph", "Kramden"
        );

        System.out.println("---".repeat(20));

        var coords = Arrays.asList(
                new double[] {47.2160, -95.2348},
                new double[] {29.1566, -89.2495},
                new double[] {35.1556, -90.0659}
        );

        coords.forEach(s -> System.out.println(Arrays.toString(s)));

        BiConsumer<Double, Double> p1 = (lat, lng) ->
                System.out.printf("[lat:%.3f lon:%.3f]%n", lat, lng);

        processPoint(coords.get(0)[0], coords.get(0)[1], p1);

        System.out.println("---".repeat(20));

        coords.forEach(s -> processPoint(s[0], s[1], p1));
        coords.forEach(s -> processPoint(s[0], s[1],
                (lat, lng) -> System.out.printf("[lat:%.3f lon:%.3f]%n", lat, lng)));

        list.removeIf(s -> s.equalsIgnoreCase("bravo"));
        list.forEach(System.out::println);

        list.addAll(List.of("echo", "easy", "earnest"));
        list.forEach(System.out::println);

        System.out.println("---".repeat(20));

        list.removeIf(s -> s.startsWith("ea"));
        list.forEach(System.out::println);

        list.replaceAll(s -> s.charAt(0) + " - " + s.toUpperCase());
        System.out.println("---".repeat(20));
        list.forEach(System.out::println);

        System.out.println("---".repeat(20));
        String[] emptyStrings = new String[10];
        System.out.println(Arrays.toString(emptyStrings));

        Arrays.fill(emptyStrings, "");
        System.out.println(Arrays.toString(emptyStrings));

        Arrays.setAll(emptyStrings, (i) -> "" + (i + 1) + ". ");
        System.out.println(Arrays.toString(emptyStrings));

        Arrays.setAll(emptyStrings, (i) -> "" + (i + 1) + ". "
            + switch (i) {
                    case 1 -> "One";
                    case 2 -> "Two";
                    case 3 -> "Three";
                    default -> "";
                }
        );
        System.out.println(Arrays.toString(emptyStrings));

        String[] names = {"Ann", "Bob", "Carol", "David", "Ed", "Fred"};
        String[] randomList = randomlySelectedValues(15, names,
                () -> new Random().nextInt(0, names.length));

        System.out.println(Arrays.toString(randomList));





    }


    public static String[] randomlySelectedValues(int count,
                                                  String[] values,
                                                  Supplier<Integer> s) {
        String[] selectedValues = new String[count];
        for (int i = 0; i < count; i++) {
            selectedValues[i] = values[s.get()];
        }
        return selectedValues;
    }

    public static <T> void processPoint(T t1, T t2, BiConsumer<T, T> consumer) {
        consumer.accept(t1, t2);
    }

    public static <T> T calculator(BinaryOperator<T> function, T value1, T value2) {

        T result = function.apply(value1, value2);
        System.out.println("Result of operation: " + result);;
        return result;
    }

//    public static <T> T calculator(Operation<T> function, T value1, T value2) {
//
//        T result = function.operate(value1, value2);
//        System.out.println("Result of operation: " + result);;
//        return result;
//    }

}
