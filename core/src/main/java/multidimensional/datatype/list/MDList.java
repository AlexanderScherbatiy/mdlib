package multidimensional.datatype.list;

import multidimensional.datatype.deep.DeepStructure;

public interface MDList<T> extends DeepStructure<MDList<T>> {

    boolean isEmpty();

    T getHead();

    MDList<T> getTail();
}
