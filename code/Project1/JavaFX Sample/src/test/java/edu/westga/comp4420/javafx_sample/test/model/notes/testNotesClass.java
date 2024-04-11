package edu.westga.comp4420.javafx_sample.test.model.notes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.comp4420.javafx_sample.model.Notes;

class testNotesClass {

	private Notes notes;

    @BeforeEach
    void setUp() {
        this.notes = new Notes();
    }

    @Test
    void testInitialTextIsHelloWorld() {
        assertEquals("Hello World", this.notes.getText(), "Initial text should be 'Hello World'");
    }

    @Test
    void testSettingTextUpdatesText() {
        this.notes.setText("New Text");
        assertEquals("New Text", this.notes.getText(), "Text should be updated to 'New Text'");
    }

    @Test
    void testInitialTopicsIsEmpty() {
        assertTrue(this.notes.getTopics().isEmpty(), "Initial topics should be empty");
    }

    @Test
    void testAddTopicReturnsTrueAndAddsTopic() {
        assertTrue(this.notes.addTopic("Java"), "Adding a new topic should return true");
        assertTrue(this.notes.getTopics().contains("Java"), "Topics should contain 'Java'");
    }

    @Test
    void testAddDuplicateTopicReturnsFalse() {
        this.notes.addTopic("Java");
        assertFalse(this.notes.addTopic("Java"), "Adding a duplicate topic should return false");
    }

    @Test
    void testAddNullTopicReturnsFalse() {
        assertFalse(this.notes.addTopic(null), "Adding null as a topic should return false");
    }

    @Test
    void testAddEmptyTopicReturnsFalse() {
        assertFalse(this.notes.addTopic(""), "Adding an empty string as a topic should return false");
    }

    @Test
    void testRemoveExistingTopicReturnsTrue() {
        this.notes.addTopic("Java");
        assertTrue(this.notes.removeTopic("Java"), "Removing an existing topic should return true");
    }

    @Test
    void testRemoveNonExistingTopicReturnsFalse() {
        assertFalse(this.notes.removeTopic("Python"), "Removing a non-existing topic should return false");
    }

    @Test
    void testToStringReturnsText() {
        assertEquals("Hello World", this.notes.toString(), "toString should return the current text");
    }

    @Test
    void testToStringReturnsNewNoteWhenTextIsEmpty() {
        this.notes.setText("");
        assertEquals("New Note", this.notes.toString(), "toString should return 'New Note' when text is empty");
    }

}
