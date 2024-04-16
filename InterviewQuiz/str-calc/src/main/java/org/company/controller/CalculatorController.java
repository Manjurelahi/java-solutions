package org.company.controller;


import org.company.service.CalculatorService;

import java.util.Scanner;

public class CalculatorController {
    private CalculatorService calcService;

    public CalculatorController () {
        calcService = new CalculatorService();
    }


    private void performCalcService(String userOption) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        switch (userOption) {
            case "1":
                System.out.println("\n\nPlease enter string of numbers.");
                input = scanner.nextLine();
                System.out.println("\nInput: "+input);
                System.out.println("Output: "+calcService.add(input));
                break;

            case "2":
                System.out.println("\n\nHelp Notes");
                System.out.println("1. Default delimiter is comma.");
                System.out.println("2. To change delimiter, begin string like below:");
                System.out.println("//[delimiter]\\n[numbers...]");
                break;

            case "3":
                return;

            default:
                System.out.println("Invalid Option");
        }
    }

    private String displayCalcServices() {
        System.out.println("\nPlease choose and enter:");
        System.out.println("1: Add\n2: Help\n3: Close\n");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void main(String[] args) {
        CalculatorController calcController = new CalculatorController();
        System.out.println("\nIncubyte TDD Assessment - String Calculator");
        boolean close = false;
        while (!close) {
            String userOption = calcController.displayCalcServices();
            if ("3".equals(userOption)) {
                close = true;
            }
            calcController.performCalcService(userOption);
        }
    }
}
