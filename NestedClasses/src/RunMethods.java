import StaticNestedClass.Employee;
import StaticNestedClass.EmployeeComparator;
import StaticNestedClass.StoreEmployee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RunMethods {

    public static void main(String[] args) {

        List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(
                new StoreEmployee(10001, "Ralph", 2015, "Target"),
                new StoreEmployee(10005, "Carole", 2021, "Walmart"),
                new StoreEmployee(10022, "Jane", 2013, "Macys"),
                new StoreEmployee(13151, "Laura", 2010, "Walmart"),
                new StoreEmployee(10050, "Jim", 2018,"Target")
        ));

        var c0 = new EmployeeComparator<StoreEmployee>();
        var c1 = new Employee.EmployeeComparator<StoreEmployee>();
        var c2 = new StoreEmployee().new StoreComparator<StoreEmployee>();

        // Using local class
        class NameSort<T> implements Comparator<StoreEmployee> {

            @Override
            public int compare(StoreEmployee o1, StoreEmployee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }

        var c3 = new NameSort<StoreEmployee>();

        // Using anonymous class
        var c4 = new Comparator<StoreEmployee>() {

            @Override
            public int compare(StoreEmployee o1, StoreEmployee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        sortIt(storeEmployees, c0);
        sortIt(storeEmployees, c1);
        sortIt(storeEmployees, c2);
        sortIt(storeEmployees, c3);
        sortIt(storeEmployees, (o1, o2) -> o1.getName().compareTo(o2.getName()));


    }

    public static <T> void sortIt(List<T> list,
                                  Comparator<? super T> comparator) {
        System.out.println("Sorting with Comparator: " + comparator.toString());
        list.sort(comparator);
        for (var employee : list) {
            System.out.println(employee);
        }
    }
}
