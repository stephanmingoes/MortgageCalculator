package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        NumberFormat currency = NumberFormat.getCurrencyInstance();

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        int principal;
        float AnnualRate;
        int NumberOfYears;
        float MonthlyRate;
        int NumberOfPayments;


        while (true) {
            System.out.print("Principal ($1K - $1M): ");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1000000)
                break;
            System.out.println("Enter a number between 1,000 and 1,000,000.");
        }
        while (true) {
            System.out.print("Annual Interest Rate: ");
            AnnualRate = scanner.nextFloat();
            if (AnnualRate > 0 && AnnualRate <= 30){
                MonthlyRate = AnnualRate/ PERCENT / MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value greater than 0 or less than or equal to 30.");
        }
        while (true) {
            System.out.print("Period (Years): ");
            NumberOfYears = scanner.nextInt();
            if (NumberOfYears > 0 && NumberOfYears <=30) {
                NumberOfPayments = NumberOfYears * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30.");
        }

        double mortgage = principal * (MonthlyRate * (Math.pow((1 + MonthlyRate), NumberOfPayments)) / (Math.pow((1+MonthlyRate), NumberOfPayments) - 1));

        System.out.println("Mortgage = " + currency.format(mortgage) );



    }
}
