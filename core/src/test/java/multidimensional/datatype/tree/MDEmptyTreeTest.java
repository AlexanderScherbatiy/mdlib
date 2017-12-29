package multidimensional.datatype.tree;

import multidimensional.datatype.list.MDLists;
import org.junit.Test;

import static multidimensional.datatype.tree.MDTreeTestUtils.*;

public class MDEmptyTreeTest {


    @Test
    public void empty() {
        checkEmpty(new MDEmptyTree<>());
    }

    @Test
    public void path() {
        checkPath(new MDEmptyTree<>(), new MDEmptyTree<>(), MDLists.empty());
    }

    @Test
    public void deepEquals() {
        checkDeepEquals(new MDEmptyTree<>(), new MDEmptyTree<>(), true);
    }

    @Test
    public void deepToString() {
        checkToDeepString(new MDEmptyTree<>(), "()");
    }
}
