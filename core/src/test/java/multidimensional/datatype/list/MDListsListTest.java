package multidimensional.datatype.list;

import org.junit.Test;

import static org.junit.Assert.*;

public class MDListsListTest {

    @Test
    public void isEmpty() {
        MDList<String> empty = MDLists.list();
        assertTrue(empty.isEmpty());
    }

    @Test
    public void oneElem() {
        String elem = "elem";
        checkOneElement(elem, MDLists.list(elem));
    }

    @Test
    public void twoElem() {
        String elem1 = "elem1";
        String elem2 = "elem2";
        checkTwoElements(elem1, elem2, MDLists.list(elem1, elem2));
    }

    @Test
    public void headTailOneElem() {
        String elem = "elem";
        checkOneElement(elem, MDLists.list(elem, MDLists.empty()));
    }

    @Test
    public void headTailTwoElem() {
        String elem1 = "elem1";
        String elem2 = "elem2";
        checkTwoElements(elem1, elem2, MDLists.list(elem1, MDLists.list(elem2)));
    }

    private <T> void checkOneElement(T elem, MDList<T> list) {
        assertFalse(list.isEmpty());
        assertEquals(elem, list.getHead());
        assertTrue(list.getTail().isEmpty());
    }

    private <T> void checkTwoElements(T elem1, T elem2, MDList<T> list) {
        assertFalse(list.isEmpty());
        assertEquals(elem1, list.getHead());
        assertEquals(elem2, list.getTail().getHead());
        assertTrue(list.getTail().getTail().isEmpty());
    }
}
