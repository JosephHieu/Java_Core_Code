package TaskAndTaskData;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Set<Task> tasks = TaskData.getTasks("all");
        sortAndPrint("All Tasks", tasks);

        Comparator<Task> sortByPriority = Comparator.comparing(Task::getPriority).reversed();
        Set<Task> annsTasks = TaskData.getTasks("Ann");
        sortAndPrint("Ann's Tasks", annsTasks, sortByPriority);

        Set<Task> bobsTasks = TaskData.getTasks("Bob");
        Set<Task> carolsTasks = TaskData.getTasks("Carol");
        List<Set<Task>> sets = List.of(annsTasks, bobsTasks, carolsTasks);

        Set<Task> assignedTasks = getUnion(sets);
        sortAndPrint("Assigned Tasks", assignedTasks);

        Set<Task> everyTask = getUnion(List.of(tasks, assignedTasks));
        sortAndPrint("The True All Tasks", everyTask);

        Set<Task> missingTasks = getDifference(everyTask, tasks);
        sortAndPrint("Missing Tasks", missingTasks);

        Set<Task> unassignedTasks = getDifference(tasks, assignedTasks);
        sortAndPrint("UnassignedTasks", unassignedTasks);

        Set<Task> overlap = getUnion(List.of(
                getIntersect(annsTasks, bobsTasks),
                getIntersect(carolsTasks, bobsTasks),
                getIntersect(annsTasks, carolsTasks)
        ));
        sortAndPrint("Assigned to Multiples", overlap, sortByPriority);

        List<Task> overlapping = new ArrayList<>();
        for (Set<Task> set : sets) {
            Set<Task> dupes = getIntersect(set, overlap);
            overlapping.addAll(dupes);
        }
        Comparator<Task> priorityNatural = sortByPriority.thenComparing(
                Comparator.naturalOrder());

        sortAndPrint("Overlapping", overlapping, priorityNatural);




    }

    private static Set<Task> getUnion(List<Set<Task>> sets) {

        Set<Task> union = new HashSet<>();
        for (Set<Task> taskSet : sets) {
            union.addAll(taskSet);
        }
        return union;
    }

    private static Set<Task> getIntersect(Set<Task> a, Set<Task> b) {

        Set<Task> intersect = new HashSet<>(a);
        intersect.retainAll(b);
        return intersect;
    }

    private static Set<Task> getDifference(Set<Task> a, Set<Task> b) {

        Set<Task> result = new HashSet<>(a);
        result.removeAll(b);
        return result;
    }

    public static void sortAndPrint(String header, Collection<Task> collection) {
        sortAndPrint(header, collection, null);
    }

    public static void sortAndPrint(String header, Collection<Task> collection,
                                    Comparator<Task> sorter) {

        System.out.println("---".repeat(30));
        System.out.println(header);
        System.out.println("---".repeat(30));

        List<Task> list = new ArrayList<>(collection);
        list.sort(sorter);
        list.forEach(System.out::println);

    }
}
