package edu.westga.comp4420.javafx_sample.test.model.notes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.comp4420.javafx_sample.model.Notes;
import edu.westga.comp4420.javafx_sample.model.NotesCollection;

class TestNotesCollection {

    private NotesCollection collection;

    @BeforeEach
    void setUp() {
        this.collection = new NotesCollection();
    }

    @Test
    void testAddNoteIncreasesCollectionSize() {
        this.collection.addNote();
        assertEquals(1, this.collection.getNotes().size(), "Collection should have 1 note after adding a note");
    }

    @Test
    void testRemoveNoteDecreasesCollectionSize() {
        this.collection.addNote();
        Notes note = this.collection.getNotes().get(0);
        this.collection.removeNote(note.getId());
        assertTrue(this.collection.getNotes().isEmpty(), "Collection should be empty after removing the note");
    }

    @Test
    void testFindNoteByIdReturnsCorrectNote() {
        this.collection.addNote();
        Notes addedNote = this.collection.getNotes().get(0);
        Notes foundNote = this.collection.findNoteById(addedNote.getId());
        assertEquals(addedNote.getId(), foundNote.getId(), "Found note should have the same ID as the added note");
    }

    @Test
    void testFindNoteByIdReturnsNullForUnknownId() {
        assertNull(this.collection.findNoteById("unknown"), "Should return null for an unknown ID");
    }

    @Test
    void testGetNotesByTopicReturnsCorrectNotes() {
        Notes note = new Notes();
        note.addTopic("Java");
        this.collection.addNote(); // Add a note without topics
        this.collection.getNotes().add(note); // Add a note with a topic
        List<Notes> notesWithJava = this.collection.getNotesByTopic("Java");
        assertEquals(1, notesWithJava.size(), "Should return only one note with the 'Java' topic");
        assertEquals(note.getId(), notesWithJava.get(0).getId(), "The returned note should have the 'Java' topic");
    }

    @Test
    void testGetAllTopicsReturnsCorrectTopics() {
        Notes note1 = new Notes();
        note1.addTopic("Java");
        Notes note2 = new Notes();
        note2.addTopic("Python");
        this.collection.getNotes().add(note1);
        this.collection.getNotes().add(note2);
        Set<String> topics = this.collection.getAllTopics();
        assertTrue(topics.contains("Java") && topics.contains("Python") && topics.size() == 2, "Should return all unique topics");
    }
}
