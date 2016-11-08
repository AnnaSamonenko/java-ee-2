package dao.impl;

import dao.interfaces.CompanyDAO;
import enteties.Company;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class CompanyDAOimpl implements CompanyDAO {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Share");
    private EntityManager entitymanager = entityManagerFactory.createEntityManager();

    public void create(Company company) {
        entitymanager.getTransaction().begin();
        entitymanager.persist(company);
        entitymanager.getTransaction().commit();
        entitymanager.close();
    }

    public List<Company> findAllCompanies() {
        EntityManager entitymanager = entityManagerFactory.createEntityManager();
        Query query = entitymanager.createQuery("Select company from Company company");
        return (ArrayList<Company>) query.getResultList();
    }

    public void update(int id, Company update) {
        EntityManager entitymanager = entityManagerFactory.createEntityManager();
        Company company = entitymanager.find(Company.class, id);
        company.setCompanyName(update.getCompanyName());
        company.setCompanyLocation(update.getCompanyLocation());
        company.setCompanyFoundationYear(update.getCompanyFoundationYear());
        entitymanager.getTransaction().begin();
        entitymanager.merge(company);
        entitymanager.getTransaction().commit();
        entitymanager.close();
    }

    public void delete(int id) {
        EntityManager entitymanager = entityManagerFactory.createEntityManager();
        Company company = entitymanager.find(Company.class, id);
        entitymanager.getTransaction().begin();
        entitymanager.remove(company);
        entitymanager.getTransaction().commit();
        entitymanager.close();
    }

    public Company read(int id) {
        EntityManager entitymanager = entityManagerFactory.createEntityManager();
        entitymanager.getTransaction().begin();
        Company company = entitymanager.find(Company.class, id);
        entitymanager.getTransaction().commit();
        entitymanager.close();
        return company;
    }
}
