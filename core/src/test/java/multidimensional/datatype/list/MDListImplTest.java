package multidimensional.datatype.list;

import org.junit.Test;

import static org.junit.Assert.*;

public class MDListImplTest {

    @Test
    public void isEmpty() {
        MDList<String> list = new MDListImpl<>("elem", new MDEmptyList<>());
        assertFalse(list.isEmpty());
    }

    @Test
    public void getHead() {
        String elem = "elem";
        MDList<String> list = new MDListImpl<>(elem, new MDEmptyList<>());
        assertEquals(elem, list.getHead());
    }

    @Test
    public void getTail() {
        MDList<String> list = new MDListImpl<>("elem", new MDEmptyList<>());
        assertTrue(list.getTail().isEmpty());
    }
}
