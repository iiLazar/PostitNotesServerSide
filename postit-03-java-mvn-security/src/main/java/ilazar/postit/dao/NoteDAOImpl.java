package ilazar.postit.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ilazar.postit.entity.Note;

@Repository
public class NoteDAOImpl implements NoteDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Note> getNotes() {
		List<Note> notes = new ArrayList<Note>();
		Session session = sessionFactory.getCurrentSession();
		notes = session.createQuery("from Note").getResultList();
		return notes;
	}

	@Override
	public void saveNote(Note note) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(note);
	}

	@Override
	public void deleteNote(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.createQuery("DELETE from Note n WHERE n.id = :noteId")
		.setParameter("noteId", id).executeUpdate();
	}

	@Override
	public Note getNote(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Note.class, id);
	}

	@Override
	public void deleteAllNotes() {
		Session session = sessionFactory.getCurrentSession();
		session.createQuery("DELETE FROM Note").executeUpdate();
	}

}
