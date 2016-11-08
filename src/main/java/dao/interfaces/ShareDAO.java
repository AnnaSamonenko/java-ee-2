package dao.interfaces;

import enteties.Share;

import java.util.ArrayList;
import java.util.List;

public interface ShareDAO {
    void create(Share sh, int idCompany, int idBuyer);

    List<Share> findAllShares();

    void update(int id, int price);

    void delete(int id);

    Share read(int id);

    ArrayList<Share> sellingShare();
}
