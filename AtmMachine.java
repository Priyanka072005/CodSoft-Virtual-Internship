package com.task;
import java.util.Scanner;

class BankAccount {
	 private double balance;
	
	 public BankAccount(double initialBalance) {
	     this.balance = initialBalance;
	 }
	
	 public double getBalance() {
	     return balance;
	 }
	
	 public void deposit(double amount) {
	     if (amount > 0) {
	         balance += amount;
	         System.out.println("Deposited: $" + amount);
	     } else {
	         System.out.println("Invalid deposit amount!");
	     }
	 }
	
	 public void withdraw(double amount) {
	     if (amount > 0 && amount <= balance) {
	         balance -= amount;
	         System.out.println("Withdraw : $" + amount);
	     } else if (amount > balance) {
	         System.out.println("Insufficient balance!");
	     } else {
	         System.out.println("Invalid withdrawal amount!");
	     }
	 }
}


class ATM {
	 private BankAccount account;
	 private Scanner sc = new Scanner(System.in);
	
	 public ATM(BankAccount account) {
	     this.account = account;
	 }

	 public void start() {
	     while (true) {
	         System.out.println("\n-----------ATM Menu-----------");
	         System.out.println("1. Withdraw");
	         System.out.println("2. Deposit");
	         System.out.println("3. Check Balance");
	         System.out.println("4. Exit");
	         System.out.print("Enter your choice : ");
	
	         int choice = sc.nextInt();
	         switch (choice) {
	             case 1 : withdraw();
	             return;
	             case 2 : deposit();
	             return;
	             case 3 : checkBalance();
	             return;
	            
	             default : System.out.println("Invalid choice! Try again.");
	         }
	     }
	 }
	
	 private void withdraw() {
	     System.out.print("Enter amount to withdraw : ");
	     double amount = sc.nextDouble();
	     account.withdraw(amount);
	 }
	
	 private void deposit() {
	     System.out.print("Enter amount to deposit : ");
	     double amount = sc.nextDouble();
	     account.deposit(amount);
	 }
	
	 private void checkBalance() {
	     System.out.println("Current Balance : $" + account.getBalance());
	 }
}

public class AtmMachine{
 public static void main(String[] args) {
     BankAccount userAccount = new BankAccount(1000); // Initial balance
     ATM atm = new ATM(userAccount);
     atm.start();
 }
}


