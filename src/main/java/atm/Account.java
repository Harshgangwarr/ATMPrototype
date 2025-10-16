/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atm;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accNo;
    private String name;
    private String pin;
    private double balance;
    private List<String> history;

    public Account(String accNo, String name, String pin, double balance) {
        this.accNo = accNo;
        this.name = name;
        this.pin = pin;
        this.balance = balance;
        this.history = new ArrayList<>();
    }

    public boolean checkPin(String pinInput) {
        return this.pin.equals(pinInput);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            history.add("Deposited: " + amount);
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            history.add("Withdrew: " + amount);
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }

    public void miniStatement() {
        System.out.println("--- Mini Statement ---");
        int start = Math.max(history.size() - 5, 0);
        for (int i = start; i < history.size(); i++) {
            System.out.println(history.get(i));
        }
    }

    public String getAccNo() { return accNo; }
    public String getName() { return name; }
}
