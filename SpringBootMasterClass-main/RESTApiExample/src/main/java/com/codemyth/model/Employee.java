package com.codemyth.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotBlank(message = "Name can not be empty")
    private String name;
    @NotBlank(message = "City can not be empty")
    @Size(min = 3, max = 10, message = "City name must be between 3 and 10 characters")
    private String city;
    @Min(value = 18, message = "Age must be between 18 and 30")
    @Max(value = 30, message = "Age must be between 18 and 30")
    private Integer age;
}
