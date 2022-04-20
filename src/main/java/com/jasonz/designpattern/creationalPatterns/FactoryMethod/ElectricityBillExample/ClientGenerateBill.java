package com.jasonz.designpattern.creationalPatterns.FactoryMethod.ElectricityBillExample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClientGenerateBill {

    public static void main(String[] args)
            throws NumberFormatException, IOException {
        GetPlanFactory planFactory = new GetPlanFactory();

        System.out.print("Enter the name of plan for which the bill will be generated: ");

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        int planType = Integer.parseInt(br.readLine());

        System.out.print(
                "Enter the number of units for bill will be calculated: ");

        int units = Integer.parseInt(br.readLine());

        Plan p = planFactory.getPlan(planType);
        // call getRate() method and calculateBill()method of DomesticPaln.

        System.out.print("Bill amount for " + planType + " of  " + units
                + " units is: ");
        p.getRate();
        p.calculateBill(units);

    }

}
