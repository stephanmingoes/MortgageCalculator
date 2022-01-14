package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {
        NumberFormat currency = NumberFormat.getCurrencyInstance();

        int principal = (int) readNumber("Principal ($1K - $1M): ", 1000, 1000000);
        float AnnualRate = (float)readNumber("Annual Interest Rate: ", 0, 30);
        byte NumberOfYears = (byte) readNumber("Period (Years): ", 0, 30);

        DisplayMortgage(currency, principal, AnnualRate, NumberOfYears);
        PaymentSchedule(currency, principal, AnnualRate, NumberOfYears);
    }

    private static void DisplayMortgage(NumberFormat currency, int principal, float AnnualRate, byte NumberOfYears) {
        double mortgage = calculateMortgage(principal, AnnualRate, NumberOfYears);
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + currency.format(mortgage) );
    }

    private static void PaymentSchedule(NumberFormat currency, int principal, float AnnualRate, byte NumberOfYears) {
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");

        for (short i = 1; i <= NumberOfYears *12; i++ ){
            System.out.println(currency.format(GetBalance(principal, NumberOfYears, AnnualRate, i)));
        }
    }

    public static double GetBalance(int principal,
                                    int NumberOfYears,
                                    float AnnualRate,
                                    short i){
        float MonthlyRate = AnnualRate/ PERCENT / MONTHS_IN_YEAR;

        short NumberOfPayments = (short)(NumberOfYears * MONTHS_IN_YEAR);
        return (principal *
                (Math.pow((1+MonthlyRate),NumberOfPayments ) -
                        Math.pow((1+MonthlyRate), i) )
                /(Math.pow((1+MonthlyRate), NumberOfPayments) - 1));
    }

    public static double readNumber(String prompt, int min, int max){
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextFloat();
            if (value > min && value <= max)
                return value;
            System.out.println("Enter a value between "+min+ " and "+max);
        }

    }

    public static double calculateMortgage(int principal,
                                           float AnnualRate,
                                           byte NumberOfYears){
        float MonthlyRate = AnnualRate/ PERCENT / MONTHS_IN_YEAR;
        short NumberOfPayments = (short)(NumberOfYears * MONTHS_IN_YEAR);

        return principal *
                (MonthlyRate * (Math.pow((1 + MonthlyRate),
                        NumberOfPayments))
                        / (Math.pow((1+MonthlyRate),
                        NumberOfPayments) - 1));
    }
}
