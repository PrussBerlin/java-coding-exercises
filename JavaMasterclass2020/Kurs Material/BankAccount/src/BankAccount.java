public class BankAccount {

    private int accountnumber;
    private double balance;
    private String customerName;
    private String email;
    private String phoneNumber;

    public BankAccount() {

        this(00000, 00.00, "Default name", "Default address",
                "default phone");
        System.out.println("Default constructor called");
    }

    public BankAccount(int accountNumber, double balance, String customerName, String email, String phoneNumber) {

        System.out.println("Bankaccount constructor with paramters called");
        this.accountnumber = accountNumber;
        this.balance = balance;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;

    }

    public BankAccount(String customerName, String email, String phoneNumber) {

        this(00000, 00.00, customerName, email, phoneNumber);
    }

    public int getAccountnumber() {

        return this.accountnumber;
    }

    public double getBalance() {

        return this.balance;
    }

    public String getCustomerName() {

        return this.customerName;
    }

    public String getEmail() {

        return this.email;
    }

    public String getPhoneNumber() {

        return this.phoneNumber;
    }

    public void setAccountnumber(int accountnumber) {

        this.accountnumber = accountnumber;
    }

    public void setBalance(double balance) {

        this.balance = balance;
    }

    public void setCustomerName(String customerName) {

        this.customerName = customerName;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public void setPhoneNumber (String phoneNumber) {

        this.phoneNumber = phoneNumber;
    }

    public void deposit(double deposit) {

        this.balance += deposit;
        System.out.println("Deposit of " + deposit + " made. Your new balance is: " + this.balance);
    }

    public void withdraw(double withdrawThisAmount) {

        if(this.balance-withdrawThisAmount < 0) {

            System.out.println("Only " + this.balance + " available. Withdrawal not processed");
        } else {

            this.balance -= withdrawThisAmount;
            System.out.println("Withdrawal of " + withdrawThisAmount + " processed. Remaining balance: " + this.balance);
        }
    }
}
