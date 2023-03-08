/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;
import validate.Input;

/**
 *
 * @author Admin
 */
public class OrderMap extends TreeMap<String, Order> {

    Input input = new Input();
    String filePath = "src\\data\\orders.dat";
    File file = new File(filePath);

    public void add(PetMap petMap) {
        boolean isContinue;
        do {
            String id = input.id("Input id: ", this);
            String date = input.date("Input date (MM/dd/yyyy): ");
            String customerName = input.stringNotEmpty("Input customer name: ");
            String petId = input.id("Input pet id: ", petMap);
            int quantity = input.number("Input quantity: ");
            int cost = input.number("Input cost: ");

            this.put(id, new Order(date, customerName, petId, quantity, cost));

            isContinue = input.yesNo();
        } while (isContinue);
    }

    public void print() {
        this.forEach((k, v) -> System.out.println("Key: " + k + ": Value: " + v));
    }

    public void sort() {
        this.forEach((k, v) -> System.out.println("Key: " + k + ": Value: " + v));
    }

    public void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            this.forEach((K, V) -> {
                try {
                    bw.write(K + ", " + V.toFile());
                    bw.newLine();
                } catch (IOException ex) {
                    System.out.println("IOException");
                }
            });
            System.out.println("Write to file successfully!");
        } catch (Exception e) {
            System.err.println("Error while writing to file!");
        }
    }

    public OrderMap readFile() {
        // Create file if it don't exist
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                System.err.println("IOException");
            }
        }

        // Read file
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((line = reader.readLine()) != null) {
                String words[] = line.split(", ");
                if (words.length < 6) {
                    continue;
                }

                String id = words[0].trim();
                String date = words[1].trim();
                String customerName = words[2].trim();
                String petId = words[3].trim();
                int quantity = Integer.parseInt(words[4].trim());
                int cost = Integer.parseInt(words[5].trim());

                Order order = new Order(date, customerName, petId, quantity, cost);
                this.put(id, order);
            }
        } catch (FileNotFoundException ex) {
            System.err.println("FileNotFoundException");
        } catch (IOException ex) {
            System.err.println("IOException");
        }
        return this;
    }
}
