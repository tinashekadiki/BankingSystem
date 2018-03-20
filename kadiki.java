/*
@Tinashe Kadiki
@Version 20.03.2018v01
*/
import java.time.*;
import java.lang.Exception;
import java.util.*;

public class Bank{
    public static void main (String[] args) {
        BankAccount a = new BankAccount(112);
        SavingsAccount savingsAcc = new SavingsAccount(555);
        CurrentAccount currentAcc = new CurrentAccount(333);
        
        savingsAcc.deposit(500);
        currentAcc.deposit(500);
        
        System.out.println("New balance Savings Account:" +savingsAcc.getAccountBalance());
        System.out.println("New balance Current Account:" +currentAcc.getAccountBalance());
        
        savingsAcc.withdraw(100);
        currentAcc.withdraw(250);
        
        System.out.println("New balance Current Account:" +currentAcc.getAccountBalance());
        System.out.println("New balance Savings Account:" +savingsAcc.getAccountBalance());
        //savingsAcc.withdraw(500);
        
        Customer customer1 = new Customer("Tinashe","Kadiki","30/08/1997","47-2037272X47");
        
        customer1.setBankAccounts(currentAcc,savingsAcc);
        //customer1.setAccounts(currentAcc);
        
        System.out.println("firstname: " +customer1.getName()+ "\nsurname: " +customer1.getSurname()+ "\ndate of birth: " +customer1.getBirthDate()+ "\nNational ID: " +customer1.getNationalID());
        //System.out.print(customer1.getAccounts());
        for(BankAccount acc : customer1.getAccounts())
        {
            System.out.print(acc+ " , ");
        }
    }
}
class Customer{
    String firstname, surname, birthDate, status, nationalID, email;
    int mobileNumber;
    LocalDate date;
    BankAccount [] bankAccounts;
    
Customer(String firstname, String surname, String birthDate, String nationalID){
    this.firstname = firstname;
    this.surname = surname;
    this.birthDate = birthDate;
    this.nationalID = nationalID;
}

    
    public String getName(){
        return this.firstname;
    }
    
    public String getSurname(){
        return this.surname;
    }
    
    public String getBirthDate(){
        return this.birthDate;
    }
    
    public String getStatus(){
        return this.status;
    }
    
    public String getNationalID(){
        return this.nationalID;
    }
    
    public String getEmail(){
        return this.email;
    }
    public void setBankAccounts(BankAccount ... accounts){
        int i=0;
        bankAccounts = new BankAccount[accounts.length];
        
        for(BankAccount acc: accounts)
        {
            bankAccounts [i] = acc;
            i++;
        }
    }
    
    public void setAccounts(BankAccount ... accounts){
        ArrayList acc = new ArrayList();
        acc.add(accounts);
        
    }
    
    public int getMobile(){
        return this.mobileNumber;
    }
    
    public void setName(String n){
        n = this.firstname;
    }
    
    public void setSurname(String s){
        s = this.surname;
    }
    
    public void setBirthDate(String d){
        d = this.birthDate;
    }
    
    public void setStatus(String st){
        st = this.status;
    }
    
    public void setNationalID(String nt){
       nt  = this.nationalID;
    }
    
    public void setEmail(String e){
        e = this.email;
    }
    
    public BankAccount [] getAccounts(){
        return this.bankAccounts;
    }
    
    public void setMobile(int m){
        m = this.mobileNumber;
    }
}
class BankAccount{
    int accountNumber;
    double accountBalance;
    
    public int getAccountNumber(){
        return this.accountNumber;
    }
    
    public double getAccountBalance(){
        return this.accountBalance;
    }
    
    public void setAccountNumber(int acc){
        acc = this.accountNumber;
    }
    
    public void setAccountBalance(double ab){
        ab = this.accountBalance;
    }
    
    public BankAccount(int accountNumber){
        accountBalance = 0.00;
    }
    
    public double deposit(double depositAmount){
        return accountBalance += depositAmount;
    }
    
    public double withdraw (double withdrawAmount) throws IllegalArgumentException {
        return accountBalance -= withdrawAmount;
    }
    
    public void applyMonthlyFee(){
        
    }

}
class SavingsAccount extends BankAccount{
    double interestAmount;
    
    SavingsAccount(int accountNumber){
        super(2);
    }
    
    public double withdraw (double withdrawAmount){
        if(withdrawAmount > (accountBalance-5))
            {throw new IllegalArgumentException("Amount greater than float");}
    return accountBalance -= withdrawAmount;
    }
    
    public void applyMonthlyFee(){
        double monthlyFee = 3;
        accountBalance -= monthlyFee;
    }
    
    public double calculateInterest(){
        
        return interestAmount;
    }
}
class CurrentAccount extends BankAccount{
    
    CurrentAccount(int accountNumber){
        super(2);
    }
    
    public double withdraw (double withdrawAmount){
       if(withdrawAmount > (accountBalance-3))
            {throw new IllegalArgumentException("Amount greater than float");}
    return accountBalance -= withdrawAmount;
    }
    
    public void applyMonthlyFee(){
        double monthlyFee = 5;
        accountBalance -= monthlyFee;
    }
}


Language Version:  JDK 9.0.1
