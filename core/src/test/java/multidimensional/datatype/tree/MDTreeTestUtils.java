package multidimensional.datatype.tree;

import multidimensional.datatype.MDDatatypeException;
import multidimensional.datatype.list.MDList;
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

    public static <T> void checkPath(MDTree<T> root, MDTree<T> node, MDList<MDTree<T>> path) {
        assertTrue(root.getPath(node).deepEquals(path));
    }

    public static <T> void checkDeepEquals(MDTree<T> tree1, MDTree<T> tree2, boolean equals) {
        assertEquals(true, tree1.deepEquals(tree1));
        assertEquals(true, tree2.deepEquals(tree2));

        assertEquals(equals, tree1.deepEquals(tree2));
        assertEquals(equals, tree2.deepEquals(tree1));
    }

    public static <T> void checkToDeepString(MDTree<T> tree, String deepString) {
        assertEquals(deepString, tree.toDeepString());
    }
}