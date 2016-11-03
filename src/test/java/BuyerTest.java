//import dao.BuyerDAO;
//import dao.BuyerDAOimpl;
//import enteties.Buyer;
//import org.junit.Test;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNull;
///**
// * Created by Анна on 20/10/2016.
// */
//
//public class BuyerTest {
//    private BuyerDAO buyerdao = new BuyerDAOimpl();
//    @Test
//    public void testCRUDBuyer(){
//        Buyer b = new Buyer("SurnameTest", "NameTest", "AddressTest");
//
//        buyerdao.create(b);
//        assertEquals(b, buyerdao.read(b.getId()));
//
//        b.setName("UpdateTest");
//        buyerdao.update(b.getId(),b);
//        assertEquals(b, buyerdao.read(b.getId()));
//
//        buyerdao.delete(b.getId());
//        assertNull(buyerdao.read(b.getId()));
//    }
//}
