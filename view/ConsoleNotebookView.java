package view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import model.*;


public class ConsoleNotebookView implements NotebookView { 

    private Scanner scanner;

    public ConsoleNotebookView() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void showNotes(List<Note> notes) {
        if (notes.isEmpty()) {
            System.out.println("Записи не найдены.");
        } else {
            for (Note note : notes) {
                System.out.println(note);
            }
        }
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public LocalDateTime getDateTimeInput() {
        System.out.println("Введите дату и время (yyyy-MM-dd HH:mm): ");
        String input = getUserInput();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        return LocalDateTime.parse(input, formatter);
    }

    @Override
    public String getDescriptionInput() {
        System.out.println("Запишите Вашу заметку: ");
        return getUserInput();
    }

    @Override
    public String getFileNameInput() {
        System.out.println("Введите имя файла: ");
        return getUserInput();
    }

    public String getUserInput() {
        return scanner.nextLine();
    }

}
