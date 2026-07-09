package com.interview;

import java.time.Duration;

public class NumberToWords {
    private static final String[] UNITS = {
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
            "Seventeen", "Eighteen", "Nineteen"
    };

    private static final String[] TENS = {
            "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    public static String convert(int n) {
        if (n == 0) return "Zero";
        if (n < 0) return "Minus " + convert(-n);

        String current = "";

        if (n >= 1000000000) {
            current = convert(n / 1000000000) + " Billion " + convert(n % 1000000000);
        } else if (n >= 1000000) {
            current = convert(n / 1000000) + " Million " + convert(n % 1000000);
        } else if (n >= 1000) {
            current = convert(n / 1000) + " Thousand " + convert(n % 1000);
        } else if (n >= 100) {
            current = convert(n / 100) + " Hundred " + convert(n % 100);
        } else if (n >= 20) {
            current = TENS[n / 10] + " " + UNITS[n % 10];
        } else {
            current = UNITS[n];
        }

        return current.trim().replaceAll("\\s+", " ");
    }

    public static void main(String[] args) throws InterruptedException {
        int num = 1245786453;
        System.out.println(convert(num)); // Outputs: One Hundred Twenty Three

        while(true){
            Thread.sleep(Duration.ofSeconds(2));
            System.out.println("Tests   ");
            String str = new String("JAva");
        }
    }


}


