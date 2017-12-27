package multidimensional.datatype;

import multidimensional.datatype.deep.DeepStructure;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class DeepStructureTest {


    @Test
    public void deepEquals() {
        checkDeepEquals("1", "1", true);
        checkDeepEquals("1", "2", false);
    }

    @Test
    public void deepDeepEquals() {
        checkDeepEquals(new DeepStructureImpl(), new DeepStructureImpl(), true);
        checkDeepEquals(new DeepStructureImpl("1", "2", "3"), new DeepStructureImpl("1", "2", "3"), true);
        checkDeepEquals(new DeepStructureImpl("1", "2", "3"), new DeepStructureImpl("1", "5", "3"), false);
        checkDeepEquals(new DeepStructureImpl("1", "2", "3"), new DeepStructureImpl("1", "2"), false);
        checkDeepEquals(new DeepStructureImpl("1", "2", "3"), new DeepStructureImpl("1", "2", "3", "4"), false);
    }

    private <T> void checkDeepEquals(T obj1, T obj2, boolean equals) {
        assertEquals(equals, DeepStructure.deepEquals(obj1, obj2));
        assertEquals(equals, DeepStructure.deepEquals(obj2, obj1));
    }

    static class DeepStructureImpl implements DeepStructure<DeepStructureImpl> {

        private final String[] array;

        public DeepStructureImpl(String... array) {
            this.array = array;
        }

        @Override
        public boolean deepEquals(DeepStructureImpl that) {
            return Arrays.equals(this.array, that.array);
        }

        @Override
        public String toDeepString() {
            throw new UnsupportedOperationException();
        }
    }
}
