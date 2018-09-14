package pattern.adapter;

public class OperationAdapter implements ScoreOperation {

    private QuickSort sortObj;

    public OperationAdapter() {
        this.sortObj = new QuickSort();
    }

    @Override
    public Integer[] sort(int[] arr) {

        Integer[] integers = sortObj.quickSort(arr);

        return integers;
    }
}
