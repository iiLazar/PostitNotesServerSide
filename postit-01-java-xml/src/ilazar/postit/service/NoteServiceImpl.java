package ilazar.postit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ilazar.postit.dao.NoteDAO;
import ilazar.postit.entity.Note;

@Service
public class NoteServiceImpl implements NoteService {

	@Autowired
	private NoteDAO noteDAO;
	
	@Override
	@Transactional
	public List<Note> getNotes() {
		return noteDAO.getNotes();
	}
	@Override
	@Transactional
	public void saveNote(Note note) {
		noteDAO.saveNote(note);
	}
	@Override
	@Transactional
	public void deleteNote(int id) {
		noteDAO.deleteNote(id);
	}
	@Override
	@Transactional
	public Note getNote(int id) {
		return noteDAO.getNote(id);
	}
	@Override
	@Transactional
	public void deleteAllNotes() {
		noteDAO.deleteAllNotes();
	}

}
