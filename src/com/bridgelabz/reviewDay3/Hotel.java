package com.bridgelabz.reviewDay3;

    class Hotel {
        private int rating;
        private int weekdayRateRegular;
        private int weekdayRateRewards;
        private int weekendRateRegular;
        private int weekendRateRewards;

        public Hotel(int rating, int weekdayRateRegular, int weekdayRateRewards,
                     int weekendRateRegular, int weekendRateRewards) {
            this.rating = rating;
            this.weekdayRateRegular = weekdayRateRegular;
            this.weekdayRateRewards = weekdayRateRewards;
            this.weekendRateRegular = weekendRateRegular;
            this.weekendRateRewards = weekendRateRewards;
        }

        public int calculateTotalRate(int weekdays, int weekends, boolean isRewardsCustomer) {
            int totalRate = weekdayRateRegular * weekdays + weekendRateRegular * weekends;

            if (isRewardsCustomer) {
                totalRate = Math.min(totalRate, weekdayRateRewards * weekdays + weekendRateRewards * weekends);
            }

            return totalRate;
        }
    }
