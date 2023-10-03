// Import necessary classes for ArrayList and Scanner
import java.util.ArrayList;
import java.util.Scanner;

// BankAccount class representing a bank account with account number, account holder name, and balance
class BankAccount {
    private int accountNumber; // Private variable to store account number
    private String accountHolderName; // Private variable to store account holder's name
    private double balance; // Private variable to store account balance

    // Constructor to initialize BankAccount object with account number, account holder's name, and initial balance
    public BankAccount(int accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    // Getter method to retrieve account number
    public int getAccountNumber() {
        return accountNumber;
    }

    // Getter method to retrieve account holder's name
    public String getAccountHolderName() {
        return accountHolderName;
    }

    // Getter method to retrieve account balance
    public double getBalance() {
        return balance;
    }

    // Method to deposit funds into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            // Uncomment the following line to display a message when depositing funds
            // System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount."); // Print an error message for invalid deposit amount
        }
    }

    // Method to withdraw funds from the account
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount); // Print a message when withdrawing funds
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance."); // Print an error message for invalid withdrawal
        }
    }

    // Method to transfer funds from this account to another account
    public void transfer(BankAccount recipient, double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            recipient.deposit(amount); // Deposit the transferred amount into the recipient's account
            System.out.println("Transferred: $" + amount); // Print a message when transferring funds
        } else {
            System.out.println("Invalid transfer amount or insufficient balance."); // Print an error message for invalid transfer
        }
    }

    // Method to check and display the account balance
    public void checkBalance() {
        System.out.println("Account Balance for " + accountHolderName + ": $" + balance);
    }
}

// Main class for the banking application
public class BankThing {
    private static ArrayList<BankAccount> accounts = new ArrayList<>(); // ArrayList to store BankAccount objects
    private static int accountNumberGenerator = 1000; // Variable to generate unique account numbers

    // Main method representing the entry point of the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner object to take user input

        // Menu-driven loop for user interaction
        while (true) {
            System.out.println("Personal Banking Application");
            System.out.println("1. Create New Account");
            System.out.println("2. Deposit Funds");
            System.out.println("3. Withdraw Funds");
            System.out.println("4. Transfer Funds");
            System.out.println("5. Check Balance");
            System.out.println("6. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt(); // Read user's choice from the console input

            // Switch statement to handle user's choice
            switch (choice) {
                case 1:
                    createAccount(scanner); // Call createAccount method when user chooses option 1
                    break;
                case 2:
                    depositFunds(scanner); // Call depositFunds method when user chooses option 2
                    break;
                case 3:
                    withdrawFunds(scanner); // Call withdrawFunds method when user chooses option 3
                    break;
                case 4:
                    transferFunds(scanner); // Call transferFunds method when user chooses option 4
                    break;
                case 5:
                    checkBalance(scanner); // Call checkBalance method when user chooses option 5
                    break;
                case 6:
                    System.out.println("Exiting the application."); // Display a message and exit the program when user chooses option 6
                    scanner.close(); // Close the scanner
                    System.exit(0); // Terminate the program
                default:
                    System.out.println("Invalid choice. Please try again."); // Print an error message for invalid choices
            }
        }
    }

    // Method to create a new bank account
    private static void createAccount(Scanner scanner) {
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter the account holder's name: ");
        String accountHolderName = scanner.nextLine(); // Read account holder's name from the console input
        System.out.print("Enter the initial balance: $");
        double initialBalance = scanner.nextDouble(); // Read initial balance from the console input

        int accountNumber = accountNumberGenerator++; // Generate a unique account number
        BankAccount account = new BankAccount(accountNumber, accountHolderName, initialBalance); // Create a new BankAccount object
        accounts.add(account); // Add the account to the accounts ArrayList

        System.out.println("Account created successfully. Account number: " + accountNumber); // Print a success message with the account number
    }

    // Method to find a bank account by its account number
    private static BankAccount findAccountByNumber(int accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account; // Return the account if found
            }
        }
        return null; // Return null if account not found
    }

    // Method to deposit funds into a bank account
    private static void depositFunds(Scanner scanner) {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt(); // Read account number from the console input
        BankAccount account = findAccountByNumber(accountNumber); // Find the account by its account number

        if (account != null) {
            System.out.print("Enter deposit amount: $");
            double amount = scanner.nextDouble(); // Read deposit amount from the console input
            account.deposit(amount); // Call the deposit method of the found account
            System.out.println("New Account Balance for " + account.getAccountHolderName() + ": $" + account.getBalance()); // Display the balance of the account after a deposit
        } else {
            System.out.println("Account not found."); // Print an error message if the account is not found
        }
    }

    // Method to withdraw funds from a bank account
    private static void withdrawFunds(Scanner scanner) {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt(); // Read account number from the console input
        BankAccount account = findAccountByNumber(accountNumber); // Find the account by its account number

        if (account != null) {
            System.out.print("Enter withdrawal amount: $");
            double amount = scanner.nextDouble(); // Read withdrawal amount from the console input
            account.withdraw(amount); // Call the withdraw method of the found account
            System.out.println("New Account Balance for " + account.getAccountHolderName() + ": $" + account.getBalance()); // Display the balance of the account after a withdrawal
        } else {
            System.out.println("Account not found."); // Print an error message if the account is not found
        }
    }

    // Method to transfer funds from one bank account to another
    private static void transferFunds(Scanner scanner) {
        System.out.print("Enter sender account number: ");
        int senderAccountNumber = scanner.nextInt(); // Read sender's account number from the console input
        BankAccount senderAccount = findAccountByNumber(senderAccountNumber); // Find the sender's account

        if (senderAccount != null) {
            System.out.print("Enter recipient account number: ");
            int recipientAccountNumber = scanner.nextInt(); // Read recipient's account number from the console input
            BankAccount recipientAccount = findAccountByNumber(recipientAccountNumber); // Find the recipient's account

            if (recipientAccount != null) {
                System.out.print("Enter transfer amount: $");
                double amount = scanner.nextDouble(); // Read transfer amount from the console input
                senderAccount.transfer(recipientAccount, amount); // Call the transfer method to transfer funds
                System.out.println("New Account Balance for " + recipientAccount.getAccountHolderName() + ": $" + recipientAccount.getBalance());
                System.out.println("New Account Balance for " + senderAccount.getAccountHolderName() + ": $" + senderAccount.getBalance());
            } else {
                System.out.println("Recipient account not found."); // Print an error message if the recipient's account is not found
            }
        } else {
            System.out.println("Sender account not found."); // Print an error message if the sender's account is not found
        }
    }

    // Method to check and display the account balance
    private static void checkBalance(Scanner scanner) {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt(); // Read account number from the console input
        BankAccount account = findAccountByNumber(accountNumber); // Find the account by its account number

        if (account != null) {
            account.checkBalance(); // Call the checkBalance method of the found account
        } else {
            System.out.println("Account not found."); // Print an error message if the account is not found
        }
    }
}
