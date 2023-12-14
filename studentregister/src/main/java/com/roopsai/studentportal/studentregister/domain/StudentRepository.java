package com.roopsai.studentportal.studentregister.domain;

import java.util.Optional;

public interface StudentRepository {

    Student save(Student student);
    Iterable<Student> findAll();

    Optional<Student> find(Student student);
    boolean exists(Student student);
    void delete(Student student);


}
