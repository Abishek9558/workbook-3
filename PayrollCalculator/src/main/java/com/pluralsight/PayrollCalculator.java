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

        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
                FileWriter fw = new FileWriter(outputFilePath);
                BufferedWriter bufWriter = new BufferedWriter(fw)
        ) {

            bufWriter.write("id|name|gross pay");
            bufWriter.newLine();

            BufferedReader readar;
            reader.readLine();


            String line;
            while ((line = reader.readLine()) != null) {
                String[] items = line.split("\\|");
                if (items.length != 4) continue;// skip lines

                try {
                    int id = Integer.parseInt(items[0]);
                    String name = items[1];
                    double hours = Double.parseDouble(items[2]);
                    double rate = Double.parseDouble(items[3]);

                    Employee employee = new Employee(id, name, hours, rate);

                    String outputLine = String.format("%d|%s|%.2f",
                            employee.getEmployeeId(),
                            employee.getName(),
                            employee.getGrossPay());

                    bufWriter.write(outputLine);
                    bufWriter.newLine();

                } catch (NumberFormatException e) {
                    System.err.println("Skipping invalid numeric line: " + line);
                }
            }
            bufWriter.flush();
            System.out.println("Payroll file created: " + outputFilePath);

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}










