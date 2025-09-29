package T5_BankAccountSimulation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Account> accounts = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Bank Account Simulation ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. View Account Details");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> createAccount();
                case 2 -> depositMoney();
                case 3 -> withdrawMoney();
                case 4 -> checkBalance();
                case 5 -> viewAccountDetails();
                case 6 -> System.out.println("Exiting... Thank you!");
                default -> System.out.println("Invalid choice. Try again!");
            }
        } while (choice != 6);
    }

    private static void createAccount() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Account Holder Name: ");
        String holder = sc.nextLine();
        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        Account account = new Account(accNo, holder, balance);
        accounts.put(accNo, account);
        System.out.println("✅ Account created successfully!");
    }

    private static void depositMoney() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        if (accounts.containsKey(accNo)) {
            System.out.print("Enter Deposit Amount: ");
            double amount = sc.nextDouble();
            accounts.get(accNo).deposit(amount);
        } else {
            System.out.println("Account not found!");
        }
    }

    private static void withdrawMoney() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        if (accounts.containsKey(accNo)) {
            System.out.print("Enter Withdrawal Amount: ");
            double amount = sc.nextDouble();
            accounts.get(accNo).withdraw(amount);
        } else {
            System.out.println("Account not found!");
        }
    }

    private static void checkBalance() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        if (accounts.containsKey(accNo)) {
            System.out.println("Balance: " + accounts.get(accNo).getBalance());
        } else {
            System.out.println("Account not found!");
        }
    }

    private static void viewAccountDetails() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        if (accounts.containsKey(accNo)) {
            System.out.println(accounts.get(accNo));
        } else {
            System.out.println("Account not found!");
        }
    }
}