/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Pattern;
import models.Category;

public class Input {

    Scanner sc = new Scanner(System.in).useDelimiter("\n");
    boolean wrong;
    String customerIDRegex = "[C]{1}\\d{3}";

    // String can be empty
    public String string(String message) {
        System.out.print(message);
        String string = sc.next().trim().replaceAll(",", "|");

        return string;
    }

    // String can NOT be empty
    public String stringNotEmpty(String message) {
        do {
            wrong = true;

            System.out.print(message);
            String string = sc.next().trim().replaceAll(",", "|");

            if (!string.isBlank()) {
                return string;
            }

            System.err.println("Fields do not allow to contain null value");
        } while (wrong);

        return "";
    }

    public int number(String message) {
        String numberRegex = "^\\d+$";
        do {
            wrong = true;
            System.out.print(message);
            String choice = sc.next().trim().replaceAll(",", "|");

            if (Pattern.matches(numberRegex, choice)) {
                return Integer.parseInt(choice);
            }

            System.err.println("Please input a number!");
        } while (wrong);

        return 0;
    }

    public int number(String message, int max) {
        String numberRegex = "^\\d+$";
        do {
            wrong = true;
            System.out.print(message);
            String choice = sc.next().trim().replaceAll(",", "|");
            int number;

            try {
                number = Integer.parseInt(choice);

                if (number > max) {
                    System.err.println("Invalid! The number must smaller or equal to " + max);
                    continue;
                }

                if (Pattern.matches(numberRegex, choice)) {
                    return Integer.parseInt(choice);
                }

                System.err.println("Please input a number!");
            } catch (NumberFormatException e) {
                System.err.println("Please input a number!");
            }

        } while (wrong);

        return 0;
    }

    public String id(String message, TreeMap PetMap) {
        do {
            System.out.print(message);
            String id = sc.next().trim().replaceAll(",", "|");

            wrong = PetMap.containsKey(id);

            if (!wrong) {
                return id;
            }

            System.err.println("The id fields must be unique");
        } while (wrong);
        return "";
    }

    public Category category(String message) {
        do {
            System.out.println(message);
            int i = 1;
            for (Category category : Category.values()) {
                System.out.println(Integer.toString(i) + ". " + category);
                i++;
            }
            int choice = number("Your choice: ", 3);
            switch (choice) {
                case 1 -> {
                    return Category.Cat;
                }
                case 2 -> {
                    return Category.Dog;
                }
                case 3 -> {
                    return Category.Parrot;
                }
                default -> {
                    System.err.println("Invalid! Please try again");
                    wrong = true;
                }
            }

        } while (wrong);
        return null;
    }

    public boolean yesNo() {
        do {
            wrong = true;
            System.out.print("Your choice (Y/N): ");
            String choice = sc.next().toUpperCase().trim().replaceAll(",", "|");

            if (choice.isBlank()) {
                return false;
            }
            if (choice.equals("Y")) {
                return true;
            }
            if (choice.equals("N")) {
                return false;
            }

            System.err.println("Wrong input, please type again!");
        } while (wrong);

        return false;
    }

    public String date(String message) {
        do {
            wrong = true;
            System.out.print(message);
            String date = sc.next().trim().replaceAll(",", "|");

            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            sdf.setLenient(false);
            try {
                sdf.parse(date);
                return date;
            } catch (ParseException e) {
                System.err.println("Wrnng input! Please type again!");
            }

        } while (wrong);

        return "";
    }
}
