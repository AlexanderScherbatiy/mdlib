package multidimensional.datatype.tree;

import multidimensional.datatype.MDDatatypeException;
import multidimensional.datatype.list.MDList;

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
    public boolean deepEquals(MDTree<T> other) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toDeepString() {
        return "()";
    }
}
