package enteties;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

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

    private String name;

    private BigDecimal price;

    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idbuyer", nullable = true)
    @NotFound(action= NotFoundAction.IGNORE)
    private Buyer buyer;

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name = "stock_exchange")
    private List<Exchange> exchanges;

    public Share() {
        buyer = new Buyer();
        exchanges = new ArrayList<>();
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
