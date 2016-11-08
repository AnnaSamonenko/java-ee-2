package dao.impl;

import dao.interfaces.BuyerDAO;
import enteties.Buyer;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class BuyerDAOimpl implements BuyerDAO {

    private EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Share");
    private EntityManager entitymanager = emfactory.createEntityManager();
    private static final Logger log = Logger.getLogger(BuyerDAOimpl.class);

    public void create(Buyer buyer) {
        entitymanager.getTransaction().begin();
        entitymanager.persist(buyer);
        entitymanager.getTransaction().commit();
        entitymanager.close();
        log.info("Create buyer: " + buyer.getName() + " " + buyer.getSurname());
    }

    public List<Buyer> findAllBuyers() {
        EntityManager entitymanager = emfactory.createEntityManager();
        Query query = entitymanager.createQuery("Select b from Buyer b");
        return (ArrayList<Buyer>) query.getResultList();
    }

    public void update(int id, Buyer update) {
        EntityManager entitymanager = emfactory.createEntityManager();
        Buyer b = entitymanager.find(Buyer.class, id);
        b.setAddress(update.getAddress());
        b.setName(update.getName());
        b.setSurname(update.getSurname());
        entitymanager.getTransaction().begin();
        entitymanager.persist(b);
        entitymanager.getTransaction().commit();
        entitymanager.close();
        log.info("Update buyer with id: " + id);
    }

    public void delete(int id) {
        EntityManager entitymanager = emfactory.createEntityManager();
        Buyer b = entitymanager.find(Buyer.class, id);
        entitymanager.getTransaction().begin();
        entitymanager.remove(b);
        entitymanager.getTransaction().commit();
        entitymanager.close();
        log.info("Delete buyer with id: " + id);
    }

    public Buyer read(int id){
        EntityManager entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();
        Buyer b = entitymanager.find(Buyer.class, id);
        entitymanager.getTransaction().commit();
        entitymanager.close();
        return b;
    }

    public ArrayList<Buyer> buyersWithoutBankAccount(){
        EntityManager entitymanager = emfactory.createEntityManager();
        Query query = entitymanager.createQuery("select buyer from Buyer buyer where buyer.bankAccount is NULL");
        return (ArrayList<Buyer>) query.getResultList();
    }
}
