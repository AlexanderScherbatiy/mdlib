package multidimensional.datatype.list;

import multidimensional.datatype.deep.DeepStructure;

import java.util.Iterator;
import java.util.function.Predicate;

class MDListImpl<T> implements MDList<T> {

    private final T head;
    private final MDList<T> tail;

    MDListImpl(T head, MDList<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public T getHead() {
        return head;
    }

    @Override
    public MDList<T> getTail() {
        return tail;
    }

    @Override
    public MDList<T> filter(Predicate<T> predicate) {
        return filter(predicate, this);
    }

    private static <U> MDList<U> filter(Predicate<U> predicate, MDList<U> list) {

        if (list.isEmpty()) return list;

        U elem = list.getHead();

        if (predicate.test(elem)) {
            return new MDListImpl<>(elem, filter(predicate, list.getTail()));
        } else {
            return filter(predicate, list.getTail());
        }
    }

    @Override
    public MDList<T> reverse() {

        MDList<T> list1 = this;
        MDList<T> list2 = MDLists.empty();

        while (!list1.isEmpty()) {
            list2 = MDLists.construct(list1.getHead(), list2);
            list1 = list1.getTail();
        }

        return list2;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            MDList<T> list = MDListImpl.this;

            @Override
            public boolean hasNext() {
                return !list.isEmpty();
            }

            @Override
            public T next() {
                T elem = list.getHead();
                list = list.getTail();
                return elem;
            }
        };
    }

    @Override
    public boolean deepEquals(MDList<T> other) {

        MDList<T> list1 = this;
        MDList<T> list2 = other;

        while (!list1.isEmpty() && !list2.isEmpty()) {

            T elem1 = list1.getHead();
            T elem2 = list2.getHead();

            if (!DeepStructure.deepEquals(elem1, elem2)) {
                return false;
            }

            list1 = list1.getTail();
            list2 = list2.getTail();
        }

        return list1.isEmpty() && list2.isEmpty();
    }

    @Override
    public String toDeepString() {

        StringBuilder builder = new StringBuilder();
        builder.append('(');

        for (T elem : this) {
            if (elem instanceof DeepStructure) {
                builder.append(((DeepStructure) elem).toDeepString());
            } else {
                builder.append(elem);
            }
            builder.append(", ");
        }

        int length = builder.length();
        builder.delete(length - 2, length - 0);
        builder.append(')');

        return builder.toString();
    }
}
