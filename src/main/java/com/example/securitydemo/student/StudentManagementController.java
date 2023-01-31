package com.example.securitydemo.student;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

import static com.example.securitydemo.security.ApplicationUserRole.ADMIN;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1L, "Fran"),
            new Student(2L, "Nora"),
            new Student(3L, "Mosta")
    );

    @GetMapping
    @PreAuthorize(value = "hasAuthority('ROLE_ADMIN')")
    public static List<Student> getAllStudents() {
        System.out.println("getAllStudents");
        String a  = ADMIN.name();
        return STUDENTS;
    }

    @PostMapping
    public void createStudent(@RequestBody Student student) {
        System.out.println("Create " + student.getName());
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        System.out.println("Delete: " + studentId);
    }

    @PutMapping("{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId, @RequestBody Student student) {
        System.out.println(String.format("Update: %s %s", studentId, student.getName()));
    }


}
