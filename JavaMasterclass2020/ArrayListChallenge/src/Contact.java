public class Contact {

    private String firstName;
    private String lastName;
    private String fullName;
    private String phoneNumber;

    public Contact(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
        this.phoneNumber = phoneNumber;
    }

    //Tims
    public static Contact createContact(String firstName, String lastName, String phoneNumber) {
        return new Contact(firstName, lastName, phoneNumber);
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    //könnte man mal implementieren, so wie es jetzt implementiert ist ändert man einfach alles, allerdings im Phone
    private void modifyContact() {
        try{
            System.out.println("\t 1 - change first name");
            System.out.println("\t 2 - change last name");
            System.out.println("\t 3 - change phone number");
//            int i = scanner.nextInt();
//
//            contacts.set(index, new Contact(firstName, lastName, phoneNumber));
        } catch(Exception e) {
            System.out.println("contact does not exist");
        }
    }
}
