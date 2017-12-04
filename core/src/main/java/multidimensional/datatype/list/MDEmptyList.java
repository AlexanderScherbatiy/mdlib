package multidimensional.datatype.list;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

class MDEmptyList<T> implements MDList<T> {

    MDEmptyList() {
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public T getHead() {
        throw new MDListException("Head from Empty list.");
    }

    @Override
    public MDList<T> getTail() {
        throw new MDListException("Tail from Empty list.");
    }
}
