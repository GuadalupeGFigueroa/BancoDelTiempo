package dev.guadalupe.bancodeltiempo.account;

import org.hibernate.mapping.List;

public class Account {
    private long id;
    private String owner; //Relacion con User
    private double balance; //Saldo de KairosCoin
    private List<Transaction> transactions; //Relacion con Transaction

    public void updateBalance(int amount);
    public void recordTransaction(Transaction transaction);
    public void printAccountDetails();
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public List<Transaction> getTransactions() {
        return transactions;
    }
    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    

}
