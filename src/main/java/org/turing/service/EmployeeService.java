package org.turing.service;

import org.turing.dao.GenericDaoImpl;
import org.turing.model.Employee;

/**
 * Service layer implementation for the {@link Employee} model.
 *
 * @author Jan, Valerij
 * @see GenericServiceImpl
 */
public class EmployeeService extends GenericServiceImpl<Employee> {
    public EmployeeService() {
        dao = new GenericDaoImpl<>(Employee.class);
    }
}
