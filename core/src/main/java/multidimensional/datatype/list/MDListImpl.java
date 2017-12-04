package multidimensional.datatype.list;

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

            // TBD: Check deepEquals
            if (!list1.getHead().equals(list2.getHead())) {
                return false;
            }

            list1 = list1.getTail();
            list2 = list2.getTail();
        }

        return list1.isEmpty() && list2.isEmpty();
    }
}
