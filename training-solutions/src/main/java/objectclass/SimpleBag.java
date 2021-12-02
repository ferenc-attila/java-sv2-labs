package objectclass;

import java.util.ArrayList;
import java.util.List;

public class SimpleBag {

    private List<Object> items = new ArrayList<>();
    private int cursorIndex;

    public SimpleBag() {
        beforeFirst();
    }

    public void putItem(Object item) {
        items.add(item);
    }

    public boolean isEmpty() {
        return (items.size() == 0);
    }

    public int size() {
        return items.size();
    }

    public void beforeFirst() {
        cursorIndex = -1;
    }

    public boolean hasNext() {
        return !(isEmpty() || cursorIndex >= items.size() - 1);
    }

    public Object next() {
        cursorIndex++;
        return items.get(cursorIndex);
    }

    public boolean contains(Object item) {
        return (items.contains(item));
    }

    public int getCursorIndex() {
        return cursorIndex;
    }
}
