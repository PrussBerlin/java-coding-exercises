import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();

    public static void main(String[] args) {

//        ArrayList<String> testList = new ArrayList<String>();
//        groceryList.addGroceryItem("Hund");
//        groceryList.addGroceryItem("Katze");
//        System.out.println(groceryList.getGroceryList().size());
//        processArrayList();
        //System.out.println(testList);

        boolean quit = false;
        int choice = 0;
        System.out.println();
        printInstructions();
        while(!quit) {
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchForItem();
                    break;
                case 6:
                    quit = true;
                    break;
                case 7:
                    processArrayList();
                    break;
            }
        }


    }

    public static void printInstructions() {
        System.out.println(("\nPress "));
        System.out.println("\t 0 - To print the choice options.");
        System.out.println("\t 1 - To print the the list of grocery Items.");
        System.out.println("\t 2 - To add an item to the list.");
        System.out.println("\t 3 - To modify an item in the list.");
        System.out.println("\t 4 - To remove an item from the list.");
        System.out.println("\t 5 - To search for an item in the list.");
        System.out.println("\t 6 - To quit the application.");

    }

    public static void addItem() {
        System.out.print("Please enter the grocery Item: ");
        groceryList.addGroceryItem(scanner.nextLine());
    }

    public static void modifyItem() {
        System.out.print("Current item name: ");
        String itemName = scanner.nextLine();
        System.out.println("Enter new item: ");
        String newItem = scanner.nextLine();
        groceryList.modifyGroceryItem(itemName, newItem);

    }

    public static void removeItem() {
        System.out.print("Enter item name: ");
        String itemName = scanner.nextLine();
        groceryList.removeGroceryItem(itemName);
    }

    public static void searchForItem() {
        System.out.print("Item to search for: ");
        String searchItem = scanner.nextLine();
        if (groceryList.getGroceryList().contains(searchItem)) {
            System.out.println("Found " + searchItem + " in  our grocery list");
        } else {
            System.out.println(searchItem + " is not in the list.");
        }
    }

        public static void processArrayList() {
            ArrayList<String> newArray = new ArrayList<>();
            newArray.addAll(groceryList.getGroceryList());

            ArrayList<String> nextArray = new ArrayList<String>(groceryList.getGroceryList());

            String[] myArray = new String[groceryList.getGroceryList().size()];
            System.out.println(Arrays.toString(myArray));
            groceryList.getGroceryList().toArray(myArray);
            System.out.println(Arrays.toString(myArray));

       }
}
