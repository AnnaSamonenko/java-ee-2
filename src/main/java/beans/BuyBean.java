package beans;

import dao.impl.BuyShareDAOimpl;
import dao.interfaces.BuyShareDAO;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "buyBean")
public class BuyBean {
    private BuyShareDAO buyShareDAO = new BuyShareDAOimpl();

    public void buy(int buyerID, int shareID) {
        buyShareDAO.buy(buyerID, shareID);
    }
}
