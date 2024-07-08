package com.example.minor_project1.dtos;

import com.example.minor_project1.models.Student;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
//@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateStudentRequest {

    private String name;

    private String email;

    private String mobile;

    public Student mapToStudent(){
        return Student.builder()
                .name(this.name)
                .mobile(this.mobile)
                .email(this.email)
                .build();
    }

}