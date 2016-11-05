package dao.interfaces;

import enteties.BankAccount;

public interface BankAccountDAO {
    void create(int buyerID);

    void update(int id, BankAccount bankAccount);

    void delete(int id);

    BankAccount read(int id);
}
