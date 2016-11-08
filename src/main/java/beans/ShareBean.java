package beans;

import dao.impl.ShareDAOimpl;
import enteties.Share;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "shareBean")
@RequestScoped
public class ShareBean {

    @ManagedProperty(value = "#{share}")
    private Share share = new Share();

    private ShareDAOimpl shareDAOimpl = new ShareDAOimpl();

    public List<Share> findAllShares() {
        List shares = shareDAOimpl.findAllShares();
        return shares;
    }

    public Share getShare() {
        return share;
    }

    public void setShare(Share share) {
        this.share = share;
    }

    public void create(Share share, int companyID, int buyerID) {
        shareDAOimpl.create(share, companyID, buyerID);
    }

    public void delete(int shareID) {
        shareDAOimpl.delete(shareID);
    }

    public void update(int shareID, int newPrice) {
        shareDAOimpl.update(shareID, newPrice);
    }

    public ArrayList<Share> sellingShare(){
        return shareDAOimpl.sellingShare();
    }
}
