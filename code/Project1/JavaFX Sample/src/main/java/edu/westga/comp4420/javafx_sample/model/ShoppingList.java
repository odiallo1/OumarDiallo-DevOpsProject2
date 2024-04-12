package edu.westga.comp4420.javafx_sample.model;


import java.util.ArrayList;
import java.util.List;

public class ShoppingList {
    private List<Item> items;
    private static final String ITEM_NOT_EXIST = "Item does not exist in the shopping list";  

    public ShoppingList() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        if (!this.items.contains(item)) {
            this.items.add(item);
        } else {
            throw new IllegalArgumentException("Item already exists in the shopping list");
        }
    }

    public void removeItem(Item item) {
        if (!this.items.contains(item)) {
            throw new IllegalArgumentException(ITEM_NOT_EXIST);
        }
        this.items.remove(item);
    }

    public void updateItemQuantity(Item item, int newQuantity) {
        int idx = this.items.indexOf(item);
        if (idx == -1) {
            throw new IllegalArgumentException(ITEM_NOT_EXIST);
        }
        this.items.get(idx).setQuantity(newQuantity);
    }

    public List<Item> getItems() {
        return new ArrayList<>(this.items);  
    }
}
