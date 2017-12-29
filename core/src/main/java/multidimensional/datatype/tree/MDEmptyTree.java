package multidimensional.datatype.tree;

import multidimensional.datatype.MDDatatypeException;
import multidimensional.datatype.list.MDList;
import multidimensional.datatype.list.MDLists;

public class MDEmptyTree<T> implements MDTree<T> {

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public T getValue() {
        throw new MDDatatypeException("Get value from Empty tree.");
    }

    @Override
    public MDList<MDTree<T>> getChildren() {
        throw new MDDatatypeException("Get children from Empty tree.");
    }


    @Override
    public MDList<MDTree<T>> getPath(MDTree<T> node) {
        return MDLists.empty();
    }

    @Override
    public boolean deepEquals(MDTree<T> other) {
        return other.isEmpty();
    }

    @Override
    public String toDeepString() {
        return "()";
    }
}
