package multidimensional.datatype.tree;

import multidimensional.datatype.deep.DeepStructure;
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
    public MDList<MDTree<T>> getPath(MDTree<T> node) {

        if (this == node) {
            return MDLists.list(node);
        }

        for (MDTree<T> child : this.getChildren()) {
            MDList<MDTree<T>> path = child.getPath(node);

            if (!path.isEmpty()) {
                return MDLists.construct(this, path);
            }
        }

        return MDLists.empty();
    }

    @Override
    public boolean deepEquals(MDTree<T> other) {

        MDTree<T> tree1 = this;
        MDTree<T> tree2 = other;

        if (tree1.isEmpty() && tree2.isEmpty()) {
            return true;
        } else if (tree1.isEmpty() || tree2.isEmpty()) {
            return false;
        }

        if (!DeepStructure.deepEquals(tree1.getValue(), tree2.getValue())) {
            return false;
        }

        return tree1.getChildren().deepEquals(tree2.getChildren());
    }

    @Override
    public String toDeepString() {
        String childrenString = children.isEmpty() ? "" : children.toDeepString();
        return String.format("(%s%s)", getValue(), childrenString);
    }
}
