package org.turing.service;

import org.turing.dao.GenericDaoImpl;
import org.turing.model.Employee;

/**
 * Implementierung des Services für das {@link Employee} Modell.
 *
 * @author Jan, Valerij
 * @see GenericServiceImpl
 */
public class EmployeeService extends GenericServiceImpl<Employee> {
    public EmployeeService() {
        dao = new GenericDaoImpl<>(Employee.class);
    }
}
