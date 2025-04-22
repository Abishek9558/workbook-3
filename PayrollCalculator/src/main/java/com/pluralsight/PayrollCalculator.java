package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PayrollCalculator {
    public static void main(String[] args) {
        String filename = "employees.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split("\\|");
                if (tokens.length != 4) {
                    System.out.println("Invalid: " + line);
                    continue;
                }
                int id = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double hours = Double.parseDouble(tokens[2]);
                double rate = Double.parseDouble(tokens[3]);

                Employee employee = new Employee(id, name, hours, rate);

                System.out.printf(" ID: %d | Name: %s | Gross pay: $%.2f\n",
                        employee.getEmployeeId(),
                        employee.getName(),
                        employee.getGrossPay());
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid numeric format: " + e.getMessage());


        }
    }
}




