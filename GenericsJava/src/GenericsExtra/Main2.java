package GenericsExtra;

import java.util.Comparator;
import java.util.List;

public class Main2 {

    public static void main(String[] args) {

        QueryList<LPAStudent> queryList = new QueryList<>();
        for (int i = 0; i < 5; i++) {
            queryList.add(new LPAStudent());
        }

        queryList.sort(Comparator.naturalOrder());
        printList(queryList);

        System.out.println("Matches");
        var matches = queryList.getMatches("PercentComplete", "50");
        matches.sort(new LPAStudentComparator());
        matches.sort(null);
        printList(matches);



    }

    public static void printList(List<?> students) {

        for (var student : students) {
            System.out.println(student);
        }
    }
}
