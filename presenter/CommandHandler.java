package presenter;

import view.ConsoleNotebookView;

public class CommandHandler {
    private NotebookPresenter presenter;
    private ConsoleNotebookView view;

    public CommandHandler(NotebookPresenter presenter, ConsoleNotebookView view) {
        this.presenter = presenter;
        this.view = view;
    }

    public void handleUserInput() {
        while (true) { 
            System.out.println("Введите номер команды: \n" + 
                    "1. Добавить запись \n" +
                    "2. Показать записи за выбранный день \n" +
                    "3. Показать записи за неделю \n" +
                    "4. Сохранить записи в файл \n" +
                    "5. Считать записи из файла \n" +
                    "6. Выход");
            
            String choise = view.getUserInput();
            presenter.handleCommand(choise);
        }
    }
}
