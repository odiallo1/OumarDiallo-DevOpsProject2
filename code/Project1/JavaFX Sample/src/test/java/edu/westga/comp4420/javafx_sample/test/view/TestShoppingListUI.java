package edu.westga.devops.a4.test.view.main_window;

import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.api.FxAssert;
import org.testfx.matcher.control.ListViewMatchers;
import edu.westga.comp4420.javafx_sample.Main;
public class TestShoppingListUI extends ApplicationTest {

    @Override
	public void start(Stage stage) throws IOException {
		(new Main()).start(stage);
	}

    @Test
    public void testAddItemToCart() {
        clickOn("#availableItemsListView").type(KeyCode.DOWN).type(KeyCode.ENTER);
        clickOn("#addButton");
        FxAssert.verifyThat("#cartListView", ListViewMatchers.hasItems(1));
    }

}
