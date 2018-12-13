package patterns.command;

public class ProcessCommand extends Command {

    public ProcessCommand(TextProcessor processor) {
        super(processor);
    }

    @Override
    String name() {
        return "ProcessCommand";
    }

    @Override
    boolean execute() {
        // реализация по добавлению данных в хранилище(объект класса processor)
        System.out.println("реализация ProcessCommand");
        return true;
    }
}
