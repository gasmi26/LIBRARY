package com.example.minor_project1.controllers;

import com.example.minor_project1.dtos.CreateStudentRequest;
import com.example.minor_project1.dtos.GetStudentDetailResponse;
import com.example.minor_project1.dtos.UpdateStudentRequest;
import com.example.minor_project1.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping()
    public Integer createStudent(@Valid @RequestBody CreateStudentRequest request){
        return studentService.create(request);
    }

    @GetMapping("/{studentId}")
    public GetStudentDetailResponse getStudentDetails(
            @PathVariable("studentId") int studentId,
            @RequestParam(value = "require-book-list", required = false, defaultValue = "false") boolean requireBookList){
        return this.studentService.getStudentDetails(studentId, requireBookList);
    }

    @PatchMapping("/{studentId}")
    public GetStudentDetailResponse updateStudentDetails(
            @PathVariable("studentId") Integer studentId,
            @Valid @RequestBody UpdateStudentRequest request){

        return this.studentService.update(studentId, request);
    }

    @DeleteMapping("/{studentId}")
    public GetStudentDetailResponse deactivateStudent(
            @PathVariable("studentId") int studentId
    ){
        return studentService.deactivate(studentId);
    }
}