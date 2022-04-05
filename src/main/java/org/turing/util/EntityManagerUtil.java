package org.turing.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Diese Klasse stellt sicher, dass wir nur eine einzige EntityManagerFactory verwenden
 * Instanz, da es sich um schwergewichtige Objekte handelt.
 *
 * @author Mohammad
 */
public final class EntityManagerUtil {
    private static final String PERSISTENCE_UNIT_NAME = "car-rental";

    private static EntityManagerFactory emf;

    private EntityManagerUtil() {
    }

    /**
     * Initialisiert das {@link EntityManagerFactory} Feld {@link #emf} wenn es leer oder derzeit geschlossen ist
     * und gibt es zurück.
     *
     * @return Das initialisierte {@link EntityManagerFactory}
     */
    public static EntityManagerFactory createEntityManagerFactory() {
        if (emf == null || !emf.isOpen()) {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }

        return emf;
    }

    /**
     * Schließt das {@link EntityManagerFactory} wenn sie nicht Null ist und derzeit offen ist.
     */
    public static void closeEntityManagerFactory() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
