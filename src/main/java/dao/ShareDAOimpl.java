package dao;

import enteties.Share;
import org.apache.log4j.Logger;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "shareBean")
public class ShareDAOimpl implements ShareDAO {
    private EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Share");
    private EntityManager entitymanager = emfactory.createEntityManager();
    // logging
    private static final Logger log = Logger.getLogger(ShareDAOimpl.class);

    public void create(Share sh) {
        entitymanager.getTransaction().begin();
        entitymanager.persist(sh);
        entitymanager.getTransaction().commit();
        entitymanager.close();
        log.info("Create share: " + sh.getName() + " " + sh.getPrice());
    }

    public void update(int id, Share update) {
        Share sh = entitymanager.find(Share.class, id);
        sh.setType(update.getType());
        sh.setName(update.getName());
        sh.setPrice(update.getPrice());
        entitymanager.getTransaction().begin();
        entitymanager.persist(sh);
        entitymanager.getTransaction().commit();
        entitymanager.close();
        log.info("Update stock with id: " + id);
    }

    public void delete(int id) {
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

    public Share read(int id){
        Share sh = entitymanager.find(Share.class, id);
        return sh;
    }
}
