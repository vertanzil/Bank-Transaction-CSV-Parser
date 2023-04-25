package org.example;
import java.io.*;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import static org.example.Transaction_parser.parseCSV;


public class CSV_Parser {

    public static boolean isDateBetweenTwoDates(LocalDate date, LocalDate startDate, LocalDate endDate) {
        return date.compareTo(startDate) >= 0 && date.compareTo(endDate) <= 0;
    }
    public static void main(String[] args) throws IOException, ParseException {
        // Parse the CSV file
        List<org.example.Transaction_parser.Transaction> transactions = parseCSV(new File("data.csv"));
        DecimalFormat df = new DecimalFormat("0.00");
        Double count = 0.00;
        for (org.example.Transaction_parser.Transaction transaction : transactions) {

            String d1 = transaction.getDate();
            String am1 = transaction.getAmount();
            String Name = transaction.getName();
            Double Amount = Double.parseDouble(am1.replace("-", "").replace(",", ""));


            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String oeStartDateStr = "01/01/2023";
            String oeEndDateStr = "31/01/2023";

            LocalDate today = LocalDate.parse(d1, formatter);
            LocalDate startDate = LocalDate.parse(oeStartDateStr, formatter);
            LocalDate enddate = LocalDate.parse(oeEndDateStr, formatter);



            if (today.isAfter(startDate) && today.isBefore(enddate)){
                    count += Amount;
                    System.out.print(d1 + " " + Name + " " + " " + Amount + System.lineSeparator());
            }


        }
        System.out.print(df.format(count));
    }



     void mainpool(String[] args) throws IOException {
        // Create a CSVParser object
        CSVParser parser = new CSVParser(new FileReader("data.csv"), CSVFormat.DEFAULT.withDelimiter(','));

        // Read the CSV file line by line
        List<CSVRecord> records = new ArrayList<>();
        for (CSVRecord record : parser) {
            records.add(record);
        }

        // Print the data from the CSV file
        for (CSVRecord record : records) {

            String date = record.get(0);
            String name = record.get(1);
            String amount = record.get(2);
            System.out.print(date + " " + " " + name + " " + amount + System.lineSeparator());
        }
    }


}