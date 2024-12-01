package main;

import model.*;
import presenter.*;
import view.*;


public class Main {
    public static void main(String[] args) {
        Notebook model = new Notebook();
        NotebookView view = new ConsoleNotebookView();
        NotebookPresenter presenter = new NotebookPresenter(model, view);

        CommandHandler commandHandler = new CommandHandler(presenter, (ConsoleNotebookView) view); 

        commandHandler.handleUserInput();
    }
}
