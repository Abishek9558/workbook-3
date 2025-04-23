package com.pluralsight;

import java.io.*;
import java.util.*;

public class PayrollCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the employee file to process: ");
        String inputFilePath = scanner.nextLine().trim();

        System.out.print("Enter the name of the payroll file to create: ");
        String outputFilePath = scanner.nextLine().trim();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             PrintWriter writer = new PrintWriter(new FileWriter(outputFilePath))) {

            writer.println("id|name|gross pay");

            String line;
            while ((line = reader.readLine()) != null) {
                String[] items = line.split("\\|");
                if (items.length != 4) continue;// skip lines

                int id = Integer.parseInt(items[0]);
                String name = items[1];
                double hours = Double.parseDouble(items[2]);
                double rate = Double.parseDouble(items[3]);

                Employee employee = new Employee(id, name, hours, rate);

                writer.printf("%d|%s|%.2f%n", employee.getEmployeeId(), employee.getName(), employee.getGrossPay());
            }

            System.out.println("Payroll file ceated: " + outputFilePath);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }









