package org.turing.model.producer;

import org.turing.model.Rental;
import org.turing.service.CarService;
import org.turing.service.CustomerService;
import org.turing.service.EmployeeService;
import org.turing.service.RentalService;
import org.turing.util.EntityManagerUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Produces some test data for the {@link Rental} model.
 *
 * @author Youcef Wippert
 */
public class RentalProducer {
    private static CarService carService = new CarService();
    private static CustomerService customerService = new CustomerService();
    private static EmployeeService employeeService = new EmployeeService();
    private static RentalService rentalService = new RentalService();

    public static void main(String[] args) {
        produce();
        EntityManagerUtil.closeEntityManagerFactory();
    }

    private static void produce() {
        List<Rental> list = new ArrayList<>();

        list.add(new Rental("13.08.2022", carService.findById(1L), customerService.findById(1L),
                employeeService.findById(2L), "02.09.2022", 0, ""));
        list.add(new Rental("16.04.2022", carService.findById(7L), customerService.findById(3L),
                employeeService.findById(2L), "25.04.2022", 200, "Full Explosion"));
        list.add(new Rental("01.06.2022", carService.findById(5L), customerService.findById(2L),
                employeeService.findById(3L), "10.06.2022", 0, ""));
        list.add(new Rental("25.10.2022", carService.findById(10L), customerService.findById(5L),
                employeeService.findById(4L), "12.11.2022", 0, ""));
        list.add(new Rental("18.02.2022", carService.findById(8L), customerService.findById(4L),
                employeeService.findById(5L), "20.03.2022", 0, ""));
        list.add(new Rental("13.03.2022", carService.findById(2L), customerService.findById(6L),
                employeeService.findById(7L), "25.03.2022", 0, ""));
        list.add(new Rental("20.10.2022", carService.findById(11L), customerService.findById(7L),
                employeeService.findById(6L), "01.11.2022", 0, ""));
        list.add(new Rental("25.03.2022", carService.findById(6L), customerService.findById(10L),
                employeeService.findById(3L), "03.05.2022", 0, ""));
        list.add(new Rental("10.08.2022", carService.findById(4L), customerService.findById(9L),
                employeeService.findById(1L), "20.08.2022", 300, "Tire flat"));
        list.add(new Rental("06.07.2022", carService.findById(3L), customerService.findById(8L),
                employeeService.findById(6L), "10.08.2022", 0, ""));

        for (Rental rental : list) {
            rentalService.persist(rental);
        }
    }
}
