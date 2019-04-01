package pattern.iterator;

public   interface AbstractIterator {

    void previous();

    void next();

    boolean isLast();

    boolean isFirst();

    Object getPreviousItem();

    Object getNextItem();

}
