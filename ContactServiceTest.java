package contactservice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {

    private ContactService contactService;
    private Contact contact;

    @BeforeEach
    void setUp() {
        contactService = new ContactService();

        contact = new Contact(
                "12345",
                "Jesse",
                "Carles",
                "8435551234",
                "123 Main Street");
    }

    @Test
    void testAddContact() {
        contactService.addContact(contact);

        assertEquals(
                contact,
                contactService.getContact("12345"));
    }

    @Test
    void testAddDuplicateContactId() {
        contactService.addContact(contact);

        Contact duplicateContact = new Contact(
                "12345",
                "James",
                "Smith",
                "8435554321",
                "456 New Street");

        assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(duplicateContact);
        });
    }

    @Test
    void testAddNullContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(null);
        });
    }

    @Test
    void testDeleteContact() {
        contactService.addContact(contact);
        contactService.deleteContact("12345");

        assertThrows(IllegalArgumentException.class, () -> {
            contactService.getContact("12345");
        });
    }

    @Test
    void testDeleteContactNotFound() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.deleteContact("99999");
        });
    }

    @Test
    void testUpdateFirstName() {
        contactService.addContact(contact);
        contactService.updateFirstName("12345", "James");

        assertEquals(
                "James",
                contactService.getContact("12345").getFirstName());
    }

    @Test
    void testUpdateLastName() {
        contactService.addContact(contact);
        contactService.updateLastName("12345", "Smith");

        assertEquals(
                "Smith",
                contactService.getContact("12345").getLastName());
    }

    @Test
    void testUpdatePhone() {
        contactService.addContact(contact);
        contactService.updatePhone("12345", "8435554321");

        assertEquals(
                "8435554321",
                contactService.getContact("12345").getPhone());
    }

    @Test
    void testUpdateAddress() {
        contactService.addContact(contact);
        contactService.updateAddress(
                "12345",
                "456 New Street");

        assertEquals(
                "456 New Street",
                contactService.getContact("12345").getAddress());
    }

    @Test
    void testUpdateContactNotFound() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateFirstName("99999", "James");
        });
    }

    @Test
    void testUpdateFirstNameWithInvalidValue() {
        contactService.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateFirstName(
                    "12345",
                    "Christopher");
        });
    }

    @Test
    void testUpdateLastNameWithInvalidValue() {
        contactService.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateLastName(
                    "12345",
                    "Washingtons");
        });
    }

    @Test
    void testUpdatePhoneWithInvalidValue() {
        contactService.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updatePhone(
                    "12345",
                    "843555123");
        });
    }

    @Test
    void testUpdateAddressWithInvalidValue() {
        contactService.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateAddress(
                    "12345",
                    "1234567890123456789012345678901");
        });
    }
}