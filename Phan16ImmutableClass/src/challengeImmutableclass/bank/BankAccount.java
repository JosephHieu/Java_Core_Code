package challengeImmutableclass.bank;

import challengeImmutableclass.dto.Transaction;

import java.util.LinkedHashMap;
import java.util.Map;

public class BankAccount {

    public enum AccountType {CHECKING, SAVING}

    private final AccountType accountType;
    private double balance;
    private final Map<Long, Transaction> transactions = new LinkedHashMap<>();

    BankAccount(AccountType accountType, double balance) {
        this.accountType = accountType;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public Map<Long, Transaction> getTransactions() {
        return Map.copyOf(transactions);
    }

    @Override
    public String toString() {
        return "%s $%.2f".formatted(accountType, balance);
    }

    void commitTransaction(int routingNumber, long transactionId,
                           String customerId, double amount) {
        balance += amount;
        transactions.put(transactionId,
                new Transaction(routingNumber, transactionId,
                        Integer.parseInt(customerId), amount));
    }


}
