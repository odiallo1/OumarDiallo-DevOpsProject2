package edu.westga.comp4420.javafx_sample.test.viewmodel;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javafx.collections.ObservableList;
import edu.westga.comp4420.javafx_sample.model.Item;
import edu.westga.comp4420.javafx_sample.viewmodel.ShoppingListViewModel;

class TestHomeViewModel {

     private ShoppingListViewModel viewModel;

    @BeforeEach
    void setUp() {
        this.viewModel = new ShoppingListViewModel();
    }

    @Test
    void testAddSelectedItemShouldIncreaseCartSize() {
        Item newItem = new Item("Oranges");
        this.viewModel.addSelectedItem(newItem);
        ObservableList<Item> cartItems = this.viewModel.getCartItems();
        assertEquals(1, cartItems.size(), "Cart should have 1 item after adding one.");
    }

    @Test
    void testRemoveSelectedItemShouldDecreaseCartSize() {
        Item newItem = new Item("Oranges");
        this.viewModel.addSelectedItem(newItem);
        this.viewModel.setSelectedCartItemIndex(0);
        this.viewModel.removeSelectedItem();
        ObservableList<Item> cartItems = this.viewModel.getCartItems();
        assertTrue(cartItems.isEmpty(), "Cart should be empty after removing the item.");
    }

    @Test
    void testUpdateSelectedItemQuantity() {
        Item newItem = new Item("Oranges");
        this.viewModel.addSelectedItem(newItem);
        this.viewModel.setSelectedCartItemIndex(0);
        this.viewModel.updateSelectedItemQuantity(5);
        ObservableList<Item> cartItems = this.viewModel.getCartItems();
        assertEquals(5, cartItems.get(0).getQuantity(), "Quantity of the item should be updated to 5.");
    }

    @Test
    void testSelectionIndexUpdatesQuantityText() {
        this.viewModel.addSelectedItem(new Item("Oranges"));
        this.viewModel.setSelectedCartItemIndex(0);
        assertEquals("0", this.viewModel.quantityTextProperty().get(), "Quantity text should reflect the selected item's quantity.");
    }

    @Test
    void testPopulateAvailableItemsShouldInitializeList() {
        ObservableList<Item> availableItems = this.viewModel.getAvailableItems();
        assertNotEquals(0, availableItems.size(), "Available items should be initialized and not empty.");
    }
}
