package com.bridgelabz.workshopDay3;
import java.time.LocalDate;
import java.util.*;


public class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the checkIntdate  dd-MM-yyyy: ");
        Hotel lakewood = new Hotel();
        lakewood.setName("Lakewood");
        lakewood.setWeekdayRate(110);
        lakewood.setRewardWeekdayRate(80);
        lakewood.setWeekendRate(90);
        lakewood.setRewardWeekendRate(80);
        lakewood.setRating(3);

        Hotel bridgewood = new Hotel();
        bridgewood.setName("Bridgewood");
        bridgewood.setWeekdayRate(160);
        bridgewood.setRewardWeekdayRate(110);
        bridgewood.setWeekendRate(60);
        bridgewood.setRewardWeekendRate(50);
        bridgewood.setRating(4);

        Hotel ridgewood = new Hotel();
        ridgewood.setName("Ridgewood");
        ridgewood.setWeekdayRate(220);
        ridgewood.setRewardWeekdayRate(100);
        ridgewood.setWeekendRate(150);
        ridgewood.setRewardWeekendRate(40);
        ridgewood.setRating(5);

        LocalDate checkInDate = LocalDate.parse(sc.nextLine());
        LocalDate checkOutDate = LocalDate.parse(sc.nextLine());

        //find the cheapest hotel
        Hotel cheapestHotel = Hotel.stream()
                .min(Comparator.comparingInt(Hotel ->));

        // print the cheapest hotel name and cost
        int totalCost = cheapestHotel

        private int calcualateTotalCost (LocalDate -> checkInDate, LocalDate -> checkOutDate){
            int weekdayCount = 0;
            int weekendCount = 0;
            LocalDate date = checkInDate;



            //calculate the number of weekdays and weekend between check-In and Check-Out
            while (!date.isAfter(checkOutDate)) {
                if (date.getDayOfWeek().getValue() >= 1 && date.getDayOfWeek().getValue() < 5) {
                    weekdayCount++;
                } else {
                    weekendCount++;
                }
            }
        }


    }
}
