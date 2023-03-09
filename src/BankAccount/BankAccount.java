package BankAccount;

import java.util.Scanner;

public class BankAccount {

    private String name;
    private double balance;
    private String customerID;
    private double previousTransaction;

    public BankAccount(String name, String customerID) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank!");
        }
        if (customerID == null || customerID.isBlank()) {
            throw new IllegalArgumentException("Customer ID cannot be null or blank!");
        }
        this.name = name;
        this.balance = balance;
        this.customerID = customerID;
    }


//    getters & setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

//------------------------------------------------------------------------

    public void deposit (double amount) {
        if (amount > 0) {
            balance += amount;
            previousTransaction = amount;
        }
    }

    public void withdraw (double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            previousTransaction = -amount;
        } else
        {
            System.out.println("Insufficient balance!");
        }
    }

    public void showPreviousTransaction () {
        if (previousTransaction > 0) {
            System.out.println("You have deposited -> " + previousTransaction + "$.");
        }else if (previousTransaction < 0) {
            System.out.println("You have withdrawn -> " + previousTransaction + "$.");
        }else {
            System.out.println("There is no previous transaction!");
        }
    }


    public void userMenu () {
        Scanner scanner = new Scanner(System.in);
        String option = "a";

        System.out.println("Welcome " + this.name + "!" + "\n" + "ID: " + this.customerID + "\n");
        System.out.println("Press 'a' to check your deposit.");
        System.out.println("Press 'b' to deposit an amount.");
        System.out.println("Press 'c' to withdraw an amount.");
        System.out.println("Press 'd' to to see the previous transaction.");
        System.out.println("Press 'e' to exit.");


        while(!option.equals("e")) {
            System.out.println("************************");
            System.out.println("Choose an action.");
            option = scanner.nextLine();

            switch (option) {
                case "a":
                    System.out.println("Your balance is: " + this.balance + " $" + "\n");
                    break;

                case "b": {
                    System.out.println("Enter an amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine();
                    deposit(depositAmount);
                    System.out.println("\n");
                    break;
                }

                case "c": {
                    System.out.println("Enter an amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine();
                    withdraw(withdrawAmount);
                    System.out.println("\n");
                    break;
                }

                case "d": {
                    System.out.println("Previous transaction: ");
                    showPreviousTransaction();
                    System.out.println("\n");
                    break;
                }

                case "e":
                    System.out.println("******************" + "\n");
                    break;

                default:
                    System.out.println("Please enter a valid option: ");

            }
        }
        System.out.println("****END****");
    }
}
