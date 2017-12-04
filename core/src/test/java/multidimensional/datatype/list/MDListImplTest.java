package multidimensional.datatype.list;

import org.junit.Test;

import static org.junit.Assert.*;

public class MDListImplTest {


    @Test
    public void testOneElem() {
        String elem1 = "elem1";
        MDList<String> list1 = new MDListImpl<>(elem1, new MDEmptyList<>());
        MDListTestUtils.checkOneElement(elem1, list1);

        String elem2 = "elem2";
        MDList<String> list2 = new MDListImpl<>(elem2, list1);
        MDListTestUtils.checkTwoElements(elem2, elem1, list2);
    }

    @Test
    public void testDeepEquals() {
        String elem = "elem";
        MDList<String> list1 = new MDListImpl<>(elem, new MDEmptyList<>());
        MDList<String> list2 = new MDListImpl<>(elem, new MDEmptyList<>());
        MDList<String> listOther = new MDListImpl<>("3", new MDEmptyList<>());

        MDListTestUtils.checkDeepEquals(list1, list2, true);
        MDListTestUtils.checkDeepEquals(list1, listOther, false);
        MDListTestUtils.checkDeepEquals(list2, listOther, false);
    }
}
