package pattern.command;

/**
 * 抽象命令类
 */
public abstract class Command {

    public abstract int execute(int value);

    public abstract int undo();

    public abstract int redo();
}
