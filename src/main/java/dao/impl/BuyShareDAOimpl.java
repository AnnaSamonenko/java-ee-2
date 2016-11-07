package dao.impl;

import dao.interfaces.BankAccountDAO;
import dao.interfaces.BuyShareDAO;
import enteties.BankAccount;
import enteties.Buyer;
import enteties.Share;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BuyShareDAOimpl implements BuyShareDAO {
    private EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Share");
    private BuyerDAOimpl buyerDAOimpl = new BuyerDAOimpl();
    private ShareDAOimpl shareDAOimpl = new ShareDAOimpl();
    private BankAccountDAO bankAccountDAO = new BankAccountDAOimpl();
    private ExchangeDAOimpl exchangeDAOimpl = new ExchangeDAOimpl();

    public void buy(int buyerID, int shareID) {
        // share
        Share share = shareDAOimpl.read(shareID);
        int priceOfShare = share.getPrice();
        // new owner
        Buyer newOwner = buyerDAOimpl.read(buyerID);
        BankAccount bankAccountNewOwner = newOwner.getBankAccount();
        // prev owner
        Buyer prevOwner = share.getBuyer();
        BankAccount bankAccountPrevOwner = prevOwner.getBankAccount();
        // BD
        EntityManager entitymanager = emfactory.createEntityManager();
        // update owner of share && clean exchange of share
        entitymanager.getTransaction().begin();
        share.setBuyer(newOwner);
        share.getExchanges().clear();
        entitymanager.merge(share);
        entitymanager.getTransaction().commit();
        entitymanager.close();
        // +- money
        bankAccountNewOwner.setMoneyOnBankAccount(bankAccountNewOwner.getMoneyOnBankAccount() - priceOfShare);
        bankAccountPrevOwner.setMoneyOnBankAccount(bankAccountPrevOwner.getMoneyOnBankAccount() + priceOfShare);
        // transaction of money
        bankAccountDAO.update(newOwner.getBankAccount().getIdBankAccount(), bankAccountNewOwner);
        bankAccountDAO.update(prevOwner.getBankAccount().getIdBankAccount(), bankAccountPrevOwner);
    }
}
