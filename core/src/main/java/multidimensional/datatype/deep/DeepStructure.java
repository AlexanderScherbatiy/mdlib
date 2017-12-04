package multidimensional.datatype.deep;

public interface DeepStructure<T extends DeepStructure<T>> {

    boolean deepEquals(T other);
}
