package com.cydercode.oracledemo;

import java.util.List;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.cydercode.oracledemo.model.Department;
import com.cydercode.oracledemo.model.Employee;
import com.cydercode.oracledemo.model.Job;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeService {
    
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @EventListener
    @Transactional
    public void init(ContextRefreshedEvent ev) {
        employeeRepository.findAll().forEach(this::printEmployee);
    }

    private void printEmployee(Employee employee) {
        var dpt = employee.getDepartment();
        log.info("Employee id: {}, {} {}", employee.getId(), employee.getFirstName(), employee.getLastName());
        log.info("Job info: {}, salary ({} - {})", employee.getJob().getJobTitle(), employee.getJob().getMinSalary(), employee.getJob().getMaxSalary());
        printDpt(dpt);
        printJobHistory(employee.getJobHistory());
        log.info("=================");
    }

    private void printJobHistory(List<Job> jobHistory) {
        jobHistory.forEach(this::printJob);
    }

    private void printDpt(Department dpt) {
        if(dpt == null) {
            return;
        }

        log.info("DptId: {}, dptName: {}, manager: {}", dpt.getId(), dpt.getDepartmentName(), dpt.getManager().getFirstName() + " " + dpt.getManager().getLastName());
        log.info("Location: {} - {}", dpt.getLocation().getCity(), dpt.getLocation().getCountry().getCountryName());
    }

    private void printJob(Job job1) {
        log.info("\t\t JOB: {}", job1.getJobTitle());
    }
}
