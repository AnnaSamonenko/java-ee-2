import dao.ShareDAOimpl;
import enteties.Share;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertSame;

/**
 * Created by Анна on 20/10/2016.
 */
public class ShareTest {
    private ShareDAOimpl shdao = new ShareDAOimpl();
    @Test
    public void testInsert(){
        Share sh = new Share("NameTest",new BigDecimal(7779), "TypeTest");
        shdao.create(sh);
        Share shx = shdao.read(sh.getId());
        assertSame(sh, shx) ;
    }
}
