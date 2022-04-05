package org.turing.dao;

import java.util.List;

/**
 * Schnittstelle für die Data Access Object (DAO)-Schicht.
 * <p>
 * Definiert grundlegende CRUD-Methoden sowie Methoden zur Handhabung von Entity Managern und Transaktionen.
 *
 * @param <T> Typen der Entity
 * @author Mufadhal, Ruand
 */
public interface GenericDao<T> {
    /**
     * ält eine bestimmte Entity fest (Erstellen).
     *
     * @param entity Instanz einer Entity
     */
    void persist(T entity);

    /**
     * Findet eine einzelne Entity anhand ihrer ID (Lesen).
     *
     * @param id primärer Key
     * @return die gefundene Entity-Instanz oder null, wenn die Entität nicht existiert
     */
    T findById(Long id);

    /**
     * Findet alle Entity (Read).
     *
     * @return eine Liste der gefundenen Entity-Instanzen oder eine leere Liste, wenn keine Entities existieren
     */
    List<T> findAll();

    /**
     * Findet alle Entities, die einem Filter entsprechen (Read).
     *
     * @param field      Entity Feld
     * @param comparator vergleicher, z.B. {@code >} oder {@code <}
     * @param value      Wert zum Filtern
     * @return eine Liste der gefundenen Entity-Instanzen oder eine leere Liste, wenn keine Entitäten dem Filter entsprechen
     */
    List<T> filter(String field, String comparator, String value);

    /**
     * Aktualisiert eine bestimmte Entity (Update).
     *
     * @param entity Entity Instanz
     */
    void update(T entity);

    /**
     * Löscht eine bestimmte Entity (Delete).
     *
     * @param entity Entity Instanz
     */
    void delete(T entity);

    /**
     * Löscht alle bestimmte Entity (Delete).
     */
    void deleteAll();

    /**
     * Erstellt einen Entity Manager.
     */
    void createEntityManager();

    /**
     * Schließt einen Entity Manager.
     */
    void closeEntityManager();

    /**
     * Beginnt eine Transaktion.
     */
    void beginTransaction();

    /**
     * Bestätigt eine Transaktion.
     */
    void commitTransaction();
}
