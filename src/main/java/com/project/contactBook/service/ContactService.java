package com.project.contactBook.service;


import com.project.contactBook.entity.Contact;

public interface ContactService extends BaseDbMethod<Contact> {
    boolean isContactExists(Long id);
}
