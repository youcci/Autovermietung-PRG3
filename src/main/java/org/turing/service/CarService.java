package org.turing.service;

import de.htwsaar.prog3.carrental.dao.GenericDaoImpl;
import de.htwsaar.prog3.carrental.model.Car;

/**
 * Service layer implementation for the {@link Car} model.
 *
 * @author Arthur Kelsch
 * @see GenericServiceImpl
 */
public class CarService extends GenericServiceImpl<Car> {
    public CarService() {
        dao = new GenericDaoImpl<>(Car.class);
    }
}
