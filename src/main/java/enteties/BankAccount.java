package enteties;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Анна on 2/11/2016.
 */

@Entity
@Table(name = "bank_account")
@ManagedBean(name = "bank_account")
@RequestScoped
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bank_account")
    private int idBankAccount;

    @Column(name = "money_on_bank_account")
    private BigDecimal moneyOnBankAccount;

    public BankAccount() {
        moneyOnBankAccount = new BigDecimal(0);
    }

    public BankAccount(BigDecimal moneyOnBankAccount) {
        this.moneyOnBankAccount = moneyOnBankAccount;
    }

    public BigDecimal getMoneyOnBankAccount() {
        return moneyOnBankAccount;
    }

    public void setMoneyOnBankAccount(BigDecimal moneyOnBankAccount) {
        this.moneyOnBankAccount = moneyOnBankAccount;
    }

    public int getIdBankAccount() {
        return idBankAccount;
    }

    public void setIdBankAccount(int idBankAccount) {
        this.idBankAccount = idBankAccount;
    }
}
