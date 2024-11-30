import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;


public class Notebook {
    private List<Note> notes = new ArrayList<>();
    
    public void add(Note note) {
        notes.add(note);
    }

    public List<Note> getNotes() {
        return new ArrayList<>(notes);
    }

    public List<Note> getNotesForDay(LocalDateTime dateTime) {
        return notes.stream().filter(note -> 
                note.getDateTime().toLocalDate().isEqual(dateTime.toLocalDate()))
                .sorted(Comparator.comparing(Note::getDateTime))
                .collect(Collectors.toList());
    }

    public List<Note> getNotesForWeek(LocalDateTime startOfWeek) {
        LocalDateTime endOfWeek = startOfWeek.plusWeeks(1);
        return notes.stream().filter(note -> 
                !note.getDateTime().isBefore(startOfWeek) &&
                !note.getDateTime().isAfter(endOfWeek))
                .sorted(Comparator.comparing(Note::getDateTime))
                .collect(Collectors.toList());
    }

    
}
