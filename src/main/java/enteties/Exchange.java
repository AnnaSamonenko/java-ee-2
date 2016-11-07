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
    @Column(name = "id_exchange")
    private int id;

    @Column(name = "name_exchange")
    private String name;

    @ManyToMany(mappedBy = "exchanges", fetch = FetchType.EAGER)
    private List<Share> shares = new ArrayList<>();

    public Exchange() {
    }

    public Exchange(String name, List<Share> shares) {
        this.name = name;
        this.shares = shares;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Share> getShares() {
        return shares;
    }

    public void setShares(List<Share> shares) {
        this.shares = shares;
    }
}
