import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("017625278808");

    public static void main(String[] args) {
//        MobilePhone phone1 = new MobilePhone("017625278808");
//        phone1.menu();
//        phone1.addContact("Friedemann", "Pruss", "017625278808");

        boolean quit = false;
        startPhone();
        printActions();

        while(!quit) {
            System.out.println("\nEnter action: (6 - to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch(action) {
                case 0:
                    System.out.println("\nShutting down...");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
                default:
                    System.out.println("Wrong input");
            }
        }
        scanner.close();
    }

    private static void addNewContact() {
        System.out.println("Enter first name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name:");
        String lastName = scanner.nextLine();
        System.out.println("Enter phone number:");
        String phoneNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(firstName, lastName, phoneNumber);
        if(mobilePhone.addContact(newContact)) {
            System.out.println("New contact added: " + firstName + " " + lastName + ", phone: " + phoneNumber);
        }
    }

    private static void updateContact() {
        System.out.println("Enter existing contact full name: ");
        String fullName = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(fullName);
        if(existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }
        System.out.println("Enter new first name:");
        String newFirstName = scanner.nextLine();
        System.out.println("Enter new last name:");
        String newLastName = scanner.nextLine();
        System.out.println("Enter new phone number:");
        String newPhoneNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newFirstName, newLastName, newPhoneNumber);
//        if(mobilePhone.updateContact(existingContactRecord, newContact)) {
        mobilePhone.updateContact(existingContactRecord, newContact);
            System.out.println("Succesfully updated record");
//        } else {
//            System.out.println("Error updating record.");
//        }
    }

    private static void removeContact() {
        System.out.println("Enter existing contact full name: ");
        String fullName = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(fullName);
        if (existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }
        mobilePhone.removeContact(existingContactRecord);

    }

    private static void queryContact() {
        System.out.println("Enter existing contact full name: ");
        String fullName = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(fullName);
        if (existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }
        System.out.println(existingContactRecord.getFullName() + " phone number is: " + existingContactRecord.getPhoneNumber());
    }

    private static void startPhone() {
        System.out.println("Starting phone...");
    }

    private static void printActions() {
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0 - to shutdown\n" +
                           "1 - to print contacts\n" +
                           "2 - add a new contact\n" +
                           "3 - to update an existing contact\n" +
                           "4 - to remove an existing contact\n" +
                           "5 - query if an existing contact exists\n" +
                           "6 - to print a lists of available actions");
        System.out.println("Choose your action: ");
    }
}
