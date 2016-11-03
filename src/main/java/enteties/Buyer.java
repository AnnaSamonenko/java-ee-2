package enteties;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "buyer")
@ManagedBean(name = "buyer")
@RequestScoped
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idbuyer")
    private int id;

    @Column(name = "nameb")
    private String name;

    @Column(name = "surnameb")
    private String surname;

    @Column(name = "address")
    private String address;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "buyer")
    private List<Share> shares = new LinkedList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_bank_account")
    private BankAccount bankAccount = new BankAccount();

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
