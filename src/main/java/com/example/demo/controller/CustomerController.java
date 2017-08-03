package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.repository.customerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.text.SimpleDateFormat;
import java.util.stream.Stream;


/**
 * Created by Usuario on 15/06/2017.
 */

@RestController(value = "customers")
public class CustomerController {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    //@Autowired
    DataSource dataSource;

    @Autowired
    customerRepository CustomerRepository;

    @RequestMapping("/create")
    @ResponseBody
    public String create(String email, String name) {
        System.out.println("DATASOURCE = " + dataSource);

        System.out.println("\n1.findAll()...");
        for (Customer customer : CustomerRepository.findAll()) {
            System.out.println(customer);
        }

        System.out.println("\n2.findByEmail(String email)...");
        for (Customer customer : CustomerRepository.findByEmail("222@yahoo.com")) {
            System.out.println(customer);
        }

        try{
            System.out.println("\n3.findByDate(Date date)...");
            for (Customer customer : CustomerRepository.findByDate(sdf.parse("2017-02-12"))) {
                System.out.println(customer);
            }
        }catch (Exception e){}

        // For Stream, need @Transactional
        System.out.println("\n4.findByEmailReturnStream(@Param(\"email\") String email)...");
        try (Stream<Customer> stream = CustomerRepository.findByEmailReturnStream("333@yahoo.com")) {
            stream.forEach(x -> System.out.println(x));
        }

        System.out.println("Done!");

        return "";
    }

}
