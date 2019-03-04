package pattern.command;

public class Client {

    public static void main(String[] args) {
        Caculator caculator = new Caculator();
        Command addCommand = new AddCommand();
        caculator.setCommand(addCommand);

        caculator.computed(10);
        caculator.computed(5);
        caculator.computed(10);
        caculator.undo();
        caculator.undo();
        caculator.redo();
        caculator.redo();
    }
}
