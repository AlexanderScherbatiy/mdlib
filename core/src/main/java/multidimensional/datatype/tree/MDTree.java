package multidimensional.datatype.tree;

import multidimensional.datatype.deep.DeepStructure;
import multidimensional.datatype.list.MDList;

public interface MDTree<T> extends DeepStructure<MDTree<T>> {

    boolean isEmpty();

    T getValue();

    MDList<MDTree<T>> getChildren();
}
