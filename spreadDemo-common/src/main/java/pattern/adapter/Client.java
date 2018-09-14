package pattern.adapter;

public class Client {

    public static void main(String[] args) {

        int[] ints = {80, 87, 88, 99, 92, 95};
        ScoreOperation operation = new OperationAdapter();
        Integer[] sort = operation.sort(ints);
        System.out.println("结果："+sort);
    }
}
