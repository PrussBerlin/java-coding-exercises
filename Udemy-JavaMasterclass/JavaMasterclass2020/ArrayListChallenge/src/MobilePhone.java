import java.util.ArrayList;

//man könnte die Liste alphabetisch sortiert anzeigen
public class MobilePhone {

    private String myNumber;
    private ArrayList<Contact> contacts;
    // Tims
    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.contacts = new ArrayList<Contact>();
    }
    //tims
    public boolean addContact(Contact contact) {

        if(findContact(contact.getFullName()) >= 0) {
            System.out.println("Contact already exists");
            return false;
        }
        contacts.add(contact);
        return true;
    }
    //Tims
    public boolean updateContact(Contact oldContact, Contact newContact) {
        int foundPosition = findContact(oldContact);
        if(foundPosition < 0) {
            System.out.println(oldContact.getFullName() + ", was not found.");
            return false;
        }
        //überflüssig
//        else if(findContact(newContact.getFullName()) != -1){
//            System.out.println("Contact with name " + newContact.getFullName() +
//                    " already exists. Udate not succesfull");
//            return false;
//        }
        this.contacts.set(foundPosition, newContact);
        System.out.println(oldContact.getFullName() + ", phone: " + oldContact.getPhoneNumber()
                           + ", was replaced with: \n" + newContact.getFullName()
                           + ", phone: " + newContact.getPhoneNumber());
        return true;
    }
    //Tims
    public boolean removeContact(Contact contact) {
        int foundPosition = findContact(contact);
        if(foundPosition < 0) {
            System.out.println(contact.getFullName() + ", was not found.");
            return false;
        }
        this.contacts.remove(foundPosition);
        System.out.println(contact.getFullName() + ", was succesfully deleted.");
        return true;
    }
    //Tims
    private int findContact(Contact contact) {
        return this.contacts.indexOf(contact);
    }
    //Tims
    private int findContact(String fullName) {
        for(int i = 0; i < this.contacts.size(); i++) {

            if(contacts.get(i).getFullName().equals(fullName)) {
                return i;
            }
        }
        return -1;
    }
    //überflüssig
    //Tims
    public String queryContact(Contact contact) {
        if(findContact(contact) >= 0) {
            return contact.getFullName();
        }
        return null;
    }

    public Contact queryContact(String fullName) {
        int position = findContact(fullName);
        if(position >= 0) {
            return this.contacts.get(position);
        }

        return null;
    }
    public void printContacts() {
        System.out.println("Contact List");
        for(int i = 0; i < contacts.size(); i++) {
            System.out.println((i+1) + "." +
                            this.contacts.get(i).getFullName() + " -> " +
                            this.contacts.get(i).getPhoneNumber());
        }
    }


}
