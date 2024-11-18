/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import ca.sheridancollege.hoangnguyen.ic4.Contact;
import ca.sheridancollege.hoangnguyen.ic4.ContactManager;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactManagerTest {

    private ContactManager contactManager;

   @BeforeEach
    void setUp() {
        // Initialize the ContactManager object before each test
        contactManager = new ContactManager();
        
        // Add some sample contacts
        contactManager.addContact(new Contact("John", "Doe", "john@gmail.com"));
        contactManager.addContact(new Contact("Jane", "Smith", "jane@gmail.com"));
    }

    @Test
    void testAddContact_ValidContact() {
        Contact newContact = new Contact("Alice", "Johnson", "alice@gmail.com");
        contactManager.addContact(newContact);
        assertEquals(newContact, contactManager.findContact("alice@gmail.com"), "Contact should be added and retrievable");
    }

    // Bad Cases: Invalid inputs or unexpected conditions
    @Test
    void testFindContactByEmail_InvalidEmail() {
        Contact foundContact = contactManager.findContact("invalid_email.com");
        assertNull(foundContact, "Contact should not be found for an invalid email");
    }



    // Boundary Cases: Edge conditions
    @Test
    void testContactListWithEmptyManager() {
        contactManager.clearContacts();
        assertNull(contactManager.findContact("john@gmail.com"), "No contacts should be found in an empty manager");
    }

    @Test
    void testContactListWithHighVolume() {
        contactManager.clearContacts();

        // Add 1000 contacts
        for (int i = 0; i < 1000; i++) {
            contactManager.addContact(new Contact("Name" + i, "Last" + i, "email" + i + "@example.com"));
        }

        assertNotNull(contactManager.findContact("email0@example.com"), "First contact should be found");
        assertNotNull(contactManager.findContact("email499@example.com"), "Middle contact should be found");
        assertNotNull(contactManager.findContact("email999@example.com"), "Last contact should be found");
    }
    
    @Test
    void testContactListBoundary_OneContact() {
        contactManager.clearContacts();
        Contact onlyContact = new Contact("Unique", "Person", "unique@gmail.com");
        contactManager.addContact(onlyContact);

        assertEquals(onlyContact, contactManager.findContact("unique@gmail.com"), "Single contact should be found");
    }
    @Test
    void testAddContactWithNullValues() {
        // Test adding a contact with null values
        Contact nullContact = new Contact(null, null, null);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contactManager.addContact(nullContact);
        });
        assertEquals("Contact details cannot be null", exception.getMessage());
    }
  
}