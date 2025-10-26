package hust.soict.dsai.aims;

import java.util.Scanner;

public class Aims {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cart anOrder = new Cart();

        while (true) {
            System.out.println(" AIMS MENU:");
            System.out.println("1. Add a DVD to the cart");
            System.out.println("2. Remove a DVD from the cart");
            System.out.println("3. Display total cost");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter DVD title: ");
                String title = sc.nextLine();

                System.out.print("Enter category: ");
                String category = sc.nextLine();

                System.out.print("Enter director: ");
                String director = sc.nextLine();

                System.out.print("Enter length (minutes): ");
                int length = sc.nextInt();

                System.out.print("Enter cost: ");
                float cost = sc.nextFloat();

                DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
                anOrder.addDigitalVideoDisc(dvd);

            } else if (choice == 2) {
                System.out.print("Enter the title of DVD to remove: ");
                String title = sc.nextLine();

                DigitalVideoDisc discToRemove = null;
                for (int i = 0; i < anOrder.getQtyOrdered(); i++) {
                    DigitalVideoDisc d = anOrder.getItemsOrdered()[i];
                    if (d.getTitle().equalsIgnoreCase(title)) {
                        discToRemove = d;
                        break;
                    }
                }


                if (discToRemove != null) {
                    anOrder.removeDigitalVideoDisc(discToRemove);
                } else {
                    System.out.println("DVD not found in the cart.");
                }

            } else if (choice == 3) {
                System.out.printf("Total cost: %.2f $\n", anOrder.totalCost());

            } else if (choice == 0) {
                break;

            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        sc.close();
    }
}
