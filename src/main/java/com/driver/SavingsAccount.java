package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public double getRate() {
        return this.rate;
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
        if(amount<=maxWithdrawalLimit){
            super.withdraw(amount);
        }
        else{
            throw new Exception("Maximum Withdraw Limit Exceed");
        }

    }

    public double getSimpleInterest(int years){
       return getBalance()*(1+this.rate*years/100);
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
 return this.getBalance() * Math.pow((1 + this.rate / (100 * times)),(times * years));
    }

}
