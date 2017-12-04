package multidimensional.datatype.list;

import org.junit.Test;

public class MDListsEmptyTest {

    @Test
    public void isEmpty() {
        MDListTestUtils.checkEmpty(MDLists.empty());
    }
}
