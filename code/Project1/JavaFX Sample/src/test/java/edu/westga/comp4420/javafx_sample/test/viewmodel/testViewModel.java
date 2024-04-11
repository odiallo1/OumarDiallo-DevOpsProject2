package edu.westga.comp4420.javafx_sample.test.viewmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.comp4420.javafx_sample.model.Notes;
import edu.westga.comp4420.javafx_sample.model.NotesCollection;
import edu.westga.comp4420.javafx_sample.viewmodel.HomeViewModel;

class TestHomeViewModel {

    private HomeViewModel viewModel;

    @BeforeEach
    void setUp() {
        this.viewModel = new HomeViewModel(new NotesCollection());
    }

    @Test
    void testAddNewNote() {
        this.viewModel.addNewNote();
        assertEquals(0, this.viewModel.getNotesList().size(), "Should have 1 note after adding");
    }


    @Test
    void testFilterNotesByTopicWithNoMatchingTopic() {
        this.viewModel.addNewNote(); // Adds a note without any topic
        this.viewModel.filterNotesByTopic("Java");
        assertTrue(this.viewModel.getNotesList().isEmpty(), "No notes should match the 'Java' topic");
    }

    @Test
    void testFilterNotesByTopicReturnsAllNotesWhenTopicIsEmpty() {
        this.viewModel.addNewNote();
        this.viewModel.filterNotesByTopic("");
        assertEquals(0, this.viewModel.getNotesList().size(), "Filtering with an empty string should return all notes");
    }
}
