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
        throw new RuntimeException("Head from Empty list.");
    }

    @Override
    public MDList<T> getTail() {
        throw new RuntimeException("Tail from Empty list.");
    }
}
