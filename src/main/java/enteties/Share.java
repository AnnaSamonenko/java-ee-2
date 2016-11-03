package enteties;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "share")
@ManagedBean(name = "share")
@RequestScoped
public class Share {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "type")
    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idbuyer")
    private Buyer buyer = new Buyer();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "stock_exchange", joinColumns = {
            @JoinColumn(name = "idstock", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "idexchange",
                    nullable = false, updatable = false)})
    private List<Exchange> exchanges = new ArrayList<>();

    public Share() {
    }

    public Share(String name, BigDecimal price, String type) {
        this.name = name;
        this.type = type;
        this.price = price;

    }

    public Share(String name, BigDecimal price, String type, Buyer buyer) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.buyer = buyer;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Exchange> getExchanges() {
        return exchanges;
    }

    public void setExchanges(List<Exchange> exchanges) {
        this.exchanges = exchanges;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof Share)) return false;
        Share otherShare = (Share) other;
        if (otherShare.getId() == this.getId()) {
            return true;
        } else {
            return false;
        }
    }
}
