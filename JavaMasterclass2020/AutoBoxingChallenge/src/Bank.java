import java.util.ArrayList;

public class Bank {

    private String bankName;
    private ArrayList<Branch> branches;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.branches = new ArrayList<Branch>();
    }

    public boolean addNewBranch(String branchName) {
        if(getBranch(branchName) == null) {
            branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addNewCustomer(String branchName, String customerName, double initialAmount) {
        Branch branch = getBranch(branchName);
        if(branch != null) {
            return branch.addNewCustomer(customerName, initialAmount);
        }
        return false;
    }

    public boolean addTransaction(String branchName, String customerName, double transactionAmount) {
        Branch branch = getBranch(branchName);

        if(branch != null) {
            return branch.addCustomerTransaction(customerName, transactionAmount);
        }  else {
            return false;
        }
    }

    public boolean showListOfCustomers(String branchName, boolean showTransactions) {
        Branch branch = getBranch(branchName);
        if(branch != null) {
            System.out.println("Customer details for branch " + branch.getBranchName() + ":");

            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for (int i = 0; i < branchCustomers.size(); i++) {
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("Customer: " + branchCustomer.getCustomerName() + "[" + (i+1) + "]");
                if(showTransactions) {
                    System.out.println("Transactions:");
                    ArrayList<Double> transactions = branchCustomer.getTransactions();
                    for(int j = 0; j < transactions.size(); j++) {
                        System.out.println("[" + (j+1) + "] Amount " + transactions.get(j));
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

//    public void showCustomerTransactions(int branchIndex, int customerIndex) {
//        branches.get(branchIndex).showCustomerTransactions(customerIndex);
//    }

//    public void showBranches() {
//        for (int i = 0; i < branches.size(); i++) {
//            System.out.println("Branch #" + (i+1) + ": " + branches.get(i).getBranchName());
//        }
//    }

    private Branch getBranch(String branchName) {

        for(int i = 0; i < this.branches.size(); i++) {
            Branch checkedBranch = this.branches.get(i);
            if(checkedBranch.getBranchName().equals(branchName)) {
                return checkedBranch;
            }
        }
        return null;
    }

    public String getBankName() {
        return bankName;
    }

//    private void showMenu() {
//        System.out.println("What do you want to do?");
//        System.out.println("0 - add a new branch");
//        System.out.println("1 - add new customer");
//        System.out.println("2 - add a transaction");
//        System.out.println("3 - show list of customers");
//
//    }

    //addNewBranch, addNewCustomer, adding a transction, show list of customers
    //call code from other classes
}
