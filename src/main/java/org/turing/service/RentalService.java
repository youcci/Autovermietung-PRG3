package org.turing.service;

import de.htwsaar.prog3.carrental.dao.GenericDaoImpl;
import de.htwsaar.prog3.carrental.model.Rental;

/**
 * Service layer implementation for the {@link Rental} model.
 *
 * @author Julian Quint, Arthur Kelsch
 * @see GenericServiceImpl
 */
public class RentalService extends GenericServiceImpl<Rental> {
    public RentalService() {
        dao = new GenericDaoImpl<>(Rental.class);
    }
}
