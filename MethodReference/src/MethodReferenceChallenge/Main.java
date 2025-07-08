package MethodReferenceChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.UnaryOperator;

public class Main {

    private static Random random = new Random();

    private record Person(String first) {

        public String last(String s) {
            return first + " " + s.substring(0, s.indexOf(" "));
        }
    }

    public static void main(String[] args) {

        String[] names = {"Anna", "Bob", "Cameron", "Donald", "Eva", "Francis"};

        Person hieu = new Person("Hieu");

        List<UnaryOperator<String>> list = new ArrayList<>(List.of(
                String::toUpperCase,
                s -> s += " " + getRandomChar('D', 'M') + ".",
                s -> s += " " + reverse(s, 0, s.indexOf(" ")),
                Main::reverse,
                String::new,
//                s -> "Howdy" + s,
                String::valueOf,
                hieu::last,
                (new Person("Mary"))::last
        ));

        applyChanges(names, list);






    }

    private static String reverse(String s) {
        return reverse(s, 0 , s.length());
    }

    private static String reverse(String s, int start, int end) {
        return new StringBuilder(s.substring(start, end)).reverse().toString();
    }

    private static char getRandomChar(char startChar, char endChar) {
        return (char) new Random().nextInt((int) startChar, (int) endChar + 1);
    }

    private static void applyChanges(String[] names,
                                     List<UnaryOperator<String>> stringFunctions)
    {

        List<String> backedByArray = Arrays.asList(names);

        for (var function : stringFunctions) {
            backedByArray.replaceAll(s -> s.transform(function));
            System.out.println(Arrays.toString(names));
        }
    }
}
