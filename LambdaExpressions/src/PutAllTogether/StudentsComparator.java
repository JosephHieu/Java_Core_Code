package PutAllTogether;

import java.util.Comparator;

public class StudentsComparator implements Comparator<Students> {
    @Override
    public int compare(Students o1, Students o2) {
        return o1.ten().compareTo(o2.ten());
    }
}
