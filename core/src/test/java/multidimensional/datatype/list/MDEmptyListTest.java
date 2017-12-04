package multidimensional.datatype.list;

import org.junit.Test;

import static multidimensional.datatype.list.MDListTestUtils.checkDeepEquals;
import static multidimensional.datatype.list.MDListTestUtils.checkEmpty;

public class MDEmptyListTest {

    @Test
    public void testEmptyList() {
        checkEmpty(new MDEmptyList<>());
    }

    @Test
    public void testDeepEquals() {
        checkDeepEquals(new MDEmptyList<>(), new MDEmptyList<>(), true);
    }
}
