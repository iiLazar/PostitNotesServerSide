package ilazar.postit.service;

import java.util.List;

import ilazar.postit.entity.Note;

public interface NoteService {
	
	public List<Note> getNotes();

	public void saveNote(Note note);

	public void deleteNote(int id);

	public Note getNote(int id);

	public void deleteAllNotes();

}
