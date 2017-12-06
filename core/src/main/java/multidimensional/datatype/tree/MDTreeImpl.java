package multidimensional.datatype.tree;

import multidimensional.datatype.list.MDList;
import multidimensional.datatype.list.MDLists;

public class MDTreeImpl<T> implements MDTree<T> {

    private final T value;
    private final MDList<MDTree<T>> childreen;

    public MDTreeImpl(T value) {
        this(value, MDLists.empty());
    }

    public MDTreeImpl(T value, MDList<MDTree<T>> childreen) {
        this.value = value;
        this.childreen = childreen;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public MDList<MDTree<T>> getChildren() {
        return childreen;
    }
}
