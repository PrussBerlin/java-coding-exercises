package com.fpruss.studium.udemy.datamodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Contact {

    private StringProperty firstName;
    private StringProperty lastName;
    private StringProperty phoneNumber;
    private StringProperty notes;

    public Contact() {
        firstNameProperty();
        lastNameProperty();
        phoneNumberProperty();
        notesProperty();
    }

    public Contact(String firstName, String lastName, String phoneNumber) {
        this(firstName, lastName, phoneNumber, null);
    }

    public Contact(String firstName, String lastName, String phoneNumber, String notes) {
        firstNameProperty().set(firstName);
        lastNameProperty().set(lastName);
        phoneNumberProperty().set(phoneNumber);
        notesProperty().set(notes);
    }

    @Override
    public String toString() {
        if(firstName != null && lastName != null && phoneNumber != null && notes != null) {
            return "name: " + firstName.get() + " " + lastName.get() + "\n" +
                    "phone: " + phoneNumber.get() + "\n" +
                    "notes: " + notes.get();
        }
        return "contact information incomplete";
    }

    public StringProperty firstNameProperty() {
        if(firstName == null) {
            firstName = new SimpleStringProperty("first name");
        }
        return firstName;
    }

    public void setFirstName(String firstName) {
        firstNameProperty().set(firstName);
    }

    public String getFirstName() {
        return firstName.getName();
    }

    public StringProperty lastNameProperty() {
        if(lastName == null) {
            lastName = new SimpleStringProperty("last name");
        }
        return lastName;
    }

    public void setLastName(String lastName) {
        lastNameProperty().set(lastName);
    }

    public String getLastName() {
        return lastName.getName();
    }

    public StringProperty phoneNumberProperty() {
        if (phoneNumber == null) {
            phoneNumber = new SimpleStringProperty("phone number");
        }
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        phoneNumberProperty().set(phoneNumber);
    }

    public String getPhoneNumber() {
        return phoneNumber.getName();
    }

    public StringProperty notesProperty() {
        if(notes == null) {
            notes = new SimpleStringProperty("...");
        }
        return notes;
    }

    public void setNotes(String notes) {
       notesProperty().set(notes);
    }

    public String getNotes() {
        return notes.getName();
    }
}
