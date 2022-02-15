package org.turing.service;

import org.turing.dao.GenericDaoImpl;
import org.turing.model.Car;

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
