package enteties;

import javax.faces.bean.ManagedBean;
import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "buyer")
@ManagedBean(name="buyer")
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idbuyer")
    private int id;

    @Column(name = "buyer_name")
    private String name;

    @Column(name = "buyer_surname")
    private String surname;

    @Column(name = "buyer_address")
    private String address;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "buyer")
    private List<Share> shares = new LinkedList<>();

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_bank_account", nullable = true)
    private BankAccount bankAccount;

    public Buyer() {
    }

    public Buyer(String surname, String name, String address) {
        this.surname = surname;
        this.name = name;
        this.address = address;
    }

    public Buyer(String name, String surname, String address, List<Share> shares, BankAccount bankAccount) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.shares = shares;
        this.bankAccount = bankAccount;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Share> getShares() {
        return this.shares;
    }

    public void setShares(List<Share> shares) {
        this.shares = shares;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof Buyer)) return false;
        Buyer otherMyBuyer = (Buyer) other;
        if (otherMyBuyer.getId() == this.getId()) {
            return true;
        } else {
            return false;
        }
    }
}
