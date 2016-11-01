import dao.ShareDAOimpl;
import enteties.Share;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by Анна on 20/10/2016.
 */
public class ShareTest {
    ShareDAOimpl shdao = new ShareDAOimpl();

    @Test
    public void testShare() {
        Share sh = new Share("NameTest", new BigDecimal(7779), "TypeTest");
        shdao.create(sh);
        assertEquals(sh, shdao.read(sh.getId()));

        sh.setName("UpdateTest");
        shdao.update(sh.getId(), sh);
        assertEquals(sh, shdao.read(sh.getId()));

        shdao.delete(sh.getId());
        assertNull(shdao.read(sh.getId()));
    }
}
