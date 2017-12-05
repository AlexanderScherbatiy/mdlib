package multidimensional.datatype.list;

import multidimensional.datatype.deep.DeepStructure;

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
    public boolean deepEquals(MDList<T> other) {

        MDList<T> list1 = this;
        MDList<T> list2 = other;

        while (!list1.isEmpty() && !list2.isEmpty()) {

            T elem1 = list1.getHead();
            T elem2 = list2.getHead();

            if (elem1 instanceof DeepStructure && elem2 instanceof DeepStructure) {

                DeepStructure deepElem1 = (DeepStructure) elem1;
                DeepStructure deepElem2 = (DeepStructure) elem2;

                if (!deepElem1.deepEquals(deepElem2)) {
                    return false;
                }

            } else if (!elem1.equals(elem2)) {
                return false;
            }

            list1 = list1.getTail();
            list2 = list2.getTail();
        }

        return list1.isEmpty() && list2.isEmpty();
    }
}
