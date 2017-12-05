package multidimensional.datatype.tree;

import multidimensional.datatype.MDDatatypeException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class MDTreeTestUtils {

    public static <T> void checkEmpty(MDTree<T> tree) {

        assertTrue(tree.isEmpty());

        try {
            tree.getValue();
            fail("Missing exception: getValue()");
        } catch (MDDatatypeException ignore) {
        }

        try {
            tree.getChildren();
            fail("Missing exception: getChildren()");
        } catch (MDDatatypeException ignore) {
        }
    }
}
