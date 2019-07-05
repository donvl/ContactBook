package com.project.contactBook.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "phone_number")

public class PhoneNumber {
    @Id
    @Column(name = "phoneNumber_id")
    @SequenceGenerator(name = "phone_number_seq", sequenceName = "phone_number_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "phone_number_seq")
    private Long phoneNumberId;

    @Column(name = "operator_name")
    private String operatorName;

    @Column(name = "number")
    private String number;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_id")
    private Contact contact;
}
