package pattern.command;

public class Caculator {

    private Command command;


    public void setCommand(Command command) {
        this.command = command;
    }

    public void computed(int value) {
        int execute = command.execute(value);
        System.out.println("入参："+value+",计算结果为："+execute);
    }

    public void undo() {
        int undo = command.undo();
        System.out.println("撤销操作，结果为："+undo);
    }

    public void redo() {
        int redo = command.redo();
        System.out.println("恢复操作：结果为："+ redo);
    }
}
