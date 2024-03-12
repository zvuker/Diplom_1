import praktikum.IngredientType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    @Parameterized.Parameters(name = "Enum value: {0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"SAUCE"},
                {"FILLING"}
        });
    }

    private final String value;

    public IngredientTypeTest(String value) {
        this.value = value;
    }

    @Test
    public void testExistenceOfEnumValues() {
        assertNotNull("Should have a " + value + " enum value", IngredientType.valueOf(value));
    }

    @Test
    public void testCountOfEnumValues() {
        assertEquals("IngredientType enum should have exactly 2 values", 2, IngredientType.values().length);
    }
}
