package multidimensional.datatype.list;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static multidimensional.datatype.list.MDLists.*;
import static multidimensional.datatype.list.MDListTestUtils.*;

public class MDListsTest {

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
    public void constructOneElem() {
        String elem = "elem";
        checkOneElement(elem, construct(elem, empty()));
    }

    @Test
    public void constructTwoElems() {
        String elem1 = "elem1";
        String elem2 = "elem2";
        checkTwoElements(elem1, elem2, construct(elem1, list(elem2)));
    }

    @Test
    public void iterator() {
        String[] elems = {"one", "two", "three"};
        checkIterator(list(elems), elems);
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

    @Test
    public void deepString() {
        checkToDeepString(list(), "()");
        checkToDeepString(list("one"), "(one)");
        checkToDeepString(list("one", "two"), "(one, two)");
        checkToDeepString(list("one", "two", "three"), "(one, two, three)");
    }

    @Test
    public void deepDeepString() {
        checkToDeepString(list(list("one")), "((one))");
        checkToDeepString(list(list("one"), "two"), "((one), two)");
        checkToDeepString(list("one", list("two")), "(one, (two))");
        checkToDeepString(list(list("one"), list("two")), "((one), (two))");
    }
}
