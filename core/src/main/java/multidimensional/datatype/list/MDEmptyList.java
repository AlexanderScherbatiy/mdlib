package multidimensional.datatype.list;

import java.util.function.Predicate;

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

    @Override
    public boolean deepEquals(MDList<T> other) {
        return other.isEmpty();
    }

    @Override
    public MDList<T> filter(Predicate<T> predicate) {
        return this;
    }
}
