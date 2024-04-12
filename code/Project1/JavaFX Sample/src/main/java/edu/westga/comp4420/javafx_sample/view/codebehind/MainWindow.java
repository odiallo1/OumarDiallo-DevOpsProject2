package edu.westga.comp4420.javafx_sample.view.codebehind;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import edu.westga.comp4420.javafx_sample.model.Item;
import edu.westga.comp4420.javafx_sample.viewmodel.ShoppingListViewModel;
public class MainWindow {

    @FXML
    private Button addButton;

    @FXML
    private ListView<Item> availableItemsListView;

    @FXML
    private ListView<Item> cartListView;

    @FXML
    private TextField quantityTextField;

    @FXML
    private Button removeButton;

    @FXML
    private Button updateQuantityButton;

    private ShoppingListViewModel viewModel;

    public MainWindow() {
        this.viewModel = new ShoppingListViewModel();
    }

    @FXML
    private void initialize() {
        this.setupBindings();
        this.setupEventHandlers();
    }

    private void setupBindings() {
        this.availableItemsListView.setItems(this.viewModel.getAvailableItems());
        this.cartListView.setItems(this.viewModel.getCartItems());

        
        this.quantityTextField.textProperty().bindBidirectional(this.viewModel.quantityTextProperty());

       
        this.cartListView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            int index = this.cartListView.getSelectionModel().getSelectedIndex();
            this.viewModel.setSelectedCartItemIndex(index);
        });
    }

    private void setupEventHandlers() {
        this.addButton.setOnAction(e -> this.handleAddButton());
        this.removeButton.setOnAction(e -> this.handleRemoveButton());
        this.updateQuantityButton.setOnAction(e -> this.handleUpdateQuantityButton());
    }

    private void handleAddButton() {
        Item selectedItem = this.availableItemsListView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            this.viewModel.addSelectedItem(selectedItem);
            this.viewModel.updateSelectedItemQuantity(1);
        }
    }

    private void handleRemoveButton() {
        
    }

    private void handleUpdateQuantityButton() {
        
    }
}


