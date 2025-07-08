package LinkedListChallenge;

import java.util.ArrayList;
import java.util.LinkedList;

record Place(String name, int distance) {}

public class Main {

    public static void main(String[] args) {

        LinkedList<Place> placesToVisit = new LinkedList<>();
        var a = new ArrayList<String>();

    }

    private static void addPlace(LinkedList<Place> list, Place place) {

        if (list.contains(place)) {
            System.out.println("Found duplicate: " + place);
            return;
        }
        list.add(place);
    }
}
