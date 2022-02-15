package org.turing.model.producer;

import org.turing.model.Employee;
import org.turing.service.EmployeeService;
import org.turing.util.EntityManagerUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Produces some test data for the {@link Employee} model.
 *
 * @author Julian Quint
 */
public class EmployeeProducer {
    private static EmployeeService employeeService = new EmployeeService();

    public static void main(String[] args) {
        produce();
        EntityManagerUtil.closeEntityManagerFactory();
    }

    private static void produce() {
        List<Employee> list = new ArrayList<>();

        list.add(new Employee("Elon", "Musk", "CEO"));
        list.add(new Employee("Bill", "Gates", "Customer Advisor"));
        list.add(new Employee("Jordan", "Belfort", "Customer Advisor"));
        list.add(new Employee("Peter", "Parker", "Customer Advisor"));
        list.add(new Employee("Linus", "Torvalds", "Customer Advisor"));
        list.add(new Employee("Neil", "Armstrong", "Customer Advisor"));
        list.add(new Employee("Leonardo", "Da Vinci", "Customer Advisor"));

        for (Employee employee : list) {
            employeeService.persist(employee);
        }
    }
}
