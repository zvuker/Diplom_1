import praktikum.Bun;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Assert;
import java.util.Collections;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тест данные: {0}, {1}")
    public static Object[][] getData() {
        return new Object[][]{
                {"Краторная булка N-200i", 1255.00f},
                {"Флюоресцентная булка R2-D3", 988.00f},
                {"Краторная булка N-200i", Float.MAX_VALUE},
                {"Краторная булка N-200i", Float.MIN_VALUE},
                {"Флюоресцентная булка R2-D3", 3.40282347E38f},
                {"Краторная булка N-200i", 1.4E-45f},
                {"  ", 988.00f},
                {"Флюоресцентная булка R2-D3", -100.00f},
                {"Флюоресцентная булка R2-D3", 0},
                {"Флюоресцентная булка R2-D3", Float.NaN},
                {"Краторная булка N-200i" + String.join("", Collections.nCopies(100, "очень длинное название булки ")), 100f},
                {"?:№!", 0},
                {null, 988},
                {"Флюоресцентная булка R2-D3 с очень-очень длинным названием, которое превышает нормальную длину для тестирования", 500.00f},
                {"", 250.00f}
        };
    }

    @Test
    public void getNameParamTest() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceParamTest() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(price, bun.getPrice(), 0);
    }
}
