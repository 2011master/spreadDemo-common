package pattern.command;

import java.util.HashMap;
import java.util.Map;

/**
 * 具体命令类1，加法操作
 */
public class AddCommand extends Command {

    private int value;
    private Adder adder = new Adder();
    private static int count = 0;
    private static Map<Integer, Integer> operaterDb = new HashMap<>();

    @Override
    public int execute(int value) {
        operaterDb.put(++count, value);
        this.value = value;
        return adder.add(value);
    }

    @Override
    public int undo() {
        if (count == 0) {
            System.out.println("不能继续撤销");
            return 0;
        }
        System.out.println("撤销值为："+operaterDb.get(count));
        return adder.add(-operaterDb.get(count--));
    }

    @Override
    public int redo() {
        if (operaterDb.size() == count) {
            System.out.println("不能继续恢复");
            return adder.add(0);
        }
        System.out.println("恢复值为："+ operaterDb.get(count));
        return adder.add(operaterDb.get(count++));
    }
}
