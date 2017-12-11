package multidimensional.datatype.tree;

import org.junit.Test;

import static multidimensional.datatype.list.MDLists.*;
import static multidimensional.datatype.tree.MDTrees.*;
import static multidimensional.datatype.tree.MDTreeTestUtils.*;

public class MDTreesTest {

    @Test
    public void oneLevelTree() {
        String elem = "elem";
        checkOneLevel(elem, tree(elem));
    }

    @Test
    public void twoLevelsTree() {
        String parent = "parent";
        String child1 = "child1";
        String child2 = "child2";

        MDTree<String> tree = tree(parent, list(tree(child1), tree(child2)));
        checkTwoLevels(parent, tree, child1, child2);

        tree = tree(parent, tree(child1), tree(child2));
        checkTwoLevels(parent, tree, child1, child2);
    }
}
