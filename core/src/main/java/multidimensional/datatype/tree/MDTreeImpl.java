package multidimensional.datatype.tree;

import multidimensional.datatype.list.MDList;
import multidimensional.datatype.list.MDLists;

public class MDTreeImpl<T> implements MDTree<T> {

    private final T value;
    private final MDList<MDTree<T>> children;

    public MDTreeImpl(T value) {
        this(value, MDLists.empty());
    }

    public MDTreeImpl(T value, MDTree<T>... children) {
        this(value, MDLists.list(children));
    }

    public MDTreeImpl(T value, MDList<MDTree<T>> children) {
        this.value = value;
        this.children = children;
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
        return children;
    }

    @Override
    public boolean deepEquals(MDTree<T> other) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toDeepString() {
        String childrenString = children.isEmpty() ? "" : children.toDeepString();
        return String.format("(%s%s)", getValue(), childrenString);
    }
}
