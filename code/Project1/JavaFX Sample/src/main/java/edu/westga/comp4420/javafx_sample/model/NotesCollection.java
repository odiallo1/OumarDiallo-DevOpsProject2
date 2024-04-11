package edu.westga.comp4420.javafx_sample.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class NotesCollection {
    private List<Notes> notes;

    public NotesCollection() {
        this.notes = new ArrayList<>();
    }

    public void addNote() {
        this.getNotes().add(new Notes());
    }

    public boolean removeNote(String noteId) {
        return this.getNotes().removeIf(note -> note.getId().equals(noteId));
    }

    public Notes findNoteById(String id) {
        return this.getNotes().stream()
                .filter(note -> note.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Notes> getNotesByTopic(String topic) {
        return this.getNotes().stream()
                .filter(note -> note.getTopics().contains(topic))
                .collect(Collectors.toList());
    }

    public Set<String> getAllTopics() {
        return this.getNotes().stream()
                .flatMap(note -> note.getTopics().stream())
                .collect(Collectors.toSet());
    }

	public List<Notes> getNotes() {
		return this.notes;
	}
}
