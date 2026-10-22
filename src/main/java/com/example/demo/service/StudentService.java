package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

import io.micrometer.core.instrument.MeterRegistry;

@Service
public class StudentService {

    private final StudentRepository repository;
    private final MeterRegistry meterRegistry;

    public StudentService(StudentRepository repository,
                         MeterRegistry meterRegistry) {

        this.repository = repository;
        this.meterRegistry = meterRegistry;
    }

    public List<Student> findAll() {

        meterRegistry.counter("student.fetch.count")
                     .increment();

        return repository.findAll();
    }

    public Student save(Student student) {
        return repository.save(student);
    }

    public void truncateStudents() {
        repository.truncateTable();
    }
}