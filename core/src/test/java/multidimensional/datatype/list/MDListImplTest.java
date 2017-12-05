package multidimensional.datatype.list;

import org.junit.Test;

import static multidimensional.datatype.list.MDLists.list;
import static org.junit.Assert.*;
import static multidimensional.datatype.list.MDListTestUtils.*;

public class MDListImplTest {

    @Test
    public void testOneElem() {
        String elem1 = "elem1";
        MDList<String> list1 = new MDListImpl<>(elem1, new MDEmptyList<>());
        checkOneElement(elem1, list1);

        String elem2 = "elem2";
        MDList<String> list2 = new MDListImpl<>(elem2, list1);
        checkTwoElements(elem2, elem1, list2);
    }

    @Test
    public void filter() {
        String elem = "elem";
        MDList<String> list = new MDListImpl<>(elem, new MDEmptyList<>());
        checkEmpty(list.filter(e -> false));
        checkOneElement(elem, list.filter(e -> true));

        String elem1 = "elem1";
        String elem2 = "elem2";
        MDList<String> list2 = new MDListImpl<>(elem1, new MDListImpl<>(elem2, new MDEmptyList<>()));

        checkEmpty(list2.filter(e -> false));
        checkOneElement(elem1, list2.filter(e -> elem1.equals(e)));
        checkOneElement(elem1, list2.filter(e -> !elem2.equals(e)));
        checkOneElement(elem2, list2.filter(e -> elem2.equals(e)));
        checkOneElement(elem2, list2.filter(e -> !elem1.equals(e)));
        checkTwoElements(elem1, elem2, list2.filter(e -> true));
    }

    @Test
    public void testDeepEquals() {
        String elem = "elem";
        MDList<String> list1 = new MDListImpl<>(elem, new MDEmptyList<>());
        MDList<String> list2 = new MDListImpl<>(elem, new MDEmptyList<>());
        MDList<String> listOther = new MDListImpl<>("3", new MDEmptyList<>());

        checkDeepEquals(list1, list2, true);
        checkDeepEquals(list1, listOther, false);
        checkDeepEquals(list2, listOther, false);
    }
}
