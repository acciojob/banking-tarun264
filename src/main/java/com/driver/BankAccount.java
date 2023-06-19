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

    public BankAccount() {
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

           StringBuilder sb =new StringBuilder();
           for (int i=0;i<digits;i++) {
               if (sum >= 9)
                   sb.append(9);
               sum -= 9;
           }
               else {
                   sb.append(sum);
                   sum=0;
               }

           if(sum>0){
               throw new Exception("Account Number Cannot be generated");
           }

           return sb.toString();
       }
    public void deposit(double amount) {
        this.balance+=amount;
    }

    public void withdraw(double amount) throws Exception {
        if(this.balance-amount<this.minBalance){
            throw new Exception("Insufficient Balance");
        }
        else{
            this.balance-=amount;
        }
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance

    }

}