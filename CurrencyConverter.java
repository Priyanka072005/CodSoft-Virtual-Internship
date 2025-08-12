package com.task;

import java.util.*;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Double> rates = new HashMap<>();
        rates.put("USD", 1.0);   
        rates.put("INR", 83.0);     
        rates.put("EUR", 0.92);     
        rates.put("JPY", 151.5);    

        System.out.println("--------- Currency Converter ---------");
        System.out.println("Available currencies: USD, INR, EUR, JPY");

        //base currency
        System.out.print("Enter base currency: ");
        String base = sc.next().toUpperCase();

        //target currency
        System.out.print("Enter target currency: ");
        String target = sc.next().toUpperCase();

       
        System.out.print("Enter amount to convert: ");
        double amount = sc.nextDouble();

        //Conversion
        if (rates.containsKey(base) && rates.containsKey(target)) {
            double amountInUSD = amount / rates.get(base);
            double converted = amountInUSD * rates.get(target);
            System.out.printf("Converted Amount: %.2f %s\n", converted, target);
        } else {
            System.out.println("Invalid currency code!");
        }

        sc.close();
    }
}

