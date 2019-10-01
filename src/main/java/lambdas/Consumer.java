package lambdas;

@FunctionalInterface
public interface Consumer<T> {

    void accept(T t);

    default Consumer<T> andThen(Consumer<T> c2) {
        return (T t) -> {
            this.accept(t);
            c2.accept(t);
        };
    }
}
