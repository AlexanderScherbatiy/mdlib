package multidimensional.datatype.list;

import org.junit.Test;

import static org.junit.Assert.*;

public class MDEmptyListTest {

    @Test
    public void isEmpty() {
        isEmpty(new MDEmptyList<>());
    }

    @Test(expected = RuntimeException.class)
    public void getHead() {
        getHead(new MDEmptyList<>());
    }

    @Test(expected = RuntimeException.class)
    public void getTail() {
        getTail(new MDEmptyList<>());
    }

    public static <T> void isEmpty(MDList<T> list) {
        assertTrue(list.isEmpty());
    }

    public static <T> void getHead(MDList<T> list) {
        list.getHead();
    }

    public static <T> void getTail(MDList<T> list) {
        list.getTail();
    }
}
