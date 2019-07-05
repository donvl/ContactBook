package com.project.contactBook.dao;


import com.project.contactBook.entity.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneNumberDao extends JpaRepository<PhoneNumber, Long>, JpaSpecificationExecutor<PhoneNumber> {
}
