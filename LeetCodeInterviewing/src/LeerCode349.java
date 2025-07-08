import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeerCode349 {

    // INTERSECTION OF TWO ARRAYS


    public static void main(String[] args) {

        int[] num1 = {4, 9, 5};
        int[] num2 = {9,4,9,8,4};
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < num1.length; i++) {
            int key = num1[i];
            for (int j = 0; j < num2.length; j++) {
                if (key == num2[j]) {
                    set.add(key);
                }
            }
        }
        set.forEach(s -> System.out.print(s + " "));
        System.out.println(Arrays.toString(set.toArray()));
    }
}
