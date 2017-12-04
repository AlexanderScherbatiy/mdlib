package multidimensional.datatype.list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class MDListTestUtils {


    public static <T> void checkEmpty(MDList<T> list) {
        assertTrue(list.isEmpty());

        try {
            list.getHead();
            fail("Missing exception: getHead()");
        } catch (MDListException ignore) {
        }

        try {
            list.getTail();
            fail("Missing exception: getTail()");
        } catch (MDListException ignore) {
        }
    }

    public static <T> void checkOneElement(T elem, MDList<T> list) {
        assertFalse(list.isEmpty());
        assertEquals(elem, list.getHead());
        assertTrue(list.getTail().isEmpty());
    }

    public static <T> void checkTwoElements(T elem1, T elem2, MDList<T> list) {
        assertFalse(list.isEmpty());
        assertEquals(elem1, list.getHead());
        assertEquals(elem2, list.getTail().getHead());
        assertTrue(list.getTail().getTail().isEmpty());
    }
}
