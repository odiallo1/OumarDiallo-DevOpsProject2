package edu.westga.comp4420.javafx_sample.viewmodel;

import edu.westga.comp4420.javafx_sample.model.Notes;
import edu.westga.comp4420.javafx_sample.model.NotesCollection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class HomeViewModel {
    private NotesCollection notesCollection;
    private ObservableList<Notes> notesList;
    private ObservableList<String> topicsList;
    private Notes selectedNote;

    public HomeViewModel(NotesCollection notesCollection) {
        this.notesCollection = notesCollection;
        this.notesList = FXCollections.observableArrayList();
        this.topicsList = FXCollections.observableArrayList();
        //this.refreshNotesList();
        this.refreshTopicsList();
    }

    public void addNewNote() {
        this.notesCollection.addNote();
        //this.refreshNotesList();
    }

    public void selectNote(Notes note) {
        this.selectedNote = note;
    }

    public void removeSelectedNote() {
        if (this.selectedNote != null) {
            this.notesCollection.removeNote(this.selectedNote.getId());
            this.selectedNote = null;
            this.refreshNotesList();
        }
    }

    public void refreshNotesList() {
        this.notesList.clear();
        this.notesList.addAll(this.notesCollection.getNotesByTopic(null)); 
    }

    public void refreshTopicsList() {
        this.topicsList.clear();
        this.topicsList.addAll(this.notesCollection.getAllTopics());
    }

    public void filterNotesByTopic(String topic) {
        this.notesList.clear();
        if (topic == null || topic.isEmpty()) {
            this.notesList.addAll(this.notesCollection.getNotesByTopic(null));
        } else {
            this.notesList.addAll(this.notesCollection.getNotesByTopic(topic));
        }
    }

    public ObservableList<Notes> getNotesList() {
        return this.notesList;
    }

    public ObservableList<String> getTopicsList() {
        return this.topicsList;
    }
}
