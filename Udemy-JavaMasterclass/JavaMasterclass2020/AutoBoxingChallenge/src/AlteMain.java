//import java.util.Scanner;
//
//public class Main {
//
//    private static Scanner scanner = new Scanner(System.in);
//    private static Bank myBank;
//
//    public static void main(String[] args) {
//
//        System.out.println("Please Enter the name of your bank:");
//        String bankName = scanner.nextLine();
//        myBank = new Bank(bankName);
//        System.out.println(myBank.getBankName() + " has been created");
//        menu();
//    }
//
//    public static void menu() {
//
//
//        try{
//            boolean quit = false;
//            while(!quit) {
//                System.out.println("What do you want to do?");
//                System.out.println("0 - cancel");
//                System.out.println("1 - Add new branch");
//                System.out.println("2 - show Branches");
////                System.out.println("3 - add customer");
////                System.out.println("2 - show Branches");
////                System.out.println("2 - show Branches");
//                int i = scanner.nextInt();
//                scanner.nextLine();
//
//                switch(i) {
//                    case 0:
//                        quit = true;
//                        break;
//                    case 1:
//                        addNewBranch();
//                        break;
//                    case 2:
//                        enterBranch();
//                        break;
//                    case 3:
//
//                }
//            }
//        } catch(Exception e) {
//            System.out.println("Forbidden input");
//          }
//
//    }
//
//    public static void addNewBranch() {
//        System.out.println("Name?");
//        Branch newBranch = new Branch(scanner.nextLine());
//        if(myBank.addNewBranch(newBranch)) {
//            System.out.println(newBranch.getBranchName() + " added.");
//        } else {
//            System.out.println("Branch already exists");
//        }
//    }
//
//    public static void enterBranch() {
//        myBank.showBranches();
//
//        System.out.println("press a number to enter a certain branch or 0 for main menu:");
//        int branchIndex = scanner.nextInt();
//        scanner.nextLine();
//        branchIndex -= 1;
//
//        if(branchIndex >= 0) {
//            System.out.println("0 - go to main menu");
//            System.out.println("1 - show customers");
//            System.out.println("2 - add a transaction");
//            System.out.println("3 - add customer");
//            switch(branchIndex) {
//                case 0:
//                    break;
//                case 1:
//                    myBank.showListOfCustomers(branchIndex);
//                    System.out.println("Show transactions on a customer? (0 to go to main menu");
//                    int customerIndex = scanner.nextInt();
//                    scanner.nextLine();
//                    customerIndex -= 1;
//                    if(customerIndex >= 0) {
//                        myBank.showCustomerTransactions(branchIndex, customerIndex);
//                    } else if(customerIndex == -1) {
//                        return;
//                    } else {
//                        System.out.println("Wrong input");
//                    }
//                case 2:
//                    System.out.println("");
//                    myBank.addTransaction(branchIndex, customerIndex, scanner.nextDouble();
//            }
//
//        } else if(branchIndex == -1) {
//            return;
//        } else {
//            System.out.println("Wrong input");
//        }
////        myBank.getBranch
//    }
//
//}
