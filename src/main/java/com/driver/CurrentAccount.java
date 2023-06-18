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

        if (!validateId(this.tradeLicenseId)) {

            String rearrangeID = rearrangeTradeID(this.tradeLicenseId);
            if (rearrangeID == "") {

                throw new Exception("Valid License can not be generated");
            }
            this.tradeLicenseId = rearrangeID;
        }
    }
    public String rearrangeTradeID(String s){
        int n=s.length();
        //char array for storing the values of all the char
        char ch[]=s.toCharArray();
        //freq array to store their freq
        int freq[]= new int[26];

        //storing the count of each character int freq array
        for(int i=0;i<26;i++){
            freq[ch[i]-'a']++;
        }
        //find the max count character and its index
        int max=0;
        int letter=0;
        for(int i=0;i<26;i++){
            if(freq[i]>max){
                max=freq[i];
                letter=i;
            }
        }
        //after placing all the max char,check if char freq is less than half of size than the distinct characters are possible
        if(max>(n+1)/2){
            return "";
        }
        //placing the highest freq character in ans at even index
        int idx=0;
        char ans[]=new char[n];
        while(freq[letter]>0){
            ans[idx]= (char) freq[letter+'a'];
            idx+=2;
            freq[letter]--;
        }

        //now placing other charcters in ans
        for(int i=0;i<26;i++){
            while(freq[i]>0){
                if(idx>=n) idx=1;
                ans[i]= (char) freq[i+'a'];
                idx+=2;
                freq[i]--;
            }
        }
        return String.valueOf(ans);
    }
    public boolean validateId(String s){
        for(int i=1;i<s.length();i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                return false;
            }
        }  return true;
    }


    public String getTradeLicenseId() {
        return tradeLicenseId;
    }
}
