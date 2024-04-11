package edu.westga.comp4420.javafx_sample.view.codebehind;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * CodeBehind To Handle Processing for the HistoryWindow
 *
 * @author	Comp 4420
 * @version Spring 2024
 */
public class HistoryWindow {  
 

	@FXML 
	// fx:id="backButton"
    private Button backButton; 
	
	@FXML
    private TextArea notePageTextArea;

    @FXML
    private ListView<?> notesPageTopicListView;

    @FXML
    void openMainWindow(MouseEvent event) {
		try {
			// Load the new FXML file
			FXMLLoader loader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
			Parent root = loader.load();

			// Get the current stage (window) using the event source
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

			// Set the new scene
			Scene scene = new Scene(root);
			stage.setScene(scene);

			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
        
		}
    }
}