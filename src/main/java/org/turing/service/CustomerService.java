package org.turing.service;

import org.turing.dao.GenericDaoImpl;
import org.turing.model.Customer;

/**
 * Service layer implementation for the {@link Customer} model.
 *
 * @author Julian Quint, Arthur Kelsch
 * @see GenericServiceImpl
 */
public class CustomerService extends GenericServiceImpl<Customer> {
    public CustomerService() {
        dao = new GenericDaoImpl<>(Customer.class);
    }
}
