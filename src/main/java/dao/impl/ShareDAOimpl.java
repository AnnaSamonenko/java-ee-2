package dao.impl;

import dao.interfaces.ShareDAO;
import enteties.Buyer;
import enteties.Company;
import enteties.Exchange;
import enteties.Share;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ShareDAOimpl implements ShareDAO {
    private EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Share");
    private EntityManager entitymanager = emfactory.createEntityManager();
    // logging
    private static final Logger log = Logger.getLogger(ShareDAOimpl.class);

    public void create(Share share, int idCompany, int idBuyer) {
        EntityManager entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();
        Buyer buyer = entitymanager.find(Buyer.class, idBuyer);
        Company company = entitymanager.find(Company.class, idCompany);
        buyer.getShares().add(share);
        company.getShares().add(share);
        entitymanager.persist(share);
        entitymanager.getTransaction().commit();
        entitymanager.close();
    }

    public void update(int id, int newPrice) {
        EntityManager entitymanager = emfactory.createEntityManager();
        Share sh = entitymanager.find(Share.class, id);
        sh.setPrice(newPrice);
        entitymanager.getTransaction().begin();
        entitymanager.merge(sh);
        entitymanager.getTransaction().commit();
        entitymanager.close();
        log.info("Update stock with id: " + id);
    }

    public void update(int id, Exchange exchange) {
        EntityManager entitymanager = emfactory.createEntityManager();
        Share share = entitymanager.find(Share.class, id);
        share.getExchanges().add(exchange);
        entitymanager.getTransaction().begin();
        entitymanager.merge(share);
        entitymanager.getTransaction().commit();
        entitymanager.close();
        log.info("Update stock with id: " + id);
    }

    public void delete(int id) {
        EntityManager entitymanager = emfactory.createEntityManager();
        Share sh = entitymanager.find(Share.class, id);
        entitymanager.getTransaction().begin();
        entitymanager.remove(sh);
        entitymanager.getTransaction().commit();
        log.info("Delete stock with id: " + id);
    }

    public List<Share> findAllShares() {
        Query query = entitymanager.createQuery("Select sh from Share sh");
        return (ArrayList<Share>) query.getResultList();
    }

    public Share read(int id) {
        EntityManager entitymanager = emfactory.createEntityManager();
        Share sh = entitymanager.find(Share.class, id);
        return sh;
    }

    public ArrayList<Share> sellingShare(){
        EntityManager entitymanager = emfactory.createEntityManager();
        Query query = entitymanager.createQuery("select share from Share share where share.exchanges.size > 0");
        return (ArrayList<Share>) query.getResultList();
    }
}
