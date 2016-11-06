package dao.impl;

import dao.interfaces.ExchangeDAO;
import enteties.Exchange;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ExchangeDAOimpl implements ExchangeDAO {
    private EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Share");
    private EntityManager entitymanager = emfactory.createEntityManager();
    private static final Logger log = Logger.getLogger(ExchangeDAOimpl.class);

    /**
     * Create exchange
     *
     * @param exchange
     */
    public void create(Exchange exchange) {
        entitymanager.getTransaction().begin();
        entitymanager.persist(exchange);
        entitymanager.getTransaction().commit();
        entitymanager.close();
    }

    /**
     * @return all exchanges
     */
    public List<Exchange> findAllExchanges() {
        EntityManager entitymanager = emfactory.createEntityManager();
        Query query = entitymanager.createQuery("Select ex from Exchange ex");
        return (ArrayList<Exchange>) query.getResultList();
    }

    /**
     * Update name of Exchange
     *
     * @param id
     * @param update
     */
    public void update(int id, Exchange update) {
        EntityManager entitymanager = emfactory.createEntityManager();
        Exchange ex = entitymanager.find(Exchange.class, id);
        ex.setName(update.getName());
        entitymanager.getTransaction().begin();
        entitymanager.persist(ex);
        entitymanager.getTransaction().commit();
        entitymanager.close();
        log.info("Update exchange with id: " + id);
    }

    /**
     * Delete exchanges by id
     *
     * @param id
     */
    public void delete(int id) {
        EntityManager entitymanager = emfactory.createEntityManager();
        Exchange ex = entitymanager.find(Exchange.class, id);
        entitymanager.getTransaction().begin();
        entitymanager.remove(ex);
        entitymanager.getTransaction().commit();
        entitymanager.close();
        log.info("Delete exchange with id: " + id);
    }

    /**
     * Read exchanges by id
     *
     * @param id
     * @return exchange
     */
    public Exchange read(int id) {
        EntityManager entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();
        Exchange ex = entitymanager.find(Exchange.class, id);
        entitymanager.getTransaction().commit();
        entitymanager.close();
        return ex;
    }
}
