package com.example.demo.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Usuario on 15/06/2017.
 */
@Entity
public class Customer {

    // "customer_seq" is Oracle sequence name.
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
    @SequenceGenerator(sequenceName = "customer_seq", allocationSize = 1, name = "CUST_SEQ")
    Long id;

    String name;

    String email;

    @Column(name = "CREATED_DATE")
    Date date;

    //getters and setters, contructors
}