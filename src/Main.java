import BankAccount.BankAccount;

import java.sql.SQLOutput;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name and customer ID to gain access.");
        String name = scanner.nextLine();
        String customerID = scanner.nextLine();

        BankAccount user = new BankAccount(name,customerID);
        user.userMenu();
    }
}