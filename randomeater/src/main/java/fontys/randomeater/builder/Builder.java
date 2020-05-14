package fontys.randomeater.builder;

public interface Builder<T> {
    void reset();
    T getResult();
}
