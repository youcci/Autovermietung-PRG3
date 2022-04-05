package org.turing.service;

import org.turing.dao.GenericDao;

import java.util.List;

/**
 * Schnittstelle für die Serviceschicht.
 * <p>
 * Neben der Verwendung von Methoden aus der DAO-Schicht verwaltet die Serviceschicht auch Entity Manager und Transaktionen.
 *
 * @param <T> Typ der Entity
 * @author Mufadhal, Ruand
 * @see GenericDao
 */
public interface GenericService<T> {
    /**
     * Hält eine gegebene Entity.
     *
     * @param entity Entity Instanz
     * @see GenericDao#persist(Object)
     */
    void persist(T entity);

    /**
     * Findet eine Entity anhand ihrer ID
     *
     * @param id primärer Key
     * @return die gefundene Entity-Instanz oder null, wenn die Entity nicht existiert
     * @see GenericDao#findById(Long)
     */
    T findById(Long id);

    /**
     * Findet alle Entitäten
     *
     * @return eine Liste der gefundenen Entity-Instanzen oder eine leere Liste, wenn keine Entity existieren
     * @see GenericDao#findAll()
     */
    List<T> findAll();

    /**
     * Findet alle Entities die dem Filter entsprechen
     *
     * @param field      Entity Feld
     * @param comparator vergleicher, d.h. {@code >} oder {@code <}
     * @param value      Wert zum filtern
     * @return eine Liste der gefundenen Entity-Instanzen oder eine leere Liste, wenn keine Entities dem Filter entsprechen
     * @see GenericDao#filter(String, String, String)
     */
    List<T> filter(String field, String comparator, String value);

    /**
     * Aktualisiert eine bestimmte Entity
     *
     * @param entity entity instance
     * @see GenericDao#update(Object)
     */
    void update(T entity);

    /**
     * Löscht eine bestimmte Entity
     *
     * @param entity entity instance
     * @see GenericDao#delete(Object)
     */
    void delete(T entity);

    /**
     * Löscht eine bestimmte Entity anhand ihrer ID
     *
     * @param id primary key
     * @see GenericService#delete(Object)
     */
    void deleteById(Long id);

    /**
     * Löscht alle Entities.
     *
     * @see GenericDao#deleteAll()
     */
    void deleteAll();
}
