package multidimensional.datatype.tree;

import multidimensional.datatype.list.MDLists;
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

    @Test
    public void path() {
        String parent = "parent";
        String child1 = "child1";
        String child2 = "child2";

        MDTree<String> empty = MDTrees.empty();

        MDTree<String> node = tree(parent);
        checkPath(empty, node, MDLists.empty());
        checkPath(node, empty, MDLists.empty());

        checkPath(node, node, list(node));

        MDTree<String> node1 = tree(child1);
        MDTree<String> node2 = tree(child2);
        MDTree<String> root = tree(parent, node1, node2);

        checkPath(root, root, list(root));
        checkPath(root, node1, list(root, node1));
        checkPath(root, node2, list(root, node2));
    }
}