package manageBeans;

import dao.impl.ExchangeDAOimpl;
import enteties.Exchange;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.util.List;

@ManagedBean(name = "exchangeBean")
public class ExchangeBean {

    @ManagedProperty(value = "#{exchange}")
    Exchange exchange = new Exchange();

    private ExchangeDAOimpl exchangeDAOimpl = new ExchangeDAOimpl();

    public List<Exchange> findAllExchanges() {
        List exchenges = exchangeDAOimpl.findAllExchanges();
        return exchenges;
    }

    public Exchange getExchange() {
        return exchange;
    }

    public void setExchange(Exchange exchange) {
        this.exchange = exchange;
    }

    public void create(Exchange exchange) {
        exchangeDAOimpl.create(exchange);
    }

    public void update(int id, Exchange exchange) {
        exchangeDAOimpl.update(id, exchange);
    }

    public void delete(int exchangeID) {
        exchangeDAOimpl.delete(exchangeID);
    }
}
