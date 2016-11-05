package dao.interfaces;

import enteties.Company;

import java.util.List;

public interface CompanyDAO {
    void create(Company company);

    List<Company> findAllCompanies();

    void update(int id, Company company);

    void delete(int id);

    Company read(int id);
}
