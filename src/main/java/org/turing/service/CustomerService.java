package org.turing.service;

import org.turing.dao.GenericDaoImpl;
import org.turing.model.Customer;

/**
 * Implementierung des Services für das  {@link Customer} Modell.
 *
 * @author Jan, Valerij
 * @see GenericServiceImpl
 */
public class CustomerService extends GenericServiceImpl<Customer> {
    public CustomerService() {
        dao = new GenericDaoImpl<>(Customer.class);
    }
}
