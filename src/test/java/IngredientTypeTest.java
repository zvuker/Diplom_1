import org.junit.Test;
import praktikum.IngredientType;
import static org.junit.Assert.*;

public class IngredientTypeTest {

    @Test
    public void testExistenceOfEnumValues() {
        assertNotNull("Should have a SAUCE enum value", IngredientType.valueOf("SAUCE"));
        assertNotNull("Should have a FILLING enum value", IngredientType.valueOf("FILLING"));
    }
    @Test
    public void testCountOfEnumValues() {
        assertEquals("IngredientType enum should have exactly 2 values", 2, IngredientType.values().length);
    }
}
