package com.project.contactBook.controller;

import com.project.contactBook.util.ContactBookUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class PhoneNumberController {

    @Autowired
    ContactBookUtil contactBookUtil;

    @PostMapping(value = "addPhoneNumber")
    public String addPhoneNumber(@RequestBody String json) throws IOException {
       return contactBookUtil.addPhoneNumber(json);
    }

    @PatchMapping(value = "updatePhoneNumber")
    public String updatePhoneNumber(@RequestBody String json) throws IOException {
       return contactBookUtil.updatePhoneNumber(json);
    }
}
