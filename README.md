# OIBSIP_TASK3
Oasis Infobyte Internship Project

# ATM Interface

This is a simple ATM interface developed as part of the Oasis Infobyte Internship Project. The application allows users to interact with their bank accounts using a command-line interface. Users can create new accounts, log in to existing accounts, and perform various banking operations such as checking their balance, withdrawing, depositing, transferring funds, and viewing transaction history.

Welcome to the ATM Interface! This project is a simple console-based application that simulates an ATM system, allowing users to perform various banking operations such as checking balances, withdrawing funds, depositing funds, transferring money, and viewing transaction history.

## Table of Contents
- [Features](#features)
- [Requirements](#requirements)
- [Setup and Installation](#setup-and-installation)
- [How to Run](#how-to-run)
- [Usage](#usage)
- [Classes and Methods](#classes-and-methods)
- [Acknowledgements](#acknowledgements)

## Features
- User authentication
- Multiple user accounts
- Check balance
- Withdraw funds
- Deposit funds
- Transfer funds between accounts
- View transaction history
- Exit the application

## Requirements
- Java Development Kit (JDK)
- An IDE or text editor for writing and running Java code

## Setup and Installation
1. Ensure you have the Java Development Kit (JDK) installed on your system.
2. Download or clone the project code to your local machine.
3. Open the code in your preferred IDE or text editor.

## How to Run
1. Navigate to the directory containing the project files.
2. Compile the Java files using the following command:
   ```bash
   javac atm/ATM_logic.java
   ```
3. Run the compiled Java program using the following command:
   ```bash
   java atm.ATM_logic
   ```

## Usage
1. **Login**: Enter your User ID and PIN to log in. If you do not have an account, create a new one.
2. **ATM Menu**: After logging in, you will see the ATM menu with the following options:
   - 1. View Balance
   - 2. Withdraw
   - 3. Deposit
   - 4. Transfer
   - 5. Transaction History
   - 6. Quit
3. **Perform Operations**: Choose an option from the menu by entering the corresponding number and follow the prompts to perform the desired operation.
4. **Quit**: To exit the application, choose the "Quit" option from the menu.

## Classes and Methods

### Transaction
- **Transaction(double amount)**: Constructor to initialize transaction amount and timestamp.
- **getAmount()**: Returns the transaction amount.
- **getTimestamp()**: Returns the transaction timestamp.

### Account
- **Account(int accountNumber, int pin, double initialBalance)**: Constructor to initialize account details and initial balance.
- **getAccountNumber()**: Returns the account number.
- **validatePin(int enteredPin)**: Validates the entered PIN.
- **getBalance()**: Returns the current balance.
- **deposit(double amount)**: Deposits the specified amount into the account.
- **withdraw(double amount)**: Withdraws the specified amount from the account.
- **getTransactionHistory()**: Returns the transaction history.

### User
- **User(int userId, int userPin, Account account)**: Constructor to initialize user details and linked account.
- **getUserId()**: Returns the user ID.
- **getUserPin()**: Returns the user PIN.
- **getAccount()**: Returns the linked account.

### ATM_logic
- **ATM_logic()**: Constructor to initialize the list of users.
- **addUser(User user)**: Adds a new user to the ATM system.
- **login(int userId, int pin)**: Authenticates a user based on user ID and PIN.
- **main(String[] args)**: Main method to run the ATM application.

## Acknowledgements
This project was developed as part of the Oasis Infobyte Internship. Special thanks to the team at Oasis Infobyte for providing this opportunity and the necessary guidelines for the project.
