package com.codelife.department.service;

import com.codelife.department.entity.Department;
import com.codelife.department.reporsitory.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        return departmentRepository.saveAndFlush(department);
    }

    public Department findByDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).get();
    }
}
