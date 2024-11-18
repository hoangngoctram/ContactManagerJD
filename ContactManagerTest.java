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
    void testFindContactByEmail() {
        // Test searching by email address
        Contact foundContact = contactManager.findContact("john@gmail.com");
        assertNotNull(foundContact, "Contact should be found");
        assertEquals("john@gmail.com", foundContact.getEmailAddress(), "Email should match");
    }

    @Test
    void testFindContactNotFound() {
        // Test searching for a non-existent contact
        Contact foundContact = contactManager.findContact("alice@gmail.com");
        assertNull(foundContact, "Contact should not be found");
    }
}
