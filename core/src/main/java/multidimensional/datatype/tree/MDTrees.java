package multidimensional.datatype.tree;

import multidimensional.datatype.list.MDList;
import multidimensional.datatype.list.MDLists;

public class MDTrees {

    public static <T> MDTree<T> tree(T value, MDList<MDTree<T>> children) {
        return new MDTreeImpl<T>(value, children);
    }

    public static <T> MDTree<T> tree(T value, MDTree<T>... children) {
        return tree(value, MDLists.list(children));
    }
}
