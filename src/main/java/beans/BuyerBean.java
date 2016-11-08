package beans;

import dao.impl.BuyerDAOimpl;
import enteties.Buyer;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.util.List;

@ManagedBean(name = "buyerBean")
public class BuyerBean {

    @ManagedProperty(value = "#{buyer}")
    private Buyer buyer = new Buyer();

    private BuyerDAOimpl buyerDAOimpl = new BuyerDAOimpl();

    public List<Buyer> findAllBuyers() {
        List buyers = buyerDAOimpl.findAllBuyers();
        return buyers;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public void create(Buyer buyer) {
        buyerDAOimpl.create(buyer);
    }

    public void delete(int buyerID) {
        buyerDAOimpl.delete(buyerID);
    }

    public void update(int id, Buyer buyerUpdate){
        buyerDAOimpl.update(id, buyerUpdate);
    }
}
