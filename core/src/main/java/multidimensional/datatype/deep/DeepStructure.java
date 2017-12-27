package multidimensional.datatype.deep;

import java.util.Objects;

public interface DeepStructure<T extends DeepStructure<T>> {

    boolean deepEquals(T other);

    String toDeepString();


    static <T> boolean deepEquals(T obj1, T obj2) {

        if (obj1 instanceof DeepStructure && obj2 instanceof DeepStructure) {

            DeepStructure deepObj1 = (DeepStructure) obj1;
            DeepStructure deepObj2 = (DeepStructure) obj2;

            return deepObj1.deepEquals(deepObj2);
        }

        return Objects.equals(obj1, obj2);
    }
}
