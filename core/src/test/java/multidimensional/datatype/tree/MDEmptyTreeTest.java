package multidimensional.datatype.tree;

import org.junit.Test;

import static multidimensional.datatype.tree.MDTreeTestUtils.*;

public class MDEmptyTreeTest {


    @Test
    public void empty() {
        checkEmpty(new MDEmptyTree<>());
    }


    @Test
    public void deepToString() {
        checkToDeepString(new MDEmptyTree<>(), "()");
    }
}
