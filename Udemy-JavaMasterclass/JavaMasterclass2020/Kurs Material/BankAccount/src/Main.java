public class Main {

    public static void main(String[] args) {

        BankAccount bobsAccount = new BankAccount(); //12345, 145.00, "Bob Brown",
               // "bob@bob.de", "01762526262");

        System.out.println(bobsAccount.getAccountnumber());
        System.out.println(bobsAccount.getBalance());
        bobsAccount.withdraw(100.0);
        bobsAccount.deposit(50.0);
        bobsAccount.withdraw(100.0);
        bobsAccount.deposit(51);
        bobsAccount.withdraw(100.0);

        BankAccount timsAccount = new BankAccount("Tim", "Tim@email.com", "12334");
        System.out.println(timsAccount.getAccountnumber() + " name " + timsAccount.getCustomerName());
    }
}
