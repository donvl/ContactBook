package com.project.contactBook.serviceImpl;


import com.project.contactBook.dao.PhoneNumberDao;
import com.project.contactBook.entity.PhoneNumber;
import com.project.contactBook.service.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneNumberServiceImpl implements PhoneNumberService {

    @Autowired
    PhoneNumberDao phoneNumberDao;

    @Override
    public PhoneNumber finById(Long id) {
        return phoneNumberDao.getOne(id);
    }

    @Override
    public List<PhoneNumber> findAll() {
        return phoneNumberDao.findAll();
    }

    @Override
    public PhoneNumber create(PhoneNumber obj) {
        return phoneNumberDao.save(obj);
    }

    @Override
    public void delete(PhoneNumber obj) {
        phoneNumberDao.delete(obj);
    }

    @Override
    public void deleteById(Long id) {
        phoneNumberDao.deleteById(id);
    }

    @Override
    public void upDate(PhoneNumber obj) {
        phoneNumberDao.saveAndFlush(obj);
    }
}
