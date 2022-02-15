package org.turing.service;

import de.htwsaar.prog3.carrental.dao.GenericDaoImpl;
import de.htwsaar.prog3.carrental.model.Employee;

/**
 * Service layer implementation for the {@link Employee} model.
 *
 * @author Julian Quint, Arthur Kelsch
 * @see GenericServiceImpl
 */
public class EmployeeService extends GenericServiceImpl<Employee> {
    public EmployeeService() {
        dao = new GenericDaoImpl<>(Employee.class);
    }
}
