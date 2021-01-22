package pattern.iterator;

import java.util.ArrayList;
import java.util.List;

public abstract class ObjectList {

    protected List<Object> objects = new ArrayList<>();

    public ObjectList(List<Object> objects) {
        this.objects = objects;
    }

    public void addObject(Object obj) {
        this.objects.add(obj);
    }

    public void removeObject(Object obj) {
        this.objects.remove(obj);
    }

    public List getObjects() {

        return this.objects;
    }
    public abstract AbstractIterator  createIterator();


}
