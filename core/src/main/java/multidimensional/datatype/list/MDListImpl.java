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
}
