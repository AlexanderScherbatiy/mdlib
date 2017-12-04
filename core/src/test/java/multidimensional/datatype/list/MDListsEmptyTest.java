package multidimensional.datatype.list;

import org.junit.Test;

public class MDListsEmptyTest {

    @Test
    public void isEmpty() {
        MDEmptyListTest.isEmpty(MDLists.empty());
    }

    @Test(expected = RuntimeException.class)
    public void getHead() {
        MDEmptyListTest.getHead(MDLists.empty());
    }

    @Test(expected = RuntimeException.class)
    public void getTail() {
        MDEmptyListTest.getTail(MDLists.empty());
    }
}
