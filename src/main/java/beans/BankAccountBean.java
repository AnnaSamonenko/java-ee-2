package beans;

import dao.impl.BankAccountDAOimpl;
import dao.impl.BuyerDAOimpl;
import dao.interfaces.BankAccountDAO;
import dao.interfaces.BuyerDAO;
import enteties.BankAccount;
import enteties.Buyer;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean(name = "bankAccountBean")
public class BankAccountBean {

    @ManagedProperty(value = "#{bankAccount}")
    private BankAccount bankAccount = new BankAccount();

    @ManagedProperty(value = "#{operationMoney}")
    int operationMoney;

    BuyerDAO buyerDAOimpl = new BuyerDAOimpl();
    BankAccountDAO bankAccountDAO = new BankAccountDAOimpl();

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public int getOperationMoney() {
        return operationMoney;
    }

    public void setOperationMoney(int operationMoney) {
        this.operationMoney = operationMoney;
    }

    public void create(int buyerID) {
        bankAccountDAO.create(buyerID);
    }

    public void addMoney(int buyerID, int moneyToAdd) {
        Buyer buyerUpdate = buyerDAOimpl.read(buyerID);
        BankAccount bankAccount = buyerUpdate.getBankAccount();
        bankAccount.setMoneyOnBankAccount(bankAccount.getMoneyOnBankAccount() + moneyToAdd);
        BankAccountDAO bankAccountDAOimpl = new BankAccountDAOimpl();
        bankAccountDAOimpl.update(bankAccount.getIdBankAccount(), bankAccount);
    }

}
