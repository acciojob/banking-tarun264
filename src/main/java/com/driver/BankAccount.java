package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name,double balance,double minBalance) {
        this.name=name;
        this.balance=balance;
        this.minBalance=minBalance;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        StringBuilder sb= new StringBuilder();
       if(digits*9>sum){
           throw new Exception("Account Number can not be generated");
        }
       else {
           int remainingSum = sum;
           for (int i = 0; i < digits - 1; i++) {
               if (remainingSum >= 9) {
                   sb.append(i);
                   remainingSum -= i;
               } else {
                   sb.append(i);
                   remainingSum = 0;
               }
           }
       }
           return sb.toString();

       }

    public void deposit(double amount) {
        this.balance+=amount;
    }

    public void withdraw(double amount) throws Exception {
        if(this.balance-amount<this.balance){
            throw new Exception("Insufficient Balance");
        }
        else{
            this.balance-=amount;
        }
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance

    }

}