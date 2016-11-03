package enteties;

import javax.faces.bean.ManagedBean;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "exchange")
@ManagedBean(name = "exchange")
public class Exchange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idexchange")
    private int idexchange;

    @Column(name = "nameexchange")
    private String nameexchange;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "exchanges")
    private List<Share> shares = new ArrayList<>();

    public Exchange() {
    }

    public Exchange(String nameexchange, List<Share> shares) {
        this.nameexchange = nameexchange;
        this.shares = shares;
    }

    public int getIdexchange() {
        return idexchange;
    }

    public void setIdexchange(int idexchange) {
        this.idexchange = idexchange;
    }

    public String getNameexchange() {
        return nameexchange;
    }

    public void setNameexchange(String nameexchange) {
        this.nameexchange = nameexchange;
    }

    public List<Share> getShares() {
        return shares;
    }

    public void setShares(List<Share> shares) {
        this.shares = shares;
    }
}
