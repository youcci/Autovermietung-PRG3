package org.turing.dao;

import org.turing.util.EntityManagerUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * {@link GenericDao} Implementation.
 *
 * @param <T> Typ der Entity
 * @author Mufadhal, Ruand
 */
public class GenericDaoImpl<T> implements GenericDao<T> {
    private final Class<T> entityClass;

    private EntityManagerFactory emf;
    private EntityManager em;

    /**
     * Konstruiert ein GenericDaoImpl-Objekt.
     * <p>
     * Erfordert die Übergabe des Klassentyps als {@link Class} Objekt
     * so dass wir uns nicht auf die Reflexion verlassen müssen, um festzustellen {@link T} während der Laufzeit.
     * <p>
     * Dies gewährleistet Typensicherheit und verhindert ungeprüfte Übertragungen.
     *
     * @param entityClass Klassenobjekt vom Typ {@link T} (d.h. {@code Car.class})
     */
    public GenericDaoImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
        emf = EntityManagerUtil.createEntityManagerFactory();
    }

    @Override
    public void persist(T entity) {
        em.persist(entity);
    }

    @Override
    public T findById(Long id) {
        return em.find(entityClass, id);
    }

    @Override
    public List<T> findAll() {
        String query = "SELECT t FROM %s t";
        query = String.format(query, entityClass.getSimpleName());

        return em.createQuery(query, entityClass).getResultList();
    }

    @Override
    public List<T> filter(String field, String comparator, String value) {
        String query = "SELECT t FROM %s t WHERE t.%s %s %s";
        query = String.format(query, entityClass.getSimpleName(), field, comparator, value);

        return em.createQuery(query, entityClass).getResultList();
    }

    @Override
    public void update(T entity) {
        em.merge(entity);
    }

    @Override
    public void delete(T entity) {
        em.remove(entity);
    }

    @Override
    public void deleteAll() {
        String query = "DELETE FROM %s";
        query = String.format(query, entityClass.getSimpleName());

        em.createQuery(query).executeUpdate();
    }

    @Override
    public void createEntityManager() {
        em = emf.createEntityManager();
    }

    @Override
    public void closeEntityManager() {
        em.close();
    }

    @Override
    public void beginTransaction() {
        em.getTransaction().begin();
    }

    @Override
    public void commitTransaction() {
        em.getTransaction().commit();
    }
}
