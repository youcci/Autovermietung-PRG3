package org.turing.model.producer;

import org.turing.model.Employee;
import org.turing.service.EmployeeService;
import org.turing.util.EntityManagerUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Produziert bisschen Test Daten für das {@link Employee} Modell.
 *
 * @author Ahmad Anwar
 */
public class EmployeeProducer {
    private static EmployeeService employeeService = new EmployeeService();

    public static void main(String[] args) {
        produce();
        EntityManagerUtil.closeEntityManagerFactory();
    }

    private static void produce() {
        List<Employee> list = new ArrayList<>();

        list.add(new Employee("Son", "Goku", "CEO"));
        list.add(new Employee("Gill", "Bates", "Customer Advisor"));
        list.add(new Employee("Linus", "Sebastian", "Customer Advisor"));
        list.add(new Employee("Marcus", "Brownlee", "Customer Advisor"));
        list.add(new Employee("Patrick", "Star", "Customer Advisor"));
        list.add(new Employee("Tony", "Stark", "Customer Advisor"));
        list.add(new Employee("Don", "Juan", "Customer Advisor"));

        for (Employee employee : list) {
            employeeService.persist(employee);
        }
    }
}
