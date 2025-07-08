package StaticNestedClass;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>(List.of(
                new Employee(10001, "Ralph", 2015),
                new Employee(10005, "Carole", 2021),
                new Employee(10022, "Jane", 2013),
                new Employee(13151, "Laura", 2010),
                new Employee(10050, "Jim", 2018)
        ));

        employees.sort(new Employee.EmployeeComparator<>("yearStarted")
                .reversed());

        employees.forEach(System.out::println);

        System.out.println("--".repeat(20));
        System.out.println("Store Members");

        List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(
                new StoreEmployee(10001, "Ralph", 2015, "Target"),
                new StoreEmployee(10005, "Carole", 2021, "Walmart"),
                new StoreEmployee(10022, "Jane", 2013, "Macys"),
                new StoreEmployee(13151, "Laura", 2010, "Walmart"),
                new StoreEmployee(10050, "Jim", 2018,"Target")
        ));

        var comparator = new StoreEmployee.EmployeeComparator<>();
        storeEmployees.sort(comparator);

        var genericEmployee = new StoreEmployee();
        var comparator2 = genericEmployee.new StoreComparator<>();
        storeEmployees.sort(comparator2);

        storeEmployees.forEach(System.out::println);


        addPigLatinName(storeEmployees);


    }

    public static void addPigLatinName(List<? extends StoreEmployee> list) {

        String lastName = "Piggy";

        class DecoratedEmployee extends StoreEmployee
                implements Comparable<DecoratedEmployee>
        {

            private String pigLatinName;
            private Employee orginalInstance;

            public DecoratedEmployee(String pigLatinName, Employee orginalInstance) {
                this.pigLatinName = pigLatinName + " " + lastName;
                this.orginalInstance = orginalInstance;
            }

            @Override
            public String toString() {
                return orginalInstance.toString() + "  " + pigLatinName;
            }

            @Override
            public int compareTo(DecoratedEmployee o) {
                return pigLatinName.compareTo(o.pigLatinName);
            }
        }

        List<DecoratedEmployee> newList = new ArrayList<>(list.size());

        for (var employee : list) {
            String name = employee.getName();
            String pigLation = name.substring(1) + name.charAt(0) + "ay";
            newList.add(new DecoratedEmployee(pigLation, employee));
        }

        newList.sort(null);
        for (var dEmployee : newList) {
            System.out.println(dEmployee.orginalInstance.getName() +
                    dEmployee.pigLatinName);
        }
    }
}
