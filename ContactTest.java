package contactservice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactTest {

    @Test
    void testContactCreation() {
        Contact contact = new Contact(
                "12345",
                "Jesse",
                "Carles",
                "8435551234",
                "123 Main Street");

        assertEquals("12345", contact.getContactId());
        assertEquals("Jesse", contact.getFirstName());
        assertEquals("Carles", contact.getLastName());
        assertEquals("8435551234", contact.getPhone());
        assertEquals("123 Main Street", contact.getAddress());
    }

    @Test
    void testContactIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345678901",
                    "Jesse",
                    "Carles",
                    "8435551234",
                    "123 Main Street");
        });
    }

    @Test
    void testContactIdNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    null,
                    "Jesse",
                    "Carles",
                    "8435551234",
                    "123 Main Street");
        });
    }

    @Test
    void testFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "Christopher",
                    "Carles",
                    "8435551234",
                    "123 Main Street");
        });
    }

    @Test
    void testFirstNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    null,
                    "Carles",
                    "8435551234",
                    "123 Main Street");
        });
    }

    @Test
    void testLastNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "Jesse",
                    "Washingtons",
                    "8435551234",
                    "123 Main Street");
        });
    }

    @Test
    void testLastNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "Jesse",
                    null,
                    "8435551234",
                    "123 Main Street");
        });
    }

    @Test
    void testPhoneTooShort() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "Jesse",
                    "Carles",
                    "843555123",
                    "123 Main Street");
        });
    }

    @Test
    void testPhoneTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "Jesse",
                    "Carles",
                    "84355512345",
                    "123 Main Street");
        });
    }

    @Test
    void testPhoneContainsLetters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "Jesse",
                    "Carles",
                    "843555ABCD",
                    "123 Main Street");
        });
    }

    @Test
    void testPhoneNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "Jesse",
                    "Carles",
                    null,
                    "123 Main Street");
        });
    }

    @Test
    void testAddressTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "Jesse",
                    "Carles",
                    "8435551234",
                    "1234567890123456789012345678901");
        });
    }

    @Test
    void testAddressNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "Jesse",
                    "Carles",
                    "8435551234",
                    null);
        });
    }

    @Test
    void testContactUpdates() {
        Contact contact = new Contact(
                "12345",
                "Jesse",
                "Carles",
                "8435551234",
                "123 Main Street");

        contact.setFirstName("James");
        contact.setLastName("Smith");
        contact.setPhone("8435554321");
        contact.setAddress("456 New Street");

        assertEquals("James", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("8435554321", contact.getPhone());
        assertEquals("456 New Street", contact.getAddress());
    }
}