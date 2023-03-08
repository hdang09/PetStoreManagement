/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package menu;

import models.OrderMap;
import models.PetMap;
import validate.Input;

/**
 *
 * @author Admin
 */
public class Main {

    static Input input = new Input();
    static PetMap petMap = new PetMap().readFIle();
    static OrderMap orderMap = new OrderMap().readFile();

    public static void main(String[] args) {
        boolean isContinue = true;
        do {
            System.out.println();
            System.out.println("----------- PET STORE MANAGEMENT -----------");
            System.out.println("| 1. Add a pet                             |");
            System.out.println("| 2. Find a pet                            |");
            System.out.println("| 3. Update a pet                          |");
            System.out.println("| 4. Delete a pet                          |");
            System.out.println("| 5. Add an order                          |");
            System.out.println("| 6. List orders                           |");
            System.out.println("| 7. Sort orders                           |");
            System.out.println("| 8. Save data                             |");
            System.out.println("| 9. Load data                             |");
            System.out.println("| 10. Quit                                 |");
            System.out.println("| Others- Quit                             |");
            System.out.println("--------------------------------------------");
            System.out.println();

            int choice = input.number("Your choice: ");
            switch (choice) {
                case 1 -> petMap.add();
                case 2 -> petMap.search();
                case 3 -> petMap.saveToFile();
                case 4 -> petMap.delete();
                case 5 -> orderMap.add(petMap);
                case 6 -> orderMap.print();
                case 7 -> orderMap.sort();
                case 8 -> {
                    petMap.saveToFile();
                    orderMap.saveToFile();
                }
                case 9 -> {
                    petMap.print();
                    orderMap.print();
                }
                default -> {
                    System.out.println("Good bye! Have a nice day!");
                    isContinue = false;
                }
            }
        } while (isContinue);
    }

}
