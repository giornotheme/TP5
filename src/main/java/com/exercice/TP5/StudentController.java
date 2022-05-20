package com.exercice.TP5;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
public class StudentController {

    static Student student1 = new Student(1, "mescouilles", "123456789");
    static Student student2 = new Student(2, "auborddeleau", "123456789");
    static Student student3 = new Student(3, "cafaitunradeau", "123456789");
    private static final Map<Integer, Student> STUDENT_MAP = Map.of(student1.getId(), student1, student2.getId(), student2, student3.getId(), student3);

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable("id") int id) {
        var student = STUDENT_MAP.get(id);
        if (student == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No student with id (" + id + ")");
        } else {
            return student;
        }
    }

    @GetMapping("/students")
    public Map<Integer, Student> getAllStudents() {

        return STUDENT_MAP;
    }

}
