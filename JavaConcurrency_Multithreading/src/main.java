import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>(List.of("Nguyen", "Hoang", "Hieu"));

//        for (int i = 0; i < list.size(); i++) {
//            list.set(i, list.get(i).toUpperCase());
//        }
//
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }

        var s = list.stream()
                .map(String::toUpperCase)
                .filter(a -> a.length() >= 5);

        s.forEach(System.out::println);

    }
}
