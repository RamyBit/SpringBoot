package com.example.springbootcrud.modul;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message= "Name is required")
    private String name;
    @NotBlank(message = "Email is required")
    private String email;
    @Min(value=0, message="Salary must be greater than or equal to 0")
    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public long getId(){
        return id;
    }
    public void setId(Long id){this.id = id;}
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
