package multidimensional.datatype.list;

import multidimensional.datatype.MDDatatypeException;

import java.util.Iterator;
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
        throw new MDDatatypeException("Head from Empty list.");
    }

    @Override
    public MDList<T> getTail() {
        throw new MDDatatypeException("Tail from Empty list.");
    }

    @Override
    public boolean deepEquals(MDList<T> other) {
        return other.isEmpty();
    }

    @Override
    public MDList<T> filter(Predicate<T> predicate) {
        return this;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public T next() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
