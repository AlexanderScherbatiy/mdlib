package multidimensional.datatype.list;

public class MDLists {

    public static <T> MDList<T> empty() {
        return new MDEmptyList<>();
    }

    public static <T> MDList<T> list(T... values) {
        return list(0, values);
    }

    public static <T> MDList<T> list(T value, MDList<T> list) {
        return new MDListImpl<>(value, list);
    }

    private static <T> MDList<T> list(int index, T... values) {
        if (index == values.length) {
            return empty();
        } else {
            return new MDListImpl<T>(values[index], list(index + 1, values));
        }
    }
}
