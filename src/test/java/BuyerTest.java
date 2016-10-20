import dao.BuyerDAO;
import dao.BuyerDAOimpl;
import enteties.Buyer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Анна on 20/10/2016.
 */

public class BuyerTest {
    private BuyerDAO buyerdao = new BuyerDAOimpl();
    @Test
    public void testInsert(){
        Buyer b = new Buyer("SurnameTest", "NameTest", "AddressTest", 1);
        buyerdao.create(b);
        Buyer bx = buyerdao.read(b.getId());
        assertEquals(b, bx);
    }

    public void testUpdate(){

    }
}
