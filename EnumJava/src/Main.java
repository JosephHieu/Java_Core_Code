import java.util.Random;

public class Main {

    public static void main(String[] args) {

        DayOfWeek weekDay = DayOfWeek.MONDAY;
        System.out.println(weekDay);

        for (int i = 0; i < 10; i++) {
            weekDay = getRandomDay();
//            System.out.printf("Name is %s, Ordinal Value = %d%n",
//                    weekDay.name(), weekDay.ordinal());
//
//            if (weekDay == DayOfWeek.FRIDAY) {
//                System.out.println("Found a Friday!!!");
//            }
            switchDayOfWeek(weekDay);
        }

        var randomDay = getRandomDay();
        System.out.printf("Name is %s, Ordinal value = %d%n",
                randomDay.name(), randomDay.ordinal());

        for (Topping topping : Topping.values()) {
            System.out.println(topping.name() + ": " + topping.getPrice());
        }

    }

    public static void switchDayOfWeek(DayOfWeek weekDay) {

        int weekDayInteger = weekDay.ordinal() + 1;
        switch(weekDay) {
            case WEDNESDAY -> System.out.println("Wed is day" + weekDayInteger);
            case SATURDAY -> System.out.println("Sat is day" + weekDayInteger);
            default -> System.out.println(weekDay.name().charAt(0) +
                    weekDay.name().substring(1).toLowerCase() +
                    "day is Day " + weekDayInteger);
        }

    }

    public static DayOfWeek getRandomDay() {

        int randomInteger = new Random().nextInt(7);
        var allDays = DayOfWeek.values();

        return allDays[randomInteger];
    }
}