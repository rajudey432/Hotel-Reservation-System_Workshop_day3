package com.bridgelabz.reviewDay3;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Hotel rates and ratings
        Map<String, Hotel> hotels = new HashMap<>();
        hotels.put("Lakewood", new Hotel(3, 110, 80, 90, 80));
        hotels.put("Bridgewood", new Hotel(4, 160, 110, 60, 50));
        hotels.put("Ridgewood", new Hotel(5, 220, 100, 150, 40));

        // Input from the user
        System.out.println("Enter the customer type (Regular/Rewards):");
        String customerType = scanner.nextLine();

        System.out.println("Enter the check-in date (DD-MM-YYYY):");
        String checkInDateStr = scanner.nextLine();
        LocalDate checkInDate = LocalDate.parse(checkInDateStr, DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        System.out.println("Enter the check-out date (DD-MM-YYYY):");
        String checkOutDateStr = scanner.nextLine();
        LocalDate checkOutDate = LocalDate.parse(checkOutDateStr, DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        scanner.close();

        // Calculate the number of weekdays and weekend days
        int weekdays = (int) checkInDate.datesUntil(checkOutDate.plusDays(1))
                .filter(date -> date.getDayOfWeek() != DayOfWeek.SATURDAY && date.getDayOfWeek() != DayOfWeek.SUNDAY)
                .count();

        int weekends = (int) checkInDate.datesUntil(checkOutDate.plusDays(1))
                .filter(date -> date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY)
                .count();

        // Find the hotel with the cheapest rate
        String cheapestHotel = hotels.entrySet().stream()
                .min(Comparator.comparingInt(entry -> entry.getValue().calculateTotalRate(weekdays, weekends, customerType.equals("Rewards"))))
                .map(Map.Entry::getKey)
                .orElse("");

        // Output the result
        System.out.println("Cheapest hotel: " + cheapestHotel);
    }
}
