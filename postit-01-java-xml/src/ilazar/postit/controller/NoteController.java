package ilazar.postit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ilazar.postit.entity.Note;
import ilazar.postit.service.NoteService;

@Controller
@RequestMapping("/note")
public class NoteController {
	
	@Autowired
	private NoteService noteService;
	
	@GetMapping("/all")
	public String showNotes(Model model) {
		Note note = new Note();
		model.addAttribute("note", note);
		
		List<Note> notes = noteService.getNotes();
		model.addAttribute("notes", notes);
		return "notes";
	}
	
	@PostMapping("/saveNote")
	public String saveNote(@ModelAttribute("note") Note note) {
		noteService.saveNote(note);
		return "redirect:/note/all";
	}
	
	@GetMapping("/delete")
	public String deleteNote(@RequestParam("noteId") int id) {
		noteService.deleteNote(id);
		return "redirect:/note/all";
	}
	
	@GetMapping("/deleteAll")
	public String deleteAllNotes() {
		noteService.deleteAllNotes();
		return "redirect:/note/all";
	}
	
	@GetMapping("/edit")
	public String updateNotePreparation(
			@RequestParam ("noteId") int id,
			Model model
			) {
		Note note = noteService.getNote(id);
		model.addAttribute("note", note);
		
		List<Note> notes = noteService.getNotes();
		model.addAttribute("notes", notes);
		return "edit";
	}

}
