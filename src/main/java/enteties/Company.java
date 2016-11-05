package enteties;

import javax.faces.bean.ManagedBean;
import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "company")
@ManagedBean(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private int id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "company_location")
    private String companyLocation;

    @Column(name = "company_foundation_year")
    private String companyFoundationYear;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "company")
    private List<Share> shares = new LinkedList<>();

    public Company() {
    }

    public Company(String companyName, String companyLocation, String companyFoundationYear, List<Share> shares) {
        this.companyName = companyName;
        this.companyLocation = companyLocation;
        this.companyFoundationYear = companyFoundationYear;
        this.shares = shares;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyLocation() {
        return companyLocation;
    }

    public void setCompanyLocation(String companyLocation) {
        this.companyLocation = companyLocation;
    }

    public String getCompanyFoundationYear() {
        return companyFoundationYear;
    }

    public void setCompanyFoundationYear(String companyFoundationYear) {
        this.companyFoundationYear = companyFoundationYear;
    }

    public List<Share> getShares() {
        return shares;
    }

    public void setShares(List<Share> shares) {
        this.shares = shares;
    }
}
