package dao;

import enteties.Buyer;

import java.util.List;

/**
 * Created by Анна on 19/10/2016.
 */

public interface BuyerDAO {
    void create(Buyer buyer);

    List<Buyer> findAllBuyers();

    void update(int id, Buyer buyer);

    void delete(int id);

    Buyer read(int id);
}
