package com.roopsai.studentportal.studentregister.domain;

import java.util.Optional;

public interface StudentRepository {

    Student save(Student student);
    Iterable<Student> findAll();

    Optional<Student> find(String id);
    boolean exists(String id);
    void delete(String id);


}
