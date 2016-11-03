package dao;

import enteties.BankAccount;

public interface BankAccountDAO {
    void create(BankAccount bankAccount);

    void update(int id, BankAccount bankAccount);

    void delete(int id);

    BankAccount read(int id);
}
