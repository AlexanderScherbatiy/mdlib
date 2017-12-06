package multidimensional.datatype.list;

import multidimensional.datatype.deep.DeepStructure;

import java.util.function.Predicate;

public interface MDList<T> extends Iterable<T>, DeepStructure<MDList<T>> {

    boolean isEmpty();

    T getHead();

    MDList<T> getTail();

    MDList<T> filter(Predicate<T> predicate);
}
