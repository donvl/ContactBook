package com.project.contactBook.controller;

import com.project.contactBook.entity.PhoneNumber;
import com.project.contactBook.util.ContactBookUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PhoneNumberController {

    @Autowired
    ContactBookUtil contactBookUtil;

    @PostMapping(value = "addPhoneNumber")
    public @ResponseBody
    ResponseEntity addPhoneNumber(@RequestBody PhoneNumber number) {
        contactBookUtil.addPhoneNumber(number);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PatchMapping(value = "updatePhoneNumber")
    public @ResponseBody
    ResponseEntity updatePhoneNumber(@RequestBody PhoneNumber number) {
        contactBookUtil.updatePhoneNumber(number);
        return new ResponseEntity(HttpStatus.OK);
    }
}
