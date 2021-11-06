import java.util.ArrayList;

public class Branch {

    private String branchName;
    private ArrayList<Customer> customers;

    public Branch(String branchName) {
        this.branchName = branchName;
        this.customers = new ArrayList<Customer>();
    }

    public boolean addNewCustomer(String customerName, double initialAmount) {
        if (getCustomer(customerName) == null) {
            this.customers.add(new Customer(customerName, initialAmount));
            return true;
        } else {
            return false;
        }
    }

    public boolean addCustomerTransaction(String customerName, double transactionAmount) {
        Customer existingCustomer = getCustomer(customerName);

        if(existingCustomer != null) {
            existingCustomer.addTransaction(transactionAmount);
            return true;
        }
        return false;
    }

//    public void listOfCustomers() {
//        for (int i = 0; i < customers.size(); i++) {
//            System.out.println((i+1) + ": " + customers.get(i));
//        }
//        //dann ermöglichen, dass eine Zahl ausgewählt wird und die transcations angezeigt werden
//        //auto boxing and unboxing on the transactions
//        //add data validation, checken, ob der customername noch nicht benutzt wurde und wenn eine neue transcation
//        // gemacht werden soll, checken ob der customer exiestiert
//
//    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

//    public void showCustomerTransactions(int customerIndex) {
//        System.out.println(customers.get(customerIndex).getTransactions());
//    }

    public String getBranchName() {
        return branchName;
    }

    private Customer getCustomer(String customerName) {
        for (int i = 0; i < customers.size(); i++) {
            Customer checkedCustomer = customers.get(i);
            if (checkedCustomer.getCustomerName().equals(customerName)) {
                return checkedCustomer;
            }
        }
        return null;
    }
}
