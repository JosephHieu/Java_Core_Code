package burger;

import StaticNestedClass.Employee;
import StaticNestedClass.StoreEmployee;

import java.util.ArrayList;
import java.util.List;

public class Store {

    public static void main(String[] args) {

        Meal regularMeal = new Meal(0.85);
        regularMeal.addToppings("ketchup", "Mayo", "Bacon");
        System.out.println(regularMeal);

        Meal USRegularMeal = new Meal(0.68);
        System.out.println(USRegularMeal);

        System.out.println("---".repeat(20));




    }


}
