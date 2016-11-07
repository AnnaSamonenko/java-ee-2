package manageBeans;

import dao.impl.ExchangeDAOimpl;
import dao.impl.ShareDAOimpl;
import enteties.Exchange;
import enteties.Share;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.util.List;

@ManagedBean(name = "exchangeBean")
public class ExchangeBean {

    @ManagedProperty(value = "#{exchange}")
    Exchange exchange = new Exchange();

    private ExchangeDAOimpl exchangeDAOimpl = new ExchangeDAOimpl();
    private ShareDAOimpl shareDAOimpl = new ShareDAOimpl();

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

    public void addShare(int exchangeID, int shareID) {
        Exchange exchange = exchangeDAOimpl.read(exchangeID);
        Share share = shareDAOimpl.read(shareID);
        exchangeDAOimpl.update(exchangeID, share);
        shareDAOimpl.update(shareID, exchange);
    }
}
