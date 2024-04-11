package edu.westga.comp4420.javafx_sample.view.codebehind;

import edu.westga.comp4420.javafx_sample.model.Notes;
import edu.westga.comp4420.javafx_sample.model.NotesCollection;
import edu.westga.comp4420.javafx_sample.viewmodel.HomeViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * CodeBehind To Handle Processing for the MainWindow
 *
 * @author	Comp 4420
 * @version Spring 2024
 */
public class MainWindow {
	
    private HomeViewModel homeViewModel;
    
    private NotesCollection allNotes;


	@FXML 
	// fx:id="historyButton"
    private Button historyButton; 
	
	@FXML
    private ListView<String> homeTopicsListView;

    @FXML
    private ListView<Notes> notesListView;

    @FXML
    private Button removeButton;
    
    public MainWindow() {
    	this.allNotes = new NotesCollection();
    	this.allNotes.addNote();
        this.homeViewModel = new HomeViewModel(this.allNotes); 
    }
    
    @FXML
    public void initialize() {
        // Bind the ListView to the ObservableList in HomeViewModel
        this.notesListView.setItems(this.homeViewModel.getNotesList());
        this.homeTopicsListView.setItems(this.homeViewModel.getTopicsList());

        // Add listeners for selection to handle note viewing/updating and topic filtering
        this.notesListView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            // Implement logic to make a note the active note, possibly opening an editor window
            this.homeViewModel.selectNote(newSelection);
        });

        this.homeTopicsListView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            // Implement logic to filter notes by the selected topic
            this.homeViewModel.filterNotesByTopic(newSelection);
        });
    }

    @FXML
    void openHistoryWindow(MouseEvent event) {
    	try {
			// Load the new FXML file
			FXMLLoader loader = new FXMLLoader(getClass().getResource("HistoryWindow.fxml"));
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
    
    @FXML
    void removeNoteButtonClick(MouseEvent event) {
    	Notes selectedNote = this.notesListView.getSelectionModel().getSelectedItem();
        if (selectedNote != null) {
            this.homeViewModel.removeSelectedNote();
        }
    	this.homeViewModel.addNewNote();

    }
}
