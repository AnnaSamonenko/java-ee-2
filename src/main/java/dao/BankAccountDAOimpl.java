package dao;

import enteties.BankAccount;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BankAccountDAOimpl implements BankAccountDAO {
    private EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Share");
    private EntityManager entitymanager = emfactory.createEntityManager();
    private static final Logger log = Logger.getLogger(BankAccountDAOimpl.class);

    public void create(BankAccount bankAccount) {
        entitymanager.getTransaction().begin();
        entitymanager.persist(bankAccount);
        entitymanager.getTransaction().commit();
        entitymanager.close();
        log.info("Create bank account with id: " + bankAccount.getIdBankAccount());
    }

    public void update(int id, BankAccount update) {
        EntityManager entitymanager = emfactory.createEntityManager();
        BankAccount bankAccount = entitymanager.find(BankAccount.class, id);
        bankAccount.setMoneyOnBankAccount(update.getMoneyOnBankAccount());
        entitymanager.getTransaction().begin();
        entitymanager.persist(bankAccount);
        entitymanager.getTransaction().commit();
        entitymanager.close();
        log.info("Update bank account with id: " + id);
    }

    public void delete(int id) {
        EntityManager entitymanager = emfactory.createEntityManager();
        BankAccount bankAccount = entitymanager.find(BankAccount.class, id);
        entitymanager.getTransaction().begin();
        entitymanager.remove(bankAccount);
        entitymanager.getTransaction().commit();
        entitymanager.close();
        log.info("Delete banl account with id: " + id);
    }

    public BankAccount read(int id) {
        EntityManager entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();
        BankAccount bankAccount = entitymanager.find(BankAccount.class, id);
        entitymanager.getTransaction().commit();
        entitymanager.close();
        return bankAccount;
    }
}
