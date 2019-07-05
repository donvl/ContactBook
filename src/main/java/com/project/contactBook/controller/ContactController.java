package com.project.contactBook.controller;

import com.project.contactBook.entity.Contact;
import com.project.contactBook.util.ContactBookUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public @ResponseBody
    ResponseEntity createContact(@RequestBody Contact contact) {
        contactBookUtil.createNewContact(contact);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PatchMapping(value = "updateContact")
    public @ResponseBody
    ResponseEntity updateContact(@RequestBody Contact contact) {
        contactBookUtil.updateContactDetails(contact);
        return new ResponseEntity(HttpStatus.OK);
    }
}
