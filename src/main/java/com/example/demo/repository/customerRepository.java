package com.example.demo.repository;

import com.example.demo.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Usuario on 15/06/2017.
 */
public interface customerRepository  extends CrudRepository<Customer, Long>{
    List<Customer> findByEmail(String email);

    List<Customer> findByDate(Date date);

    // custom query example and return a stream
    @Query("select c from Customer c where c.email = :email")
    Stream<Customer> findByEmailReturnStream(@Param("email") String email);
}
