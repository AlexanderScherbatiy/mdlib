package multidimensional.datatype.list;

public interface MDList<T> {

    boolean isEmpty();

    T getHead();

    MDList<T> getTail();
}
