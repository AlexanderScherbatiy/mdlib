package multidimensional.datatype.tree;


import multidimensional.datatype.list.MDList;
import multidimensional.datatype.list.MDLists;
import org.junit.Test;

import static multidimensional.datatype.tree.MDTreeTestUtils.*;

public class MDTreeImplTest {

    @Test
    public void oneLevelTree() {
        String elem = "elem";
        checkOneLevel(elem, new MDTreeImpl<>(elem));
    }

    @Test
    public void twoLevelsTree() {
        String parent = "parent";
        String child1 = "child1";
        String child2 = "child2";

        MDTree<String> tree = new MDTreeImpl<>(parent,
                MDLists.list(new MDTreeImpl<>(child1), new MDTreeImpl<>(child2)));
        checkTwoLevels(parent, tree, child1, child2);
    }

    @Test
    public void deepEquals() {

        checkDeepEquals(new MDTreeImpl<>("1"), new MDTreeImpl<>("1"), true);
        checkDeepEquals(new MDTreeImpl<>("1"), new MDTreeImpl<>("2"), false);
        checkDeepEquals(new MDTreeImpl<>("2"), new MDTreeImpl<>("1"), false);

        String parent = "parent";
        String child1 = "child1";
        String child2 = "child2";

        MDTree<String> tree1 = new MDTreeImpl<>(parent,
                MDLists.list(new MDTreeImpl<>(child1), new MDTreeImpl<>(child2)));
        MDTree<String> tree2 = new MDTreeImpl<>(parent,
                MDLists.list(new MDTreeImpl<>(child1), new MDTreeImpl<>(child2)));
        MDTree<String> tree3 = new MDTreeImpl<>(parent);
        MDTree<String> tree4 = new MDTreeImpl<>("test",
                MDLists.list(new MDTreeImpl<>(child1), new MDTreeImpl<>(child2)));
        MDTree<String> tree5 = new MDTreeImpl<>(parent,
                MDLists.list(new MDTreeImpl<>(child1)));

        checkDeepEquals(tree1, tree2, true);
        checkDeepEquals(tree1, tree3, false);
        checkDeepEquals(tree1, tree4, false);
        checkDeepEquals(tree1, tree5, false);
    }

    @Test
    public void deepToString() {
        checkToDeepString(new MDTreeImpl<>("elem"), "(elem)");

        MDTree<String> tree = new MDTreeImpl<>("parent",
                new MDTreeImpl<>("child1"), new MDTreeImpl<>("child2"));
        checkToDeepString(tree, "(parent((child1), (child2)))");
    }
}
