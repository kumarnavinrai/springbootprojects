package com.codemyth.controller;

import com.codemyth.exception.DataNotFoundException;
import com.codemyth.model.Employee;
import com.codemyth.repository.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;
    //get
    @GetMapping("/get")
    public ResponseEntity<Object> getAllEmployee(){
        return ResponseEntity.status(HttpStatus.FOUND).body(employeeRepository.findAll());
    }

    //post - create - C
    @PostMapping("/save")
    public ResponseEntity<Object> create(@RequestBody @Valid Employee employee){
        employeeRepository.save(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body("Employee created successfully");
    }

    //put
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id,@RequestBody Employee employee){
        Optional<Employee> emp = employeeRepository.findById(id);
        if(emp.isPresent()){
            Employee existingEmp = emp.get();
            existingEmp.setAge(employee.getAge());
            existingEmp.setCity(employee.getCity());
            existingEmp.setName(employee.getName());
            employeeRepository.save(existingEmp);
            return ResponseEntity.status(HttpStatus.OK).body("Employee updated successfully for id "+ id);
        }else{
            throw new DataNotFoundException("Employee not found for id "+ id);
        }
    }
    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Integer id){
        employeeRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Employee deleted successfully for "+ id);
    }

}
