package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public double getRate() {
        return this.rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setMaxWithdrawalLimit(double maxWithdrawalLimit) {
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }

    public double getMaxWithdrawalLimit() {
        return this.maxWithdrawalLimit;
    }

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        super(name,balance,0.0);
        this.maxWithdrawalLimit=maxWithdrawalLimit;
        this.rate=rate;
        // minimum balance is 0 by default

    }
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
        if(amount>this.maxWithdrawalLimit){
            throw new Exception("Maximum Withdraw Limit Exceed");
        }
        if(getBalance()<amount){
            throw new Exception("Insufficient Balance");
        }
        setBalance(getMinBalance()-amount);
    }

    public double getSimpleInterest(int years){

        double simpleInterest=((getBalance()*this.rate)/100)*years;
        return simpleInterest+getBalance();
    }


    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year

        double interest= getBalance() * Math.pow((1 + this.rate / (double)(100 * times)),(double)(times * years));
        return  interest+getBalance();
    }

}
