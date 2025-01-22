package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Blender b = new Blender();
        byte[] choice = options(sc, b);
        while (choice[1] != 0) {
            switch (choice[1]) {
                case 1:
                    b.switchPowerStatus();
                    break;
                case 2:
                    b.increaseSpeed();
                    break;
                case 3:
                    b.decreaseSpeed();
                    break;
                case 4:
                    System.out.println("Enter the product you want to fill the blender with: ");
                    String prod = sc.next();
                    System.out.println("Enter the quantity in ml: ");
                    float ml = sc.nextFloat();
                    b.fillBlender(prod, ml);
                    break;
                case 5:
                    b.emptyBlender();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            choice = options(sc, b);
        }
    }

    public static byte[] options(Scanner sc, Blender b) {
        if (b.checkPowerStatus() == 0 || b.checkPowerStatus() == 2) {
            System.out.println("0. Exit");
            System.out.println("1. Switch power status");
            System.out.println("Enter your choice: ");
            return new byte[]{b.checkPowerStatus(), sc.nextByte()};
        } else {
            System.out.println("0. Exit");
            System.out.println("1. Switch power status");
            System.out.println("2. Increase speed");
            System.out.println("3. Decrease speed");
            System.out.println("4. Fill blender");
            System.out.println("5. Empty blender");
            System.out.println("Enter your choice: ");
            return new byte[]{b.checkPowerStatus(), sc.nextByte()};
        }
    }

}