package multidimensional.datatype.list;

import org.junit.Test;

import static multidimensional.datatype.list.MDLists.*;
import static multidimensional.datatype.list.MDListTestUtils.*;

public class MDListsListTest {

    @Test
    public void isEmpty() {
        checkEmpty(list());
    }

    @Test
    public void oneElem() {
        String elem = "elem";
        checkOneElement(elem, list(elem));
    }

    @Test
    public void twoElem() {
        String elem1 = "elem1";
        String elem2 = "elem2";
        checkTwoElements(elem1, elem2, list(elem1, elem2));
    }

    @Test
    public void headTailOneElem() {
        String elem = "elem";
        checkOneElement(elem, list(elem, empty()));
    }

    @Test
    public void headTailTwoElems() {
        String elem1 = "elem1";
        String elem2 = "elem2";
        checkTwoElements(elem1, elem2, list(elem1, list(elem2)));
    }

    @Test
    public void testDeepEquals() {

        checkDeepEquals(list(), list(), true);
        checkDeepEquals(list("elem"), list(), false);

        checkDeepEquals(list("elem"), list("elem"), true);
        checkDeepEquals(list("elem1"), list("elem2"), false);

        checkDeepEquals(list("elem2", "elem1"), list("elem2", "elem1"), true);
        checkDeepEquals(list("elem1", "elem2"), list("elem2", "elem1"), false);
        checkDeepEquals(list("elem"), list("elem1", "elem2"), false);
    }

    @Test
    public void testDeepDeepEquals() {

        checkDeepEquals(
                list(list("elem")),
                list(list("elem")),
                true);

        checkDeepEquals(
                list("elem"),
                list(list("elem")),
                false);

        checkDeepEquals(
                list(list("elem1", "elem2")),
                list(list("elem1", "elem2")),
                true);

        checkDeepEquals(
                list(list("elem1", "elem2")),
                list(list("elem1", "elem3")),
                false);

        checkDeepEquals(
                list(list(list("elem1"), list("elem2"))),
                list(list(list("elem1"), list("elem2"))),
                true);

        checkDeepEquals(
                list(list(list("elem1"), list("elem2"))),
                list(list(list("elem1"), list("elem3"))),
                false);

        checkDeepEquals(
                list(list(list("elem1"), list("elem2")), list(list("elem3"), list("elem4"))),
                list(list(list("elem1"), list("elem2")), list(list("elem3"), list("elem4"))),
                true);
    }
}
