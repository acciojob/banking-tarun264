package com.driver;


public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    public void setMaxWithdrawalLimit(double maxWithdrawalLimit) {
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        super(name,balance,0);
        // minimum balance is 0 by default
        this.rate=rate;
        this.maxWithdrawalLimit=maxWithdrawalLimit;
    }
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
        if(amount>this.maxWithdrawalLimit){
            throw  new Exception("Maximum Withdraw Limit Exceeded");
        }
        if(getBalance()<amount){
            throw  new Exception("Insufficient Balance");
        }
        setBalance(getMinBalance()-amount);
    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        double simpleInterest=((getBalance()*this.rate)/100)*years;
        return simpleInterest+getBalance();

    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        int month=years*12;
        int  temp=month/times;
        double balance=getBalance();

        for(int i=1; i<temp; i++){
            double interest=(balance*this.rate)/100;
            balance+=interest;
        }
        return balance;
    }

}