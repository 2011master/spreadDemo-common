package pattern.iterator;

import java.util.List;

public class ProductList extends ObjectList{

    public ProductList(List<Object> objects) {
        super(objects);
    }

    @Override
    public AbstractIterator createIterator() {

        return new ProductIterator(this);
    }
}
