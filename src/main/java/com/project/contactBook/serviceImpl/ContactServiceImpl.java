package com.project.contactBook.serviceImpl;


import com.project.contactBook.dao.ContactDao;
import com.project.contactBook.entity.Contact;
import com.project.contactBook.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactDao contactDao;

    @Override
    public Contact finById(Long id) {
        return contactDao.getOne(id);
    }

    @Override
    public List<Contact> findAll() {
        return contactDao.findAll();
    }

    @Override
    public Contact create(Contact obj) {
        return contactDao.save(obj);
    }

    @Override
    public void delete(Contact obj) {
        contactDao.delete(obj);
    }

    @Override
    public void deleteById(Long id) {
        contactDao.deleteById(id);
    }

    @Override
    public void upDate(Contact obj) {
        contactDao.saveAndFlush(obj);
    }

}
