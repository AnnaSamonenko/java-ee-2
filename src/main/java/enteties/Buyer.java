package enteties;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.*;

/**
 * Created by Анна on 19/10/2016.
 */

@Entity
@Table
@ManagedBean(name = "buyer")
@RequestScoped
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idbuyer")
    private int id;
    @Column(name="nameb")
    private String name;
    @Column(name="surnameb")
    private String surname;
    @Column(name="address")
    private String address;
    @Column(name="idshare")
    private int idshare;

    public Buyer() {
    }

    public Buyer(String surname, String name, String address, int idshare) {
        this.surname = surname;
        this.name = name;
        this.address = address;
        this.idshare = idshare;
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

    public int getIdshare() {
        return idshare;
    }

    public void setIdshare(int idshare) {
        this.idshare = idshare;
    }

    public boolean equals(Buyer other) { return this.id == other.id; }
}
