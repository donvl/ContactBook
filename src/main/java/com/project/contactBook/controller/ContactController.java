package com.project.contactBook.controller;

import com.project.contactBook.entity.Contact;
import com.project.contactBook.util.ContactBookUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class ContactController {

    @Autowired
    ContactBookUtil contactBookUtil;

    @GetMapping("getContacts")
    public List getContactsList() {
        return contactBookUtil.getContactsListWithPhoneNumbers();
    }

    @PostMapping("createContact")
    public String createContact(@RequestBody String json) throws IOException {
        return contactBookUtil.createNewContact(json);
    }

    @PatchMapping(value = "updateContact")
    public String updateContact(@RequestBody String json) throws IOException {
        return contactBookUtil.updateContactDetails(json);
    }
}
