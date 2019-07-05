package com.project.contactBook.dao;


import com.project.contactBook.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactDao extends JpaRepository<Contact, Long>, JpaSpecificationExecutor<Contact> {
}
