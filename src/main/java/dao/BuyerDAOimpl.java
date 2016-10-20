package dao;

import enteties.Buyer;
import org.apache.log4j.Logger;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Анна on 19/10/2016.
 */
@ManagedBean(name = "buyerBean")
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
        Query query = entitymanager.createQuery("Select b from Buyer b");
        return (ArrayList<Buyer>) query.getResultList();
    }

    public void update(int id, Buyer update) {
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
}
