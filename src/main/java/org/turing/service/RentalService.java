package org.turing.service;

import org.turing.dao.GenericDaoImpl;
import org.turing.model.Rental;

/**
 * Service layer implementation for the {@link Rental} model.
 *
 * @author Mufadhal, Ruand
 * @see GenericServiceImpl
 */
public class RentalService extends GenericServiceImpl<Rental> {
    public RentalService() {
        dao = new GenericDaoImpl<>(Rental.class);
    }
}
