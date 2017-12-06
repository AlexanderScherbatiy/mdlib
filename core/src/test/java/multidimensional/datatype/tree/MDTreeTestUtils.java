package multidimensional.datatype.tree;

import multidimensional.datatype.MDDatatypeException;
import multidimensional.datatype.list.MDLists;

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

    public static <T> void checkOneLevel(T elem, MDTree<T> tree) {
        assertFalse(tree.isEmpty());
        assertEquals(elem, tree.getValue());
        assertTrue(tree.getChildren().isEmpty());
    }

    public static <T> void checkTwoLevels(T elem, MDTree<T> tree, T... children) {
        assertFalse(tree.isEmpty());
        assertEquals(elem, tree.getValue());
        assertFalse(tree.getChildren().isEmpty());
        int i = 0;
        for (MDTree<T> child : tree.getChildren()) {
            checkOneLevel(children[i++], child);
        }
        assertEquals(children.length, i);
    }
}