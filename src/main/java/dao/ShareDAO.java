package dao;

import enteties.Share;

import java.util.List;

public interface ShareDAO {
    void create(Share sh);

    List<Share> findAllShares();

    void update(int id, Share sh);

    void delete(int id);

    Share read(int id);
}
