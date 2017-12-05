package multidimensional.datatype.list;

import org.junit.Test;

import static multidimensional.datatype.list.MDListTestUtils.*;

public class MDListsEmptyTest {

    @Test
    public void isEmpty() {
        checkEmpty(MDLists.empty());
    }
}
