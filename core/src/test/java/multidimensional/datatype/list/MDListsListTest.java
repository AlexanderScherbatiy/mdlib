package multidimensional.datatype.list;

import org.junit.Test;

import static multidimensional.datatype.list.MDListTestUtils.*;

public class MDListsListTest {

    @Test
    public void isEmpty() {
        checkEmpty(MDLists.list());
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
    public void headTailTwoElems() {
        String elem1 = "elem1";
        String elem2 = "elem2";
        checkTwoElements(elem1, elem2, MDLists.list(elem1, MDLists.list(elem2)));
    }
}
