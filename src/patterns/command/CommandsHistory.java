package patterns.command;

import java.util.Stack;

public class CommandsHistory {
    private Stack<Command> history = new Stack<>();  // любое хранилище Array , List

    public void addCommand(Command command){  // добавить комманду в историю
        history.push(command);
    }
    public Command delete(){        // удалить команду из истории
        return history.pop();
    }

    public boolean isEmpty(){
        return history.isEmpty();
    }

}
