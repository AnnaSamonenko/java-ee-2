package enteties;

import dao.interfaces.BankAccountDAO;

import javax.faces.bean.ManagedBean;
import javax.persistence.*;

@Entity
@Table(name = "bank_account")
@ManagedBean(name = "bankAccount")
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bank_account")
    private int idBankAccount;

    @Column(name = "money_on_bank_account")
    private int moneyOnBankAccount;

    public BankAccount() {
    }

    public BankAccount(int moneyOnBankAccount) {
        this.moneyOnBankAccount = moneyOnBankAccount;
    }

    public int getMoneyOnBankAccount() {
        return moneyOnBankAccount;
    }

    public void setMoneyOnBankAccount(int moneyOnBankAccount) {
        this.moneyOnBankAccount = moneyOnBankAccount;
    }

    public int getIdBankAccount() {
        return idBankAccount;
    }

    public void setIdBankAccount(int idBankAccount) {
        this.idBankAccount = idBankAccount;
    }
}
