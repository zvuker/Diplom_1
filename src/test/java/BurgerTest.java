import praktikum.Burger;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.IngredientType;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;



@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun bunMock;

    @Mock
    private Ingredient ingredientMock;

    @Test
    public void setBuns() {
        Burger burger = new Burger();
        burger.setBuns(bunMock);
        Assert.assertEquals(bunMock, burger.bun);
    }

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        float price = 200;
        Mockito.when(bunMock.getPrice()).thenReturn(price);
        Mockito.when(ingredientMock.getPrice()).thenReturn(price);
        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);
        Assert.assertEquals(price * 2 + price, burger.getPrice(), 0);
    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientMock);
        Assert.assertTrue(burger.ingredients.contains(ingredientMock));
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "Соус с шипами Антарианского плоскоходца", 88));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "Биокотлета из марсианской Магнолии", 424));
        burger.moveIngredient(0, 1);
        Assert.assertEquals("Соус с шипами Антарианского плоскоходца", burger.ingredients.get(1).name);
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientMock);
        burger.removeIngredient(0);
        Assert.assertFalse(burger.ingredients.contains(ingredientMock));
    }

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        burger.setBuns(bunMock);
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "Мясо бессмертных моллюсков Protostomia", 1337));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "Соус традиционный галактический", 15));
        String expectedReceipt = burger.getReceipt();
        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }

    @Test
    public void priceMultiIngredientsTest() {
        Burger burger = new Burger();
        Mockito.when(bunMock.getPrice()).thenReturn(988f);
        burger.setBuns(bunMock);
        Ingredient ingredientSauce = new Ingredient(IngredientType.SAUCE, "Соус Spicy-X", 90);
        Ingredient ingredientFilling = new Ingredient(IngredientType.FILLING, "Сыр с астероидной плесенью", 4142);
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientFilling);
        Assert.assertEquals(6208, burger.getPrice(), 0.01);
    }
}