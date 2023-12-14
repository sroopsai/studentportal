package com.roopsai.studentportal.studentregister.persistence;

import com.fasterxml.jackson.annotation.JsonTypeId;
import com.roopsai.studentportal.studentregister.domain.Student;
import com.roopsai.studentportal.studentregister.domain.StudentRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryStudentRepository implements StudentRepository {

    private static final Map<String, Student> students = new ConcurrentHashMap<>();



    @Override
    public Student save(Student student) {
        students.put(student.id(), student);
        return student;
    }

    @Override
    public Iterable<Student> findAll() {
        return students.values();
    }

    @Override
    public boolean exists(String id) {
        return students.get(id) != null;
    }

    @Override
    public Optional<Student> find(String id) {
        return exists(id) ? Optional.of(students.get(id)) : Optional.empty();
    }

    @Override
    public void delete(String id) {
        students.remove(id);
    }


}
