package patterns.command;

abstract public class Command {

    abstract String name();
    abstract boolean execute();

    protected TextProcessor processor;
    public Command(TextProcessor processor){
        this.processor = processor;
    }

}

/* команды */
// process cохранить
// repeat   повторить сохранение
// cancel   отменить ввод данных либо удаление последнего process или repeat
// exit