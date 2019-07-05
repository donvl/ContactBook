package com.project.contactBook.util;

import com.project.contactBook.entity.Contact;
import com.project.contactBook.entity.PhoneNumber;
import com.project.contactBook.service.ContactService;
import com.project.contactBook.service.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContactBookUtil {

    @Autowired
    ContactService contactService;

    @Autowired
    PhoneNumberService phoneNumberService;

    public List getContactsListWithPhoneNumbers() {
        List contactList = contactService.findAll();
        return contactList;
    }

    public void createNewContact(Contact contact) {
        List<PhoneNumber> numbers = contact.getPhoneNumbers();
        contactService.create(contact);
        numbers.forEach(number -> {
            number.setContact(contact);
            phoneNumberService.create(number);
        });
    }

    public void updateContactDetails(Contact contact) {
        Contact contactDB = contactService.finById(contact.getContactId());
        if (contact.getFirstName() != null) {
            contactDB.setFirstName(contact.getFirstName());
        }
        if (contact.getLastName() != null) {
            contactDB.setLastName(contact.getLastName());
        }
        if (contact.getEmail() != null) {
            contactDB.setEmail(contact.getEmail());
        }
        contactService.upDate(contactDB);
    }

    public void addPhoneNumber(PhoneNumber number) {
        phoneNumberService.create(number);
    }

    public void updatePhoneNumber(PhoneNumber number) {
        PhoneNumber numberDB = phoneNumberService.finById(number.getPhoneNumberId());
        if (number.getNumber() != null) {
            numberDB.setNumber(number.getNumber());
        }
        if (number.getOperatorName() != null) {
            numberDB.setOperatorName(number.getOperatorName());
        }
        phoneNumberService.upDate(numberDB);
    }
}
