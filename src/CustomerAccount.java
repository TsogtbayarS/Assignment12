public class CustomerAccount {
    private String cus_Name;
    private String Acc_No;
    private double balance;

    public CustomerAccount(String cus_Name, String Acc_No, double balance) {
        this.cus_Name = cus_Name;
        this.Acc_No = Acc_No;
        this.balance = balance;
    }
    public boolean deposit (double amount){
        if (0 > amount){
            return false;
        }
        balance += amount;
        return true;
    }
    public boolean withdraw (double amount) throws InsufficientFundsException {
        if (balance < 0){
            return false;
        }
        if (balance < amount) {
            throw new InsufficientFundsException("Withdraw amount exceeds the balance.");
        }
        if (balance - amount < 100) {
            throw new InsufficientFundsException("Balance will go below $100.");
        }
        balance -= amount;
        return true;
    }
    public double getBalance(){
        return balance;
    }

    public static void main(String[] args) throws InsufficientFundsException {
        CustomerAccount account = new CustomerAccount("John", "1234567890", 500);
        System.out.println("Balance: "+account.getBalance());
        account.deposit(100);
        System.out.println("Balance: "+account.getBalance());
        account.withdraw(300);
        System.out.println("Balance: "+account.getBalance());
        account.withdraw(450);
        System.out.println("Balance: "+account.getBalance());
    }
    static class InsufficientFundsException extends Exception{
        public InsufficientFundsException(String message){
            super(message);
        }
    }
}
