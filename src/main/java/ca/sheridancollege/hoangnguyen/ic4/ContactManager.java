/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.hoangnguyen.ic4;

import java.util.ArrayList;

public class ContactManager {
    private ArrayList<Contact> contactList = new ArrayList<>();

    // Add a new contact
    public void addContact(Contact contact) {
        // Check for null contact or any null fields in the contact
        if (contact == null || contact.getFirstName() == null || contact.getLastName() == null || contact.getEmailAddress() == null) {
            throw new IllegalArgumentException("Contact details cannot be null");
        }
        contactList.add(contact);
    }

    // Find a contact by email address
    public Contact findContact(String emailAddress) {
        for (Contact contact : contactList) {
            if (contact.getEmailAddress().equals(emailAddress)) {
                return contact;
            }
        }
        return null;
    }

    // Clear all contacts
    public void clearContacts() {
        contactList.clear();
    }

    public ArrayList<Contact> getContactList() {
        return contactList;
    }
    //This is the new coment line I added
}

