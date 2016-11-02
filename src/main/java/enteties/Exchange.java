package enteties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Анна on 2/11/2016.
 */

@Entity
@Table(name = "exchange")
public class Exchange {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idexchange")
    @Id
    private int idexchange;

    @Column(name = "nameexchange")
    private int nameexchange;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "exchanges")
    private List<Share> shares;

    public Exchange() {
        shares = new ArrayList<>();
    }

    public Exchange(int nameexchange, List<Share> shares) {
        this.nameexchange = nameexchange;
        this.shares = shares;
    }

    public int getIdexchange() {
        return idexchange;
    }

    public void setIdexchange(int idexchange) {
        this.idexchange = idexchange;
    }

    public int getNameexchange() {
        return nameexchange;
    }

    public void setNameexchange(int nameexchange) {
        this.nameexchange = nameexchange;
    }

    public List<Share> getShares() {
        return shares;
    }

    public void setShares(List<Share> shares) {
        this.shares = shares;
    }
}
