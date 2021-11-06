public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank("Sparkasse");
        if(!bank.addNewBranch("Hamburg")) {
            System.out.println("Branch already exists");
        }
//        bank.addNewBranch("Hamburg");

        bank.addNewCustomer("Hamburg", "Tim", 50.05);
        bank.addNewCustomer("Hamburg", "Mike", 175.34);
        bank.addNewCustomer("Hamburg", "Percey", 220.12);

        bank.addNewBranch("Berlin");
        bank.addNewCustomer("Berlin", "Bob", 150.54);

        bank.addTransaction("Hamburg", "Tim", 44.22);
        bank.addTransaction("Hamburg", "Tim", 12.44);
        bank.addTransaction("Hamburg", "Mike", 1.65);

        bank.showListOfCustomers("Hamburg", false);
        bank.showListOfCustomers("Hamburg", true);
        bank.showListOfCustomers("Berlin", true);

//        bank.addNewBranch("München");

        if(!bank.addNewCustomer("München", "Jörg", 3.50)) {
            System.out.println("Error, München does not exist");
        }

        if(!bank.addTransaction("Berlin", "Fergus", 3.45)) {
            System.out.println("Customer does not exist at branch");
        }

        if(!bank.addNewCustomer("Berlin", "Bob", 12.21)) {
            System.out.println("Customer Bob allready exists");
        }

    }

}
