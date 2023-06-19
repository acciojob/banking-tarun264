package com.driver;

public class StudentAccount extends BankAccount{

    String  institutionName;

    public String getInstitutionName() {
        return this.institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public StudentAccount(String name, double balance, String  institutionName) {
        super(name,balance,0.0);
        this.institutionName=institutionName;

    }

}
