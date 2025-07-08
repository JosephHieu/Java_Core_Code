package TerminalOperation;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        // Mastering Terminal Operations:
        // Matching And Searching: allMatch, anyMatch, findAny, findAny, noneMatch
        // Transformations and Type Reductions: collect, reduce, toArray, toList
        // Statistical(Numeric) Reductions: average, count, max, min, sum, summaryStatistics
        // Processing: forEach, forEachOrdered

        var result = IntStream
                .iterate(0, i -> i <= 1000, i -> i + 3)
                .summaryStatistics();

        System.out.println("Result = " + result);

        var leapYearData = IntStream
                .iterate(2000, i -> i <= 2025, i -> i + 1)
                .filter(i -> i % 4 == 0)
                .peek(System.out::println)
                .summaryStatistics();

        System.out.println("Leap Year Data = " + leapYearData);

        Seat[] seats = new Seat[100];
        Arrays.setAll(seats, i -> new Seat((char) ('A' + i / 10), i % 10 + 1));
//        Arrays.asList(seats).forEach(System.out::println);

        long reservationCount = Arrays.stream(seats)
                .filter(Seat::isReserved)
                .count();

        System.out.println("reservationCount = " + reservationCount);

        boolean hasBookings = Arrays.stream(seats)
                .anyMatch(Seat::isReserved);
        System.out.println("hasBookings = " + hasBookings);

        boolean fullyBookings = Arrays.stream(seats)
                .allMatch(Seat::isReserved);
        System.out.println("fullyBookings = " + fullyBookings);

        boolean eventWashedOut = Arrays.stream(seats)
                .noneMatch(Seat::isReserved);
        System.out.println("eventWashedOut = " + eventWashedOut);




    }
}
