/**
* Engenharia de Software Moderna - Testes  (Cap. 8)
* Prof. Marco Tulio Valente
* 
* Exercício simples de teste de unidade (ShoppingCart)
*
*/

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class TesteShoppingCart {

  private ShoppingCart shoppingCart;

  @Before
  public void setUp() {
    shoppingCart = new ShoppingCart();
    shoppingCart.addItem(new Item("ESM", 65.0));
    shoppingCart.addItem(new Item("GoF", 120.0));
  }

  @Test
  public void testAddItem() {
    Item newItem = new Item("Refactoring", 80.0);
    shoppingCart.addItem(newItem);
    assertTrue(shoppingCart.getItems().contains(newItem));
    assertEquals(3, shoppingCart.getItemCount());
  }

  @Test
  public void testRemoveItem() {
    Item itemToRemove = new Item("ESM", 65.0);
    shoppingCart.removeItem(itemToRemove);
    assertFalse(shoppingCart.getItems().contains(itemToRemove));
  }

  @Test
  public void testGetTotalPrice() {
    double expectedTotal = 65.0 + 120.0;
    assertEquals(expectedTotal, shoppingCart.getTotalPrice(), 0.001);
  }

  @Test
  public void testClearCart() {
    shoppingCart.clearCart();
    assertTrue(shoppingCart.getItems().isEmpty());
  }
}
