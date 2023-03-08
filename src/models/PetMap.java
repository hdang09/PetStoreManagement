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
import java.io.Serializable;
import java.util.TreeMap;
import validate.Input;

/**
 *
 * @author Admin
 */
public class PetMap extends TreeMap<String, Pet> {

    String filePath = "src\\data\\pets.dat";
    File file = new File(filePath);
    Input input = new Input();

    public void add() {
        boolean isContinue;
        do {
            String id = input.id("Input id: ", this);
            String description = input.stringNotEmpty("Input description: ");
            String date = input.date("Input date (MM/dd/yyyy): ");
            int unit = input.number("Input quantity: ");
            Category category = input.category("Input category: ");

            this.put(id, new Pet(description, date, unit, category));

            isContinue = input.yesNo();
        } while (isContinue);
    }
    
    public void search() {
        String id = input.id("Input id: ", this);
        if (this.containsKey(id)) {
            System.out.println(this.get(id));
            return;
        }

        System.err.println("The pet does not exist");
    }

    public void update() {
        String id = input.id("Input id: ", this);

        if (this.containsKey(id)) {
            String description = input.stringNotEmpty("Input description: ");
            String date = input.date("Input date (MM/dd/yyyy): ");
            int unit = input.number("Input quantity: ");
            Category category = input.category("Input category: ");

            this.replace(id, new Pet(description, date, unit, category));
            System.out.println("Updated successfully");
            return;
        }

        System.err.println("The pet does not exist");
    }

    public void delete() {
        String id = input.id("Input id: ", this);

        if (this.containsKey(id)) {
            System.out.println("Do you want to delete this pet? ");
            boolean isDelete = input.yesNo();

            if (!isDelete) {
                return;
            }

            if (this.remove(id) == null) {
                System.err.println("Error in deletion");
                return;
            }

            System.out.println("Delete successfully");
            return;
        }

        System.err.println("The pet does not exist");
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

    public PetMap readFIle() {
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
                if (words.length < 5) {
                    continue;
                }

                String id = words[0].trim();
                String description = words[1].trim();
                String date = words[2].trim();
                int unit = Integer.parseInt(words[3].trim());
                String cate = words[4].trim();

                Category category = null;
                for (Category c : Category.values()) {
                    if (c.equals(cate)) {
                        category = c;
                    }
                }

                Pet pet = new Pet(description, date, unit, category);
                this.put(id, pet);
            }
        } catch (FileNotFoundException ex) {
            System.err.println("FileNotFoundException");
        } catch (IOException ex) {
            System.err.println("IOException");
        }
        return this;
    }

    public void print() {
        this.forEach((k, v) -> System.out.println("Key: " + k + ": Value: " + v));
    }
}
