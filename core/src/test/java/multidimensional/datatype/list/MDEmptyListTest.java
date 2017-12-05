package multidimensional.datatype.list;

import org.junit.Test;

import static multidimensional.datatype.list.MDListTestUtils.checkDeepEquals;
import static multidimensional.datatype.list.MDListTestUtils.checkEmpty;

public class MDEmptyListTest {

    @Test
    public void empty() {
        checkEmpty(new MDEmptyList<>());
    }

    @Test
    public void deepEquals() {
        checkDeepEquals(new MDEmptyList<>(), new MDEmptyList<>(), true);
    }

    @Test
    public void filter() {
        checkEmpty(new MDEmptyList<>().filter(e -> false));
        checkEmpty(new MDEmptyList<>().filter(e -> true));
    }
}
