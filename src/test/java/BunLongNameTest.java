import praktikum.Bun;

import org.junit.Test;
import org.junit.Assert;

public class BunLongNameTest {

    @Test
    public void veryLongNameTest() {
        String veryLongName = "Very long bun name that exceeds normal length for testing";
        float expectedPrice = 500.0f;
        Bun bun = new Bun(veryLongName, expectedPrice);
        Assert.assertEquals("The name must correspond to the given very long name", veryLongName, bun.getName());
        Assert.assertEquals("The price must align with the anticipated price", expectedPrice, bun.getPrice(), 0.01);
    }
}
