package org.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Transaction_parser {
    private static final String COMMA_DELIMITER = ",";
    public static List<Transaction> parseCSV(File file) throws IOException {
        CSVParser parser = new CSVParser(new FileReader(file), CSVFormat.DEFAULT.withDelimiter(','));
        List<Transaction> transactions = new ArrayList<>();
        for (CSVRecord record : parser) {
            transactions.add(new Transaction(record.get(0), record.get(1), record.get(2), ""));
        }
        return transactions;
    }
    public static class Transaction {
        private final String date;
        private final String name;
        private final String amount;
        private final String category;

        public Transaction(String date, String name, String amount, String category) {
            this.date = date;
            this.name = name;
            this.amount = amount;
            this.category = category;
        }

        public String getDate() {
            return date;
        }

        public String getName() {
            return name;
        }

        public String getAmount() {
            return amount;
        }
        public String geteCategory(){
            return category;
        }

    }
}
