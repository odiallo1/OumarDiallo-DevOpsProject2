package edu.westga.comp4420.javafx_sample.viewmodel;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import edu.westga.comp4420.javafx_sample.model.Item;
import edu.westga.comp4420.javafx_sample.model.ShoppingList;

public class ShoppingListViewModel {
    private ShoppingList cart;
    private ObservableList<Item> cartItems;
    private SimpleIntegerProperty selectedCartItemIndex;
    private SimpleStringProperty quantityText;

    public ShoppingListViewModel() {
        this.cart = new ShoppingList();
        this.cartItems = FXCollections.observableArrayList(this.cart.getItems());
        this.selectedCartItemIndex = new SimpleIntegerProperty(-1);  
        this.quantityText = new SimpleStringProperty("");

        
        this.selectedCartItemIndex.addListener((obs, oldVal, newVal) -> {
            if (newVal != null && newVal.intValue() >= 0) {
                Item selectedItem = this.cartItems.get(newVal.intValue());
                this.quantityText.set(String.valueOf(selectedItem.getQuantity()));
            }
        });
    }

    public ObservableList<Item> getCartItems() {
        return this.cartItems;
    }

    public SimpleStringProperty quantityTextProperty() {
        return this.quantityText;
    }

    public void addSelectedItem(Item item) {
        this.cart.addItem(item);
        this.refreshCartItems();
    }

    public void removeSelectedItem() {
        int index = this.selectedCartItemIndex.get();
        if (index >= 0) {
            this.cart.removeItem(this.cartItems.get(index));
            this.refreshCartItems();
        }
    }

    public void updateSelectedItemQuantity(int newQuantity) {
        int index = this.selectedCartItemIndex.get();
        if (index >= 0) {
            Item item = this.cartItems.get(index);
            item.setQuantity(newQuantity);
            this.refreshCartItems();
        }
    }

    private void refreshCartItems() {
        this.cartItems.setAll(this.cart.getItems());
    }
}
