package UnmodifiableCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        StringBuilder bobsNotes = new StringBuilder();
        StringBuilder billsNotes = new StringBuilder("Bill struggles with generics");

        Student bob = new Student("Bob", bobsNotes);
        Student bill = new Student("Bill", billsNotes);

        List<Student> students = new ArrayList<>(List.of(bob, bill));
        List<Student> studentsFirstCopy = new ArrayList<>(students);
        List<Student> studentsSecondCopy = List.copyOf(students);
        List<Student> studentsThirdCopy = Collections.unmodifiableList(students);

        studentsFirstCopy.add(new Student("Bonnie", new StringBuilder()));
//        studentsSecondCopy.set(0, new Student("Bonnie", new StringBuilder()));
//        studentsSecondCopy.sort(Comparator.comparing(Student::getName));
        students.add(new Student("Bonnie", new StringBuilder()));
        bobsNotes.append("Bob was one of my first students.");

        StringBuilder bonniesNotes = studentsFirstCopy.get(2).getStudentNotes();
        bonniesNotes.append("Bonnie is taking 3 of my courses");

        students.forEach(System.out::println);
        System.out.println("---".repeat(20));

        studentsFirstCopy.forEach(System.out::println);
        System.out.println("---".repeat(20));

        studentsSecondCopy.forEach(System.out::println);
        System.out.println("---".repeat(20));

        studentsThirdCopy.forEach(System.out::println);
        System.out.println("---".repeat(20));











    }
}
