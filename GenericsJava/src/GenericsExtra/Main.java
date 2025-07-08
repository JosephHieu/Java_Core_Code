package GenericsExtra;

import java.util.ArrayList;
import java.util.List;

public class Main {

    /*public static void main(String[] args) {

        int studentCount = 10;
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            students.add(new Student());
        }
        printList(students);

        List<Student> lpaStudents = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            lpaStudents.add(new LPAStudent());
        }
        printList(lpaStudents);

        System.out.println("-".repeat(40));
        var queryList = new QueryList<>(lpaStudents);
        var matches = queryList.getMatches("Course", "Python");
        printList(matches);

        System.out.println("-".repeat(40));
        var queryList2 = new QueryList<>(lpaStudents);
        var matches2 = queryList2.getMatches("YearStarted", "2020");
        printList(matches2);

        System.out.println("-".repeat(40));
        var student2021 =
                QueryList.getMatches(students, "Yearstarted", "2021");
        printList(student2021);

    }*/

    public static void printList(List<? extends Student> students) {

        for (var student : students) {
            System.out.println(student);
        }
        System.out.println();
    }

//    public static <T extends Student> void printList(List<T> students) {
//
//        for (var student : students) {
//            System.out.println(student.getYearStarted() + ": " + student);
//        }
//        System.out.println();
//    }

//    public static void testList(List<String> list) {
//        for (var element : list) {
//            System.out.println("String: " + element.toUpperCase());
//        }
//    }
//
//    public static void testList(List<Integer> list) {
//        for (var element : list) {
//            System.out.println("String: " + element.floatValue());
//        }
//    }
}
