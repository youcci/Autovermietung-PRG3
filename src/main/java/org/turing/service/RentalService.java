package org.turing.service;

import org.turing.dao.GenericDaoImpl;
import org.turing.model.Rental;

/**
 * Implementierung des Services für das {@link Rental} Model.
 *
 * @author Mufadhal, Ruand
 * @see GenericServiceImpl
 */
public class RentalService extends GenericServiceImpl<Rental> {
    public RentalService() {
        dao = new GenericDaoImpl<>(Rental.class);
    }
}
