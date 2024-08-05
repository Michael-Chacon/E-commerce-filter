package com.ecommerce.domain.repository;

import com.ecommerce.persistence.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
