package org.turing.service;

import org.turing.dao.GenericDaoImpl;
import org.turing.model.Car;

/**
 * Implementierung des Services für das {@link Car} Modell.
 *
 * @author Jan
 * @see GenericServiceImpl
 */
public class CarService extends GenericServiceImpl<Car> {
    public CarService() {
        dao = new GenericDaoImpl<>(Car.class);
    }
}
