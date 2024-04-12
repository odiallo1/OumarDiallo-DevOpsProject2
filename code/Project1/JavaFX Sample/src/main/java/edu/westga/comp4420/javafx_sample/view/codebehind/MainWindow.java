package edu.westga.comp4420.javafx_sample.view.codebehind;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class MainWindow {

    @FXML
    private Button addButton;

    @FXML
    private ListView<?> availableItemsListView;

    @FXML
    private ListView<?> cartListView;

    @FXML
    private TextField quantityTextField;

    @FXML
    private Button removeButton;

    @FXML
    private Button updateQuantityButton;

}


