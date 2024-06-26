package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Form;

@Repository
public interface FormRepository extends JpaRepository<Form, Integer> {

}
