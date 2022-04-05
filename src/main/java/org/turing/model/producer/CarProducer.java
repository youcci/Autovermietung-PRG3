package org.turing.model.producer;

import org.turing.model.Car;
import org.turing.service.CarService;
import org.turing.util.EntityManagerUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Produziert bisschen Test Daten für das {@link Car} Modell
 *
 * @author Youcef Wippert, Ahmad Anwar
 */
public class CarProducer {
    private static CarService carService = new CarService();

    public static void main(String[] args) {
        produce();
        EntityManagerUtil.closeEntityManagerFactory();
    }

    private static void produce() {
        List<Car> list = new ArrayList<>();

        list.add(new Car("Nissan", "Coupe", "Blue", 2020, 320, null, 3, 4536, null, "Gasoline", "Automatic", 570,
                "SB YC 99", "GT-R", "10-2023", "2C", "Summer Tires", "1G2ZF57B464174326"));
        list.add(new Car("BMW", "Coupe", "Black", 2016, 120, null, 5, 23456, null, "Gasoline", "Manual", 303,
                "HOM GG 1234", "335i", "04-2024", "2A", "Summer Tires", "1FTJX35G4TKA95915"));
        list.add(new Car("Mercedes", "Sedan", "Grey", 2019, 150, null, 3, 10000, null, "Gasoline", "Automatic", 333,
                "SB AB 2018", "E 63", "08-2025", "3E", "Winter Tires", "JKAEXEA158A066488"));
        list.add(new Car("Lamborghini", "SUV", "Viper Green", 2022, 349, null, 3, 12500, null, "Gasoline", "Automatic", 510,
                "M OK 1337", "Urus", "08-2024", "1B", "Summer Tires", "1M2P264C1WM035115"));
        list.add(new Car("Mercedes", "SUV", "Red", 2012, 500, null, 3, 16000, null, "Gasoline", "Manual", 466,
                "SB AA 63", "ML 63 AMG", "06-2023", "4A", "Summer Tires", "5NPEC5AC5BH130519"));
        list.add(new Car("BMW", "Sedan", "Dark Grey", 1990, 130, null, 5, 50000, null, "Gasoline", "Manual", 215,
                "SB E 30", "M3", "10-2019", "2D", "Summer Tires", "3C6JR6AG1DG512299"));
        list.add(new Car("VW", "Hatchback", "White", 2016, 30, null, 3, 5000, null, "Diesel", "Manual", 90,
                "HD UP 314", "UP", "08-2022", "5A", "Mixed Tires", "19XFB2F5XEE218674"));
        list.add(new Car("Toyota", "Hatchback", "Purple", 2021, 125, null, 3, 43543, null, "Hybrid", "Manual", 200,
                "SB GT 86", "Corolla", "02-2019", "1F", "Winter Tires", "3TMLU42N99M032229"));

        for (Car car : list) {
            carService.persist(car);
        }
    }
}
