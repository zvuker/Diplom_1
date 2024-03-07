import org.junit.Test;
import praktikum.IngredientType;
import static org.junit.Assert.*;

public class IngredientTypeTest {

    @Test
    public void testExistenceOfEnumValues() {
        // Проверяем, что перечисление содержит ожидаемые значения
        assertNotNull("Should have a SAUCE enum value", IngredientType.valueOf("SAUCE"));
        assertNotNull("Should have a FILLING enum value", IngredientType.valueOf("FILLING"));
    }
    @Test
    public void testCountOfEnumValues() {
        // Проверяем, что количество значений в перечислении соответствует ожидаемому
        assertEquals("IngredientType enum should have exactly 2 values", 2, IngredientType.values().length);
    }
}
