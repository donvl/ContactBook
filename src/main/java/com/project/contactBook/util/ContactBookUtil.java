package com.project.contactBook.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.contactBook.dao.ContactDao;
import com.project.contactBook.entity.Contact;
import com.project.contactBook.entity.PhoneNumber;
import com.project.contactBook.service.ContactService;
import com.project.contactBook.service.PhoneNumberService;
import javafx.collections.ObservableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    public String createNewContact(String json) throws IOException {
        Map<String, Object> map = new ObjectMapper().readValue(json, HashMap.class);
        Contact contact = new Contact();
        contact.setFirstName(map.get("firstName").toString());
        contact.setLastName(map.get("lastName").toString());
        contact.setEmail(map.get("email").toString());
        List<PhoneNumber> numbers = (List<PhoneNumber>) map.get("phoneNumbers");
        contactService.create(contact);
        numbers.forEach(number -> {
            number.setContact(contact);
            phoneNumberService.create(number);
        });
        return "контакт создан";
    }


    public String updateContactDetails(String json) throws IOException {
        Map<String, Object> map = new ObjectMapper().readValue(json, HashMap.class);
        if (map.get("id") != null) {
            if (contactService.isContactExists(Long.valueOf(map.get("id").toString()))) {
                Contact contactDB = contactService.finById(Long.valueOf(map.get("id").toString()));
                if (map.get("firstName") != null) {
                    contactDB.setFirstName(map.get("firstName").toString());
                }
                if (map.get("lastName") != null) {
                    contactDB.setLastName(map.get("lastName").toString());
                }
                if (map.get("email") != null) {
                    contactDB.setEmail(map.get("email").toString());
                }
                contactService.upDate(contactDB);
                return "контакт изменен";
            }
            return "контакта с таким id не существует";
        }
        return "поле id не заполнено";
    }


    public String addPhoneNumber(String json) throws IOException {
        Map<String, Object> map = new ObjectMapper().readValue(json, HashMap.class);
        PhoneNumber number = new PhoneNumber();
        if (map.get("id") != null) {
            if (contactService.isContactExists(Long.valueOf(map.get("id").toString()))) {
                if (map.get("number") != null) {
                    if (map.get("operatorName") != null) {
                        number.setOperatorName(map.get("operatorName").toString());
                        number.setNumber(map.get("number").toString());
                        number.setContact(contactService.finById(Long.valueOf(map.get("id").toString())));
                        phoneNumberService.create(number);
                        return "номер добавлен";
                    }
                    return "поле operatorName не заполнено";
                }
                return "поле number не заполнено";
            }
            return "контакта с таким id не существует";
        }
        return "поле id не заполнено";
    }


    public String updatePhoneNumber(String json) throws IOException {
        Map<String, Object> map = new ObjectMapper().readValue(json, HashMap.class);
        if (map.get("id") != null) {
            if (phoneNumberService.isNumberExists(Long.valueOf(map.get("id").toString()))) {
                PhoneNumber numberDB = phoneNumberService.finById(Long.valueOf(map.get("id").toString()));
                if (map.get("number") != null) {
                    numberDB.setNumber(map.get("number").toString());
                }
                if (map.get("operatorName") != null) {
                    numberDB.setOperatorName(map.get("operatorName").toString());
                }
                phoneNumberService.upDate(numberDB);
                return "номер изменен";
            }
            return "номера с таким id не существует";
        }
        return "поле id не заполнено";
    }

}
