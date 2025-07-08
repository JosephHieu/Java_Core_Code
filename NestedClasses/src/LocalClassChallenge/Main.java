package LocalClassChallenge;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Employee1 e1 = new Employee1("Minnie", "Mouse", "01/02/2015");
        Employee1 e2 = new Employee1("Mickie", "Mouse", "05/08/2000");
        Employee1 e3 = new Employee1("Daffy", "Duck", "11/02/2011");
        Employee1 e4 = new Employee1("Daisy", "Duck", "05/03/2013");
        Employee1 e5 = new Employee1("Goofy", "Dog", "21/02/2020");

        List<Employee1> list = new ArrayList<>(Arrays.asList(e1, e2, e3, e4, e5));

        printOrderedList(list, "name");
        printOrderedList(list, "year");

    }

    public static void printOrderedList(List<Employee1> eList, String sortField) {

        int currentYear = LocalDate.now().getYear();

        class MyEmployee
        {
            Employee1 containedEmployee;
            int yearsWorked;
            String fullName;

            public MyEmployee(Employee1 containedEmployee) {
                this.containedEmployee = containedEmployee;
                yearsWorked = currentYear - Integer.parseInt(
                        containedEmployee.hireDate().split("/")[2]);
                fullName = String.join(" ",
                        containedEmployee.first(), containedEmployee.last());
            }

            @Override
            public String toString() {
                return "%s has been an employee for %d years".formatted(
                        fullName, yearsWorked);
            }
        }
        List<MyEmployee> list = new ArrayList<>();
        for (Employee1 employee1 : eList) {
            list.add(new MyEmployee(employee1));
        }

        var comparator = new Comparator<MyEmployee>() {

            @Override
            public int compare(MyEmployee o1, MyEmployee o2) {
                if (sortField.equals("name")) {
                    return o1.fullName.compareTo(o2.fullName);
                }
                return o1.yearsWorked - o2.yearsWorked;
            }
        };

        list.sort(comparator);

        list.forEach(System.out::println);
    }
}
