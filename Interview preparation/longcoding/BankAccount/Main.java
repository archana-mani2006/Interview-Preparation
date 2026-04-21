import java.util.Scanner;
class BankAccount{
    private String accountNumber;
    private double balance;

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } 
        else {
            System.out.println("Invalid deposit amount.");
        }
    }
    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }
    void display() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
    void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
}

class SavingsAccount extends BankAccount {
    final double interestRate = 5.0;
    static final String BankName= "Indian Bank";
    SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }   
    final void showBankName() {
        System.out.println("Bank Name: " + BankName);
    }
    void calculateInterest() {
            double interest = (getBalance() * interestRate) / 100;
            setBalance(getBalance()+ interest);
            
            System.out.println("Interest added: " + interest);
            System.out.println("Updated Balance: " + getBalance());
    }
}
class CurrentAccount extends BankAccount {
    static final String BankName= "Indian Bank";
    CurrentAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }
    final void showBankName() {
        System.out.println("Bank Name: " + BankName);
    }
    double overdraftLimit = 1000.0;
    void withdraw(double amount) {
        if (amount > 0 && amount <= getBalance() + overdraftLimit) {
            double newBalance = getBalance() - amount;
            if (newBalance < 0) {
                System.out.println("Overdraft used: " + (-newBalance));
            }
            setBalance(newBalance);
            
        } else {
            System.out.println("Invalid withdrawal amount or exceeds overdraft limit.");
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        BankAccount a = new BankAccount("BA123", 500.0);
        

        SavingsAccount s = new SavingsAccount("SA123", 1000.0);
        CurrentAccount c = new CurrentAccount("CA123", 500.0);

       
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        if(choice==1){
            s.showBankName();
            s.displayBalance();
            s.deposit(500);
            s.withdraw(200);
            s.calculateInterest();
            s.displayBalance();
        }
        else if(choice==2){
            c.showBankName();
            c.displayBalance();
            c.deposit(1000);
            c.withdraw(500);
            c.withdraw(3000); 
            c.displayBalance();
        }
        else if(choice==3){
            System.out.println("Exiting...");
        }
        else{
            System.out.println("Invalid choice.");
        }
    }
}