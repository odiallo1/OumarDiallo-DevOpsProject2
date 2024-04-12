package edu.westga.comp4420.javafx_sample.model;

public class Item {
    private String name;
    private int quantity;

    public Item(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Item name cannot be empty");
        }
        this.name = name;
        this.quantity = 0;  
    }

    public String getName() {
        return this.name;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        this.quantity = quantity;
    }

    public int getQuantity() {
        return this.quantity;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Item item = (Item) obj;
        return this.name.equals(item.name);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public String toString() {
        return this.name + " - Quantity: " + this.quantity;
    }

}
