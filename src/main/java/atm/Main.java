    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATM atm = new ATM();

        System.out.print("Enter Account No: ");
        String accNo = sc.nextLine();
        System.out.print("Enter PIN: ");
        String pin = sc.nextLine();

        Account user = atm.login(accNo, pin);
        if (user == null) {
            System.out.println("Invalid account or PIN!");
            return;
        }

        int choice;
        do {
            System.out.println("\n1. Balance\n2. Deposit\n3. Withdraw\n4. Mini Statement\n5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Balance: " + user.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount: ");
                    user.deposit(sc.nextDouble());
                    break;
                case 3:
                    System.out.print("Enter amount: ");
                    double amt = sc.nextDouble();
                    if (!user.withdraw(amt))
                        System.out.println("Insufficient funds!");
                    break;
                case 4:
                    user.miniStatement();
                    break;
                case 5:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        } while (choice != 5);
    }
}
