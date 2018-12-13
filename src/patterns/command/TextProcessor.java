package patterns.command;

import java.util.Scanner;

public class TextProcessor {
    private CommandsHistory history = new CommandsHistory();
    // все команды сохранить константами
    // перечислить константы

    public void executeCommand(Command command) {  // метод, который вызывает комманду
        if (command.execute()) {         // при успешном выполнении команды
            history.addCommand(command);        // происходит добавлению в историю
        }
    }

    public void start() {
        Scanner in = new Scanner(System.in);
        while (true) {
            switch (in.nextLine()) {
                case "process":
                    executeCommand(new ProcessCommand(this));
                    break;
                case "exit":
                    executeCommand(new ExitCommand(this));
                    break;
//                if (in.nextLine().equals("process написать константу")){
//                    executeCommand(new ProcessCommand(this));
            }
        }
    }

}
