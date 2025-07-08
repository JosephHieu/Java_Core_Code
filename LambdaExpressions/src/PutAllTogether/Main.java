package PutAllTogether;

import java.util.*;


public class Main {

    private static Random random = new Random();

    public static void main(String[] args) {

        String[] names = {"Anna", "Bob", "Carole", "David", "Ed", "Fred", "Gary"};

        Arrays.setAll(names, i -> names[i].toUpperCase());
        System.out.println("--> Transform to Uppercase");
        System.out.println(Arrays.toString(names));

        List<String> backedByArray = Arrays.asList(names);

        backedByArray.replaceAll(s -> s += " " + getRandomChar('A', 'D'));
        System.out.println("--> Add random middle initial");
        System.out.println(Arrays.toString(names));

        backedByArray.replaceAll(s -> s += ". " + getReversedName(s.split(" ")[0]));
        System.out.println("--> Add reversed name as last name");
        Arrays.asList(names).forEach(System.out::println);

        List<String> newList = new ArrayList<>(List.of(names));
//        newList.removeIf(s -> s.substring(0, s.indexOf(" ")).equals(
//                s.substring(s.lastIndexOf(" ") + 1)
//        ));

        newList.removeIf(s -> {
            String first = s.substring(0, s.indexOf(" "));
            String last = s.substring(s.lastIndexOf(" ") + 1);
            return first.equals(last);
        });

        System.out.println("--> Remove names where first = last");
        newList.forEach(System.out::println);


        System.out.println("---".repeat(20));
        String[] chuoi = {"Le", "Dinh", "Trung", "Nguyen", "Hoang", "Hieu"};

        List<String> lists = new ArrayList<>(List.of(chuoi));

        lists.forEach(s -> {
            s = s.toUpperCase();
            System.out.println(s);
        });

//        lists.removeIf(s -> s.charAt(0) == 'L');
        System.out.println(lists);


        System.out.println(lists);


        System.out.println("---".repeat(20));

        List<Students> students = new ArrayList<>();
        students.add(new Students("Vu", "311", "09109"));
        students.add(new Students("Vu", "31", "09109"));
        students.add(new Students("Khoi", "11", "09109"));
        students.add(new Students("An", "1", "09109"));


        students.sort(Comparator.comparing(Students::ten).thenComparing(Students::tuoi));

        students.forEach(s -> System.out.print(s.ten() + " "));

        System.out.println();
        System.out.println("-----");

        Arrays.setAll(chuoi, i -> chuoi[i].toUpperCase());
        System.out.println(Arrays.toString(chuoi));

    }

    public static char getRandomChar(char startChar, char endChar) {
        return (char) random.nextInt((int) startChar, (int) endChar + 1);
    }

    private static String getReversedName(String firstName) {
        return new StringBuilder(firstName).reverse().toString();
    }
}
