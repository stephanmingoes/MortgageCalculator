package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        NumberFormat currency = NumberFormat.getCurrencyInstance();
        Scanner scanner = new Scanner(System.in);
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        System.out.print("Principal: ");
        int principal = scanner.nextInt();

        System.out.print("Annual Interest Rate: ");
        float annual_rate = scanner.nextFloat();
        float monthly_rate = annual_rate / PERCENT / MONTHS_IN_YEAR;

        System.out.print("Period (Years): ");
        byte number_of_years = scanner.nextByte();
        int number_of_payments = number_of_years * MONTHS_IN_YEAR;

        double mortgage = principal * (monthly_rate * (Math.pow((1 + monthly_rate), number_of_payments)) / (Math.pow((1+monthly_rate), number_of_payments) - 1));

//        mortgage = (float) Math.round(mortgage * 100) / 100;
        String result = currency.format(mortgage);

        System.out.println("Mortgage: "+ result);
    }
}
