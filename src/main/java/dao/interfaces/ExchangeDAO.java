package dao.interfaces;

import enteties.Exchange;

import java.util.List;

/**
 * Created by Анна on 2/11/2016.
 */
public interface ExchangeDAO {
    void create(Exchange exchange);

    List<Exchange> findAllExchanges();

    void update(int id, Exchange exchange);

    void delete(int id);

    Exchange read(int id);
}
