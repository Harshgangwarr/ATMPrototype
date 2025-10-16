/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atm;

import java.util.HashMap;
import java.util.Map;

public class ATM {
    private Map<String, Account> accounts;

    public ATM() {
        accounts = new HashMap<>();
        accounts.put("1001", new Account("1001", "Alice", "1234", 1000.0));
        accounts.put("1002", new Account("1002", "Bob", "4321", 500.0));
    }

    public Account login(String accNo, String pin) {
        Account acc = accounts.get(accNo);
        if (acc != null && acc.checkPin(pin)) {
            return acc;
        }
        return null;
    }
}
