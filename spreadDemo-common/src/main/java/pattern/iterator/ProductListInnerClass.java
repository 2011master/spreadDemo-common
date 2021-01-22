package pattern.iterator;

import java.util.List;

public class ProductListInnerClass extends ObjectList{

    public ProductListInnerClass(List<Object> objects) {
        super(objects);
    }

    @Override
    public AbstractIterator createIterator() {

        return new ProductIterator();
    }

    //商品迭代器：内部类实现
    private class ProductIterator implements AbstractIterator {

     
        private int cursor1;

        private int cursor2;

        public ProductIterator() {
            cursor1 = 0;
            cursor2 = objects.size() - 1;

        }

        @Override
        public void previous() {
            if (cursor2 > -1) {
                cursor2--;
            }
        }

        @Override
        public void next() {
            if (cursor1 < objects.size()) {
                cursor1++;
            }
        }

        @Override
        public boolean isFirst() {
            return cursor2 == -1;
        }

        @Override
        public boolean isLast() {

            return cursor1 == objects.size();
        }

        @Override
        public Object getPreviousItem() {

            return objects.get(cursor2);
        }

        @Override
        public Object getNextItem() {
            return objects.get(cursor1);
        }
    }

}
