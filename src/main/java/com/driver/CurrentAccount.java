package com.driver;

public class CurrentAccount extends BankAccount {
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        super(name, balance, 5000.0);
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        this.tradeLicenseId = tradeLicenseId;
        if (balance < 5000.0) {
            throw new Exception("Insufficient Balance");
        }
    }

    public void validateLicenseId() throws Exception {
        char ch[] = tradeLicenseId.toCharArray();
        int n = tradeLicenseId.length();
        for (int i = 1; i < n; i++) {
            if (ch[i] == ch[i - 1]) {
                for (int j = i + 1; j < n - 1; j++) {
                    if (ch[j] != ch[i]) {
                        char temp = ch[i];
                        ch[i] = ch[j];
                        ch[j] = temp;
                        break;
                    }
                }
                // after rearranging it
                if (ch[i] == ch[i - 1]) {
                    throw new Exception("Valid License can not be generated");
                }
            }
        }
        ch.toString();

    }

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }
}
