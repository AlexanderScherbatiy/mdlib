package multidimensional.datatype.tree;

import multidimensional.datatype.list.MDList;

public interface MDTree<T> {

    boolean isEmpty();

    T getValue();

    MDList<MDTree<T>> getChildren();
}
