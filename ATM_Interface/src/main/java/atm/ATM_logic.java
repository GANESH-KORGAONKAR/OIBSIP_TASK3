package atm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

// Transaction class to store transaction details
class Transaction {
    private double amount;
    private Date timestamp;

    // Constructor to initialize transaction amount and timestamp
    public Transaction(double amount) {
        this.amount = amount;
        this.timestamp = new Date();
    }

    // Getter method to retrieve the transaction amount
    public double getAmount() {
        return amount;
    }

    // Getter method to retrieve the transaction timestamp
    public Date getTimestamp() {
        return timestamp;
    }
}

// Account class to manage account details and transactions
class Account {
    private int accountNumber;
    private int pin;
    private double balance;
    private List<Transaction> transactionHistory;

    // Constructor to initialize account details and initial balance
    public Account(int accountNumber, int pin, double initialBalance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    // Getter method to retrieve the account number
    public int getAccountNumber() {
        return accountNumber;
    }

    // Method to validate the entered PIN with the account PIN
    public boolean validatePin(int enteredPin) {
        return pin == enteredPin;
    }

    // Getter method to retrieve the current balance
    public double getBalance() {
        return balance;
    }

    // Method to deposit an amount into the account
    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add(new Transaction(amount));
    }

    // Method to withdraw an amount from the account
    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactionHistory.add(new Transaction(-amount));
            return true;
        } else {
            return false;
        }
    }

    // Method to retrieve the transaction history
    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }
}

// User class to manage user details and linked account
class User {
    private int userId;
    private int userPin;
    private Account account;

    // Constructor to initialize user details and linked account
    public User(int userId, int userPin, Account account) {
        this.userId = userId;
        this.userPin = userPin;
        this.account = account;
    }

    // Getter method to retrieve the user ID
    public int getUserId() {
        return userId;
    }

    // Getter method to retrieve the user PIN
    public int getUserPin() {
        return userPin;
    }

    // Getter method to retrieve the linked account
    public Account getAccount() {
        return account;
    }
}

// ATM_logic class to manage ATM operations and user interactions
public class ATM_logic {
    private List<User> users;

    // Constructor to initialize the list of users
    public ATM_logic() {
        this.users = new ArrayList<>();
    }

    // Method to add a new user to the ATM system
    public void addUser(User user) {
        users.add(user);
    }

    // Method to authenticate a user based on user ID and PIN
    public User login(int userId, int pin) {
        for (User user : users) {
            if (user.getUserId() == userId && user.getUserPin() == pin) {
                return user;
            }
        }
        return null;
    }

    // Main method to run the ATM application
    public static void main(String[] args) {
        ATM_logic atm = new ATM_logic();
        
        // Creating and adding users to the ATM system
        Account account1 = new Account(10001, 1010, 100500.0);
        User user1 = new User(101, 1010, account1);
        atm.addUser(user1);
        
        Account account2 = new Account(10002, 2020, 200000.0);
        User user2 = new User(102, 2020, account2);
        atm.addUser(user2);
        
        Account account3 = new Account(10003, 3030, 500200.0);
        User user3 = new User(103, 3030, account3);
        atm.addUser(user3);
        
        Account account4 = new Account(10004, 4040, 400030.0);
        User user4 = new User(104, 4040, account4);
        atm.addUser(user4);
        
        Account account5 = new Account(10005, 5050, 150000.0);
        User user5 = new User(105, 5050, account5);
        atm.addUser(user5);

        Scanner scanner = new Scanner(System.in);
        User currentUser = null;

        // User login loop
        while (true) {
            System.out.println("Welcome to the ATM! STATE BANK OF INDIA");
            System.out.print("Enter your User ID: ");
            int userId = scanner.nextInt();
            System.out.print("Enter your PIN: ");
            int pin = scanner.nextInt();

            currentUser = atm.login(userId, pin);

            if (currentUser != null) {
                break;
            } else {
                System.out.println("Invalid User ID or PIN. Try again.");
            }
        }

        // ATM menu loop
        while (true) {
            System.out.println("ATM Menu:");
            System.out.println("1. View Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Transaction History");
            System.out.println("6. Quit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // View balance
                    System.out.println("Your balance is: $" + currentUser.getAccount().getBalance());
                    break;

                case 2:
                    // Withdraw amount
                    System.out.print("Enter the amount to withdraw: $");
                    double withdrawAmount = scanner.nextDouble();
                    boolean success = currentUser.getAccount().withdraw(withdrawAmount);
                    if (success) {
                        System.out.println("Withdrawal successful.");
                    } else {
                        System.out.println("Insufficient funds.");
                    }
                    break;

                case 3:
                    // Deposit amount
                    System.out.print("Enter the amount to deposit: $");
                    double depositAmount = scanner.nextDouble();
                    currentUser.getAccount().deposit(depositAmount);
                    System.out.println("Deposit successful.");
                    break;

                case 4:
                    // Transfer amount to another account
                    System.out.print("Enter the recipient's account number: ");
                    int recipientAccountNumber = scanner.nextInt();
                    User recipientUser = null;
                    for (User user : atm.users) {
                        if (user.getAccount().getAccountNumber() == recipientAccountNumber) {
                            recipientUser = user;
                            break;
                        }
                    }

                    if (recipientUser != null) {
                        System.out.print("Enter the amount to transfer: $");
                        double transferAmount = scanner.nextDouble();
                        if (currentUser.getAccount().withdraw(transferAmount)) {
                            recipientUser.getAccount().deposit(transferAmount);
                            System.out.println("Transfer successful.");
                        } else {
                            System.out.println("Insufficient funds for the transfer.");
                        }
                    } else {
                        System.out.println("Recipient account not found.");
                    }
                    break;

                case 5:
                    // View transaction history
                    List<Transaction> transactions = currentUser.getAccount().getTransactionHistory();
                    System.out.println("Transaction History:");
                    for (Transaction transaction : transactions) {
                        System.out.println("Date: " + transaction.getTimestamp() + ", Amount: $" + transaction.getAmount());
                    }
                    break;

                case 6:
                    // Quit the application
                    System.out.println("Thank you for using the ATM. Have a Good Day!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
