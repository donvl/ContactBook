package com.project.contactBook.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "contact")

public class Contact {
    @Id
    @Column(name = "contact_id")
    @SequenceGenerator(name = "contact_seq", sequenceName = "contact_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_seq")
    private Long contactId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "contact")
    private List<PhoneNumber> phoneNumbers;
}
