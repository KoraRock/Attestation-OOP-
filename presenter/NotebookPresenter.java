package presenter;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;
import model.*;
import view.NotebookView;


public class NotebookPresenter {
    private Notebook model;
    private NotebookView view;

    public NotebookPresenter(Notebook model, NotebookView view) {
        this.model = model;
        this.view = view;
    }

    public void addNote() {
        LocalDateTime dateTime = view.getDateTimeInput();
        String description = view.getDescriptionInput();
        model.add(new Note(dateTime, description));
        view.showMessage("Запись добавлена.");
    }

    public void showNotesForDay() {
        LocalDateTime dateTime = view.getDateTimeInput();
        List<Note> notes = model.getNotesForDay(dateTime);
        view.showNotes(notes);
    }

    public void showNotesForWeek() {
        LocalDateTime startOfWeek = view.getDateTimeInput();
        List<Note> notes = model.getNotesForDay(startOfWeek);
        view.showNotes(notes);
    }

    public void saveNotes() {
        String fileName = view.getFileNameInput();
        try {
            model.saveToFile(fileName);
            view.showMessage("Запись сохранена в " + fileName);
        } catch (IOException e) {
            view.showMessage("Ошибка записи в файл: " + e.getMessage());
        }
    }

    public void loadNotes() {
        String fileName = view.getFileNameInput();
        try {
            model.loadFromFile(fileName);
            view.showMessage("Запись считана из " + fileName);
        } catch (IOException e) {
            view.showMessage("Ошибка считывания из файла: " + e.getMessage());
        }
    }

    public void handleCommand(String choise) {
        switch (choise) {
            case "1":
                addNote();                
                break;
            case "2":
                showNotesForDay();                
                break;
            case "3":
                showNotesForWeek();
                break;
            case "4":
                saveNotes();
                break;
            case "5":
                loadNotes();
                break;
            case "6":
                return;
            default:
                System.out.println("Ошибка команды, попробуйте еще раз.");
        }
    }
}
