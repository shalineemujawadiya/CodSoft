import java.util.Scanner;

// BankAccount class to represent the user's bank account
class BankAccount {
    private double balance; // To store the account balance

    // Constructor to initialize the balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Successfully deposited $%.2f\n", amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount;
                System.out.printf("Successfully withdrawn $%.2f\n", amount);
            } else {
                System.out.println("Insufficient funds. Withdrawal failed.");
            }
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    // Method to check the current balance
    public double checkBalance() {
        return balance;
    }
}

// ATM class to provide the user interface and operations
public class ATM {
    private BankAccount account;
    private Scanner scanner;

    // Constructor to initialize the ATM with a bank account
    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    // Method to display the ATM menu and handle user choices
    public void run() {
        int choice;
        do {
            displayMenu();
            choice = getUserChoice();
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Exiting ATM. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 4);
    }

    // Method to display the ATM menu
    private void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    // Method to get user choice from the menu
    private int getUserChoice() {
        System.out.print("Enter your choice: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            scanner.next(); // Clear invalid input
        }
        return scanner.nextInt();
    }

    // Method to handle checking balance operation
    private void checkBalance() {
        double balance = account.checkBalance();
        System.out.printf("Current Balance: $%.2f\n", balance);
    }

    // Method to handle deposit operation
    private void deposit() {
        System.out.print("Enter deposit amount: $");
        double amount = getValidAmount();
        account.deposit(amount);
    }

    // Method to handle withdraw operation
    private void withdraw() {
        System.out.print("Enter withdrawal amount: $");
        double amount = getValidAmount();
        account.withdraw(amount);
    }

    // Method to validate and retrieve a valid amount from user input
    private double getValidAmount() {
        double amount = 0;
        while (true) {
            if (scanner.hasNextDouble()) {
                amount = scanner.nextDouble();
                if (amount > 0) {
                    break;
                } else {
                    System.out.print("Amount must be positive. Enter again: $");
                }
            } else {
                System.out.print("Invalid input. Enter a valid amount: $");
                scanner.next(); // Clear invalid input
            }
        }
        return amount;
    }

    // Close scanner when done
    public void closeScanner() {
        scanner.close();
    }

    // Main method to start the ATM application
    public static void main(String[] args) {
        // Create a bank account with initial balance
        BankAccount bankAccount = new BankAccount(1000.0);

        // Create an ATM instance with the bank account
        ATM atm = new ATM(bankAccount);

        // Run the ATM
        atm.run();

        // Close scanner
        atm.closeScanner();
    }
}
