package com.example.demo.repository;

import com.example.demo.entity.Student;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

//public interface StudentRepository extends JpaRepository<Student, Long> {}
public interface StudentRepository extends JpaRepository<Student, Long>{

    @Modifying
    @Transactional
    @Query(value = "TRUNCATE TABLE student RESTART IDENTITY", nativeQuery = true)
    void truncateTable();

}